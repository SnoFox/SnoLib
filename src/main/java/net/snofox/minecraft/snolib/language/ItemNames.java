package net.snofox.minecraft.snolib.language;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Josh on 2020-01-04
 */
public class ItemNames {

    /**
     * Returns the items custom name, or the localized name if none
     * @param item
     * @return
     */
    public static String getItemLocalizedName(final ItemStack item) {
        if(item.hasItemMeta()) {
            final ItemMeta itemMeta = item.getItemMeta();
            if(itemMeta.hasDisplayName())
                return itemMeta.getDisplayName();
            else if(itemMeta.hasLocalizedName())
                return itemMeta.getLocalizedName();
        }
        return Strings.toTitleCase(item.getType().toString());
    }
}
