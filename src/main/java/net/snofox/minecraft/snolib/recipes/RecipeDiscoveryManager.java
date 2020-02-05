package net.snofox.minecraft.snolib.recipes;

import net.snofox.minecraft.snolib.SnoLib;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Josh on 2018-12-16
 * Moved from AdaptedArmor on 2020-01-11
 */
public class RecipeDiscoveryManager {
    private final static HashMap<ItemStack, ArrayList<NamespacedKey>> itemsToRecipes = new HashMap<>();

    private static List<NamespacedKey> getNamespacedKeys(final ItemStack itemStack) {
        if(!itemsToRecipes.containsKey(itemStack))
            itemsToRecipes.put(itemStack, new ArrayList<NamespacedKey>());
        return itemsToRecipes.get(itemStack);
    }

    /**
     * Add a recipe to be found later
     * @param itemStack
     * @param key
     */
    public static void addRecipe(ItemStack itemStack, NamespacedKey key) {
        getNamespacedKeys(itemStack).add(key);
        SnoLib.debug("Adding item " + (itemStack == null ? null : itemStack.getType()) + " to " + key);
    }

    /**
     * Get all the recipes that can be made for this ItemStack
     * @param itemStack
     * @return
     */
    public static Collection<NamespacedKey> getRecipesForItem(final ItemStack itemStack) {
        return getNamespacedKeys(itemStack);
    }
}
