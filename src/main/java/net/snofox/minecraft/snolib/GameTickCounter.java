package net.snofox.minecraft.snolib;

/**
 * Created by Josh on 2018-12-27
 */
public class GameTickCounter implements Runnable {
    static int gameTick = 0;

    @Override
    public void run() {
        ++gameTick;
    }
}
