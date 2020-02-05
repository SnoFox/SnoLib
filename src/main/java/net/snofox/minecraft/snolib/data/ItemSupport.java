package net.snofox.minecraft.snolib.data;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * Created by Josh on 2020-01-29
 */
public class ItemSupport {
    /**
     * compares two ItemStacks to see if they are two similar Material.PLAYER_HEAD (or equivalent)
     * @param stack1
     * @param stack2
     * @return
     */
    public static boolean isSimilarHead(final ItemStack stack1, final ItemStack stack2) {
        if(!(isPlayerHead(stack1.getType()) && isPlayerHead(stack2.getType()))) return false;
        if(stack1.hasItemMeta() && stack2.hasItemMeta()) {
            final SkullMeta meta1 = (SkullMeta) stack1.getItemMeta();
            final SkullMeta meta2 = (SkullMeta) stack2.getItemMeta();
            if(meta1.hasOwner() && meta2.hasOwner())
                return meta1.getOwningPlayer() == meta2.getOwningPlayer();
            return meta1.hasOwner() && meta2.hasOwner();
        }
        return stack1.hasItemMeta() && stack2.hasItemMeta();
    }

    private static boolean isPlayerHead(final Material type) {
        return type == Material.PLAYER_HEAD || type == Material.PLAYER_WALL_HEAD;
    }
}
