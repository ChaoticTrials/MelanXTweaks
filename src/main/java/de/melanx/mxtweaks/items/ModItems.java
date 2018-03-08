package de.melanx.mxtweaks.items;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemBase petalBotania = new ItemBase("botania_petal");

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                petalBotania
        );
    }

    public static void registerModels() {
        petalBotania.registerItemModel();

    }

}
