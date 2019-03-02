package net.snofox.minecraft.snolib;

import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Josh on 2018-12-27
 */
public class GameTickCounter extends BukkitRunnable {
    static int gameTick = 0;

    @Override
    public void run() {
        ++gameTick;
    }
}
