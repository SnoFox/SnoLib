package net.snofox.minecraft.snolib;

import com.google.common.collect.ImmutableList;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Josh on 2018-09-15
 */
public class SubmergeTracker implements Listener {
    final private SnoLib module;
    final private Set<UUID> submergedEntites;
    private int taskId = -1;
    private boolean trackingAll = false;

    SubmergeTracker(final SnoLib snolib) {
        module = snolib;
        submergedEntites = new HashSet<>();
        module.getServer().getPluginManager().registerEvents(this, module);
    }

    void setupTracker(final boolean shouldTrackAll) {
        if(taskId > -1 && trackingAll && shouldTrackAll) return;
        module.getServer().getScheduler().cancelTask(taskId);
        if(shouldTrackAll)
            taskId = module.getServer().getScheduler().scheduleSyncRepeatingTask(module, this::runAllCheck, 1, 40);
        else
            taskId = module.getServer().getScheduler().scheduleSyncRepeatingTask(module, this::runPlayerChecks, 1, 10);
        if(taskId < 0)
            module.getLogger().warning("Failed to schedule task. EntitySubmergeEvents will not fire.");
    }

    void destroy() {
        if(taskId > -1)
            module.getServer().getScheduler().cancelTask(taskId);
        taskId = -1;
        trackingAll = false;
    }

    private void runPlayerChecks() {
        for(Player p : module.getServer().getOnlinePlayers())
            recordSubmerged(p, checkSubmerged(p));
    }

    private void runAllCheck() {
        for(World w : module.getServer().getWorlds()) {
            for(Entity e : w.getEntities()) {
                if(e instanceof LivingEntity) {
                    LivingEntity le = (LivingEntity) e;
                    recordSubmerged(le, checkSubmerged(le));
                }
            }
        }
    }

    private boolean checkSubmerged(final LivingEntity e) {
        return e.getEyeLocation().getBlock().isLiquid();
    }

    private void recordSubmerged(final LivingEntity e, final boolean submerged) {
        boolean fireEvent = false;
        if(submerged) fireEvent = submergedEntites.add(e.getUniqueId());
        else fireEvent = submergedEntites.remove(e.getUniqueId());
        if(fireEvent) fireEvent(e, submerged);
    }

    private void handleDespawn(final LivingEntity e) {
        submergedEntites.remove(e.getUniqueId());
    }

    private void handleDespawn(final List<Entity> entities) {
        for(Entity e : entities)
            if(e instanceof LivingEntity)
                handleDespawn((LivingEntity)e);
    }

    private void fireEvent(final LivingEntity e, final boolean submerged) {
        module.getServer().getPluginManager().callEvent(new EntitySubmergedEvent(e, submerged));
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerQuit(final PlayerQuitEvent ev) {
        handleDespawn(ev.getPlayer());
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onChunkUnload(final ChunkUnloadEvent ev) {
        if(trackingAll) handleDespawn(ImmutableList.copyOf(ev.getChunk().getEntities()));
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onWorldUnload(final WorldUnloadEvent ev) {
        if(trackingAll) handleDespawn(ev.getWorld().getEntities());
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onEntityDeath(final EntityDeathEvent ev) {
        if(trackingAll) handleDespawn(ev.getEntity());
    }
}
