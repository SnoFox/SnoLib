package net.snofox.minecraft.snolib;

import org.bukkit.block.BlockFace;

import java.util.ArrayList;

/**
 * Created by Josh on 2018-09-16
 */
public class BlockFacing {
    private static final BlockFace[] cardinals = {
            BlockFace.SOUTH,
            BlockFace.WEST,
            BlockFace.NORTH,
            BlockFace.EAST,
    };
    private static final BlockFace[] intermediates = {
            BlockFace.SOUTH, BlockFace.SOUTH_WEST,
            BlockFace.WEST, BlockFace.NORTH_WEST,
            BlockFace.NORTH, BlockFace.NORTH_EAST,
            BlockFace.EAST, BlockFace.SOUTH_EAST,
    };
    private static final BlockFace[] secondary_intermediates = {
            BlockFace.SOUTH, BlockFace.SOUTH_SOUTH_WEST, BlockFace.SOUTH_WEST, BlockFace.WEST_SOUTH_WEST,
            BlockFace.WEST, BlockFace.WEST_NORTH_WEST, BlockFace.NORTH_WEST, BlockFace.NORTH_NORTH_WEST,
            BlockFace.NORTH, BlockFace.NORTH_NORTH_EAST, BlockFace.NORTH_EAST, BlockFace.EAST_NORTH_EAST,
            BlockFace.EAST, BlockFace.EAST_SOUTH_EAST, BlockFace.SOUTH_EAST, BlockFace.SOUTH_SOUTH_EAST,
    };

    public static BlockFace getCardinalBlockFace(float yaw) {
        final int dir = Math.round(yaw / 90f) & 0x3;
        return cardinals[dir];
    }

    public static BlockFace getIntermediateBlockFace(float yaw) {
        final int dir = Math.round(yaw / 45f) & 0x7;
        return intermediates[dir];
    }

    public static BlockFace getSecondaryIntermediateBlockFace(float yaw) {
        final int dir = Math.round(yaw / 22.5f) & 0xf;
        return secondary_intermediates[dir];
    }
}
