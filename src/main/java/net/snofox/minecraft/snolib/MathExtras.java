package net.snofox.minecraft.snolib;

/**
 * Created by Josh on 2020-01-05
 */
public class MathExtras {
    public static int clamp(final int value, final int lo, final int hi) {
        return Math.min(hi, Math.max(value, lo));
    }
}
