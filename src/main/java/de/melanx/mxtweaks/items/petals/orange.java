package de.melanx.mxtweaks.items.petals;

import de.melanx.mxtweaks.mxtweaks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import vazkii.botania.api.item.IPetalApothecary;
import vazkii.botania.api.recipe.IFlowerComponent;

public class orange extends Item implements IFlowerComponent {

    public orange() {
        setUnlocalizedName("mana_petal_orange");
        setRegistryName("mana_petal_orange");
        setCreativeTab(mxtweaks.creativeTab);
    }

    public void registerItemModel() {
        mxtweaks.proxy.registerItemRenderer(this, 0, "mana_petal_orange");
    }

    public void initOreDict() {
        OreDictionary.registerOre("petalMana", this);
    }

    public boolean canFit(ItemStack stack, IPetalApothecary apothecary) {
        return true;
    }

    public int getParticleColor(ItemStack stack) {
        return 16351261;
    }

}