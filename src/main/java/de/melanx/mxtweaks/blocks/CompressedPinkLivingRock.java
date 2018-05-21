package de.melanx.mxtweaks.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class CompressedPinkLivingRock extends BlockBase {

    public CompressedPinkLivingRock(String name) {
        super(Material.ROCK, name);
        setHardness(50f);
        setResistance(6000.0f);
        this.setSoundType(SoundType.STONE);
        this.setHarvestLevel("pickaxe", 3);
    }

    @Override
    public CompressedPinkLivingRock setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer(){
        return BlockRenderLayer.TRANSLUCENT;
    }

}
