package de.melanx.mxtweaks.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

    public static CompressedCobble compressedCobble = new CompressedCobble("compressed_cobblestone");

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                compressedCobble
        );

    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                compressedCobble.createItemBlock()
        );

    }

    public static void registerModels() {
        compressedCobble.registerItemModel(Item.getItemFromBlock(compressedCobble));
    }
}