package de.melanx.mxtweaks.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PinkLivingRock extends BlockBase {

    public PinkLivingRock(String name) {
        super(Material.ROCK, name);
        setHardness(50f);
        setResistance(6000.0f);
        this.setSoundType(SoundType.STONE);
        this.setHarvestLevel("pickaxe", 3);
    }

    @Override
    public PinkLivingRock setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
