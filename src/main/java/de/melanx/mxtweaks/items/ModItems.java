package de.melanx.mxtweaks.items;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemBase whitePetal = new ItemBase("mana_petal_white");

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                whitePetal
        );
    }

    public static void registerModels() {
        whitePetal.registerItemModel();
    }

}
