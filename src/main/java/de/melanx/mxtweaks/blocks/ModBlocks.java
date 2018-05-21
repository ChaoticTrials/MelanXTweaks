package de.melanx.mxtweaks.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

    public static CompressedCobble compressedCobble = new CompressedCobble("compressed_cobblestone");
    public static BlockInfinity infinityBlock = new BlockInfinity("infinity_block");
    public static PinkLivingRock pinkRock = new PinkLivingRock("pink_living_rock");
    public static CompressedPinkLivingRock compressedPinkRock = new CompressedPinkLivingRock("compressed_pink_living_rock");

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                compressedCobble,
                infinityBlock,
                pinkRock,
                compressedPinkRock
        );

    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                compressedCobble.createItemBlock(),
                infinityBlock.createItemBlock(),
                pinkRock.createItemBlock(),
                compressedPinkRock.createItemBlock()
        );

    }

    public static void registerModels() {
        compressedCobble.registerItemModel(Item.getItemFromBlock(compressedCobble));
        infinityBlock.registerItemModel(Item.getItemFromBlock(infinityBlock));
        pinkRock.registerItemModel(Item.getItemFromBlock(pinkRock));
        compressedPinkRock.registerItemModel(Item.getItemFromBlock(compressedPinkRock));
    }
}