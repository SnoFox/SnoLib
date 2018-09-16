package net.snofox.minecraft.snolib;

import org.bukkit.block.BlockFace;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Josh on 2018-09-16
 */
public class BlockFacingTests {
    @Test
    public void ensurePositiveCardinalSouth() {
        float angle = 0;
        while(angle < 45f) {
            System.out.println("Testing angle " + angle);
            Assert.assertEquals(BlockFacing.getCardinalBlockFace(angle++), BlockFace.SOUTH);
        }
        angle = 315;
        while(angle < 360f) {
            System.out.println("Testing angle " + angle);
            Assert.assertEquals(BlockFacing.getCardinalBlockFace(angle++), BlockFace.SOUTH);
        }
    }

    @Test
    public void ensurePositiveCardinalWest() {
        float angle = 45;
        while(angle < 135f) {
            System.out.println("Testing angle " + angle);
            Assert.assertEquals(BlockFacing.getCardinalBlockFace(angle++), BlockFace.WEST);
        }
    }

    @Test
    public void ensurePositiveCardinalNorth() {
        float angle = 135;
        while(angle < 225f) {
            System.out.println("Testing angle " + angle);
            Assert.assertEquals(BlockFacing.getCardinalBlockFace(angle++), BlockFace.NORTH);
        }
    }

    @Test
    public void ensurePositiveCardinalEast() {
        float angle = 225;
        while(angle < 315f) {
            System.out.println("Testing angle " + angle);
            Assert.assertEquals(BlockFacing.getCardinalBlockFace(angle++), BlockFace.EAST);
        }
    }

    @Test
    public void ensureNegativeCardinalSouth() {
        float angle = 0;
        while(angle > -46f) {
            System.out.println("Testing angle " + angle);
            Assert.assertEquals(BlockFacing.getCardinalBlockFace(angle--), BlockFace.SOUTH);
        }
    }

    @Test
    public void ensureNegativeCardinalEast() {
        float angle = -46;
        while(angle > -135f) {
            System.out.println("Testing angle " + angle);
            Assert.assertEquals(BlockFacing.getCardinalBlockFace(angle--), BlockFace.EAST);
        }
    }

    @Test
    public void ensureNegativeCardinalNorth() {
        float angle = -136;
        while(angle > -226f) {
            System.out.println("Testing angle " + angle);
            Assert.assertEquals(BlockFacing.getCardinalBlockFace(angle--), BlockFace.NORTH);
        }
    }

    @Test
    public void ensureNegativeCardinalWest() {
        float angle = -226;
        while(angle > -316f) {
            System.out.println("Testing angle " + angle);
            Assert.assertEquals(BlockFacing.getCardinalBlockFace(angle--), BlockFace.WEST);
        }
    }

    @Test
    public void ensureOverrotatedCardinalSouth() {
        float angle = 675;
        while(angle < 765) {
            System.out.println("Testing angle " + angle);
            Assert.assertEquals(BlockFacing.getCardinalBlockFace(angle++), BlockFace.SOUTH);
        }
    }

    @Test
    public void ensureOverrotatedCardinalNorth() {
        float angle = 855;
        while(angle < 945) {
            System.out.println("Testing angle " + angle);
            Assert.assertEquals(BlockFacing.getCardinalBlockFace(angle++), BlockFace.NORTH);
        }
    }

    @Test
    public void ensureOverrotatedNegativeCardinalSouth() {
        float angle = -855;
        while(angle > 945) {
            System.out.println("Testing angle " + angle);
            Assert.assertEquals(BlockFacing.getCardinalBlockFace(angle++), BlockFace.SOUTH);
        }
    }

    @Test
    public void ensureIntermediaries() {
        Assert.assertEquals(BlockFacing.getIntermediateBlockFace( 0f), BlockFace.SOUTH);
        Assert.assertEquals(BlockFacing.getIntermediateBlockFace( 45f), BlockFace.SOUTH_WEST);
        Assert.assertEquals(BlockFacing.getIntermediateBlockFace( 90f), BlockFace.WEST);
        Assert.assertEquals(BlockFacing.getIntermediateBlockFace( 135f), BlockFace.NORTH_WEST);
        Assert.assertEquals(BlockFacing.getIntermediateBlockFace( 180f), BlockFace.NORTH);
        Assert.assertEquals(BlockFacing.getIntermediateBlockFace( 225f), BlockFace.NORTH_EAST);
        Assert.assertEquals(BlockFacing.getIntermediateBlockFace( 260f), BlockFace.EAST);
        Assert.assertEquals(BlockFacing.getIntermediateBlockFace( 305f), BlockFace.SOUTH_EAST);
    }

    @Test
    public void ensurePositiveSouthernSecondaryIntermediaries() {
        float angle = 0;
        while(angle < 12)
            Assert.assertEquals(getAndPrintSecondaryIntermediateAngle(angle++), BlockFace.SOUTH);
        while(angle < 34)
            Assert.assertEquals(getAndPrintSecondaryIntermediateAngle(angle++), BlockFace.SOUTH_SOUTH_WEST);
        while(angle < 57)
            Assert.assertEquals(getAndPrintSecondaryIntermediateAngle(angle++),  BlockFace.SOUTH_WEST);
        while(angle < 79)
            Assert.assertEquals(getAndPrintSecondaryIntermediateAngle(angle++),  BlockFace.WEST_SOUTH_WEST);
    }

    @Test
    public void ensureNegativeNorthernSecondaryIntermediaries() {
        float angle = -113;
        while(angle > -124)
            Assert.assertEquals(getAndPrintSecondaryIntermediateAngle(angle--),  BlockFace.EAST_NORTH_EAST);
        while(angle > -147)
            Assert.assertEquals(getAndPrintSecondaryIntermediateAngle(angle--),  BlockFace.NORTH_EAST);
        while(angle > -169)
            Assert.assertEquals(getAndPrintSecondaryIntermediateAngle(angle--), BlockFace.NORTH_NORTH_EAST);
        while(angle > -192)
            Assert.assertEquals(getAndPrintSecondaryIntermediateAngle(angle--), BlockFace.NORTH);
        while(angle > -214)
            Assert.assertEquals(getAndPrintSecondaryIntermediateAngle(angle--), BlockFace.NORTH_NORTH_WEST);
        while(angle > -237)
            Assert.assertEquals(getAndPrintSecondaryIntermediateAngle(angle--), BlockFace.NORTH_WEST);
        while(angle > -259)
            Assert.assertEquals(getAndPrintSecondaryIntermediateAngle(angle--), BlockFace.WEST_NORTH_WEST);
    }

    private BlockFace getAndPrintSecondaryIntermediateAngle(final float angle) {
        final BlockFace face = BlockFacing.getSecondaryIntermediateBlockFace(angle);
        System.out.println("Angle: " + angle + ", faces: " + face.name());
        return face;
    }
}
