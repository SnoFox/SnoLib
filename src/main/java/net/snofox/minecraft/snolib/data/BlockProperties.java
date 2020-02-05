package net.snofox.minecraft.snolib.data;

import com.google.common.collect.ImmutableSet;
import org.bukkit.Material;

import java.util.Set;

/**
 * Created by Josh on 2020-01-19
 */
public class BlockProperties {
    private static Set<Material> transparentBlocks;
    static {
        final ImmutableSet.Builder<Material> builder = ImmutableSet.builder();
        for(Material material : Material.values()) {
            if(material.isTransparent()) builder.add(material);
        }
        transparentBlocks = builder.build();
    }

    public static Set<Material> getTransparentBlocks() {
        return transparentBlocks;
    }
}
