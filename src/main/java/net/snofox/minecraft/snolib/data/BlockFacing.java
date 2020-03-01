package net.snofox.minecraft.snolib.data;

import org.bukkit.block.BlockFace;

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

    public static float getYaw(final BlockFace face) {
        switch(face) {
            case NORTH:
                return -180f;
            case NORTH_NORTH_EAST:
                return -157.5f;
            case NORTH_EAST:
                return -135f;
            case EAST_NORTH_EAST:
                return -112.5f;
            case EAST:
                return -90f;
            case EAST_SOUTH_EAST:
                return -67.5f;
            case SOUTH_EAST:
                return -45f;
            case SOUTH_SOUTH_EAST:
                return -22.5f;
            case SOUTH:
                return 0f;
            case SOUTH_SOUTH_WEST:
                return 22.5f;
            case SOUTH_WEST:
                return 45f;
            case WEST_SOUTH_WEST:
                return 67.5f;
            case WEST:
                return 90f;
            case WEST_NORTH_WEST:
                return 112.5f;
            case NORTH_WEST:
                return 135f;
            case NORTH_NORTH_WEST:
                return 157.5f;
            default:
                return -1f;
        }
    }
}
