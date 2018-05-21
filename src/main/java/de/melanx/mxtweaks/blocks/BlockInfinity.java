package de.melanx.mxtweaks.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class BlockInfinity extends BlockBase {

    public BlockInfinity(String name) {
        super(Material.ROCK, name);
        setHardness(1.5f);
        setResistance(10.0f);
        this.setSoundType(SoundType.STONE);
        this.setHarvestLevel("pickaxe", 3);
    }

    @Override
    public BlockInfinity setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer(){
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}
