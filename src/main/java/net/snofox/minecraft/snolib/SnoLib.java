package net.snofox.minecraft.snolib;

import org.apache.commons.lang3.ClassUtils;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Josh on 2018-09-15
 */
public class SnoLib extends JavaPlugin {
    static boolean debug = false;
    private SubmergeTracker submergeTracker;

    public static void debug(final String s) {
        if(!debug) return;
        final StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        final String className = ClassUtils.getAbbreviatedName(stack[2].getClassName(), 2);
        final String method = stack[2].getMethodName();
        getPlugin(SnoLib.class).getLogger().info("[DEBUG] " + className + " in " + method + "(): " + s);
    }

    @Override
    public void onEnable() {
        getLogger().info("SnoLib enabled!");
        debug = getConfig().getBoolean("debugLogs", false);
        getServer().getPluginManager().registerEvents(new RecipeDiscoveryListener(), this);
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new GameTickCounter(), 1, 1);
    }

    @Override
    public void onDisable() {
        if(submergeTracker != null) submergeTracker.destroy();
    }

    public void enableSubmergeTracking(final boolean allEntities) {
        if(submergeTracker == null) submergeTracker = new SubmergeTracker(this);
        submergeTracker.setupTracker(allEntities);
    }

    public int getGameTick() {
        return GameTickCounter.gameTick;
    }
}
