package net.snofox.minecraft.snolib.numbers;

import java.util.Random;

/**
 * Created by Josh on 2020-01-04
 */
public class RandomUtil {
    private static Random random = null;

    public static Random getRandom() {
        if(random == null) initRandom();
        return random;
    }

    private static void initRandom() {
        random = new java.util.Random();
        for(int i = 0; i < 10; i++) random.nextFloat();
        random.setSeed(random.nextLong()^random.nextLong());
        for(int i = 0; i < 100; i++) random.nextLong();
    }
}
