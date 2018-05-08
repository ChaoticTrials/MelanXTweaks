package de.melanx.mxtweaks.items;

import de.melanx.mxtweaks.mxtweaks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import vazkii.botania.api.item.IPetalApothecary;
import vazkii.botania.api.recipe.IFlowerComponent;

public class InfinityRune extends Item implements IFlowerComponent {

    public InfinityRune() {
        setUnlocalizedName("rune_of_infinity");
        setRegistryName("rune_of_infinity");
        setCreativeTab(mxtweaks.creativeTab);
    }

    public void registerItemModel() {
        mxtweaks.proxy.registerItemRenderer(this, 0, "rune_of_infinity");
    }

    public void initOreDict() {
        OreDictionary.registerOre("runeInfinity314", this);
    }

    public boolean canFit(ItemStack stack, IPetalApothecary apothecary) {
        return true;
    }

    public int getParticleColor(ItemStack stack) {
        return 0xA8A8A8;
    }
}
