package de.melanx.mxtweaks.client;

import de.melanx.mxtweaks.blocks.ModBlocks;
import de.melanx.mxtweaks.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class mxtweaksTab extends CreativeTabs {

    private static final String modID = "MelanX Tweaks";

    public mxtweaksTab() {
        super(mxtweaksTab.modID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.compressedCobble);
    }

}