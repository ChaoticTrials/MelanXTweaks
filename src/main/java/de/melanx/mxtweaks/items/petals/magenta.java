package de.melanx.mxtweaks.items.petals;

import de.melanx.mxtweaks.mxtweaks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import vazkii.botania.api.item.IPetalApothecary;
import vazkii.botania.api.recipe.IFlowerComponent;

public class magenta extends Item implements IFlowerComponent {

    public magenta() {
        setUnlocalizedName("mana_petal_magenta");
        setRegistryName("mana_petal_magenta");
        setCreativeTab(mxtweaks.creativeTab);
    }

    public void registerItemModel() {
        mxtweaks.proxy.registerItemRenderer(this, 0, "mana_petal_magenta");
    }

    public void initOreDict() {
        OreDictionary.registerOre("petalMana", this);
    }

    public boolean canFit(ItemStack stack, IPetalApothecary apothecary) {
        return true;
    }

    public int getParticleColor(ItemStack stack) {
        return 13061821;
    }

}