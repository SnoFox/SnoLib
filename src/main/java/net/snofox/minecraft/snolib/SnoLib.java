package net.snofox.minecraft.snolib;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Josh on 2018-09-15
 */
public class SnoLib extends JavaPlugin {
    private SubmergeTracker submergeTracker;

    @Override
    public void onEnable() {
        getLogger().info("SnoLib enabled!");
    }

    @Override
    public void onDisable() {
        if(submergeTracker != null) submergeTracker.destroy();
    }

    public void enableSubmergeTracking(final boolean allEntities) {
        if(submergeTracker == null) submergeTracker = new SubmergeTracker(this);
        submergeTracker.setupTracker(allEntities);
    }
}
