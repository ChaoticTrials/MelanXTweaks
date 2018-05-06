package de.melanx.mxtweaks.items;

import de.melanx.mxtweaks.items.petals.white;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    //public static ItemOre whitePetal = new ItemOre("mana_petal_white", "petalMana");
    public static ItemOre orangePetal = new ItemOre("mana_petal_orange", "petalMana");
    public static ItemOre magentaPetal = new ItemOre("mana_petal_magenta", "petalMana");
    public static ItemOre lightbluePetal = new ItemOre("mana_petal_lightblue", "petalMana");
    public static ItemOre yellowPetal = new ItemOre("mana_petal_yellow", "petalMana");
    public static ItemOre limePetal = new ItemOre("mana_petal_lime", "petalMana");
    public static ItemOre pinkPetal = new ItemOre("mana_petal_pink", "petalMana");
    public static ItemOre grayPetal = new ItemOre("mana_petal_gray", "petalMana");
    public static ItemOre lightgrayPetal = new ItemOre("mana_petal_lightgray", "petalMana");
    public static ItemOre cyanPetal = new ItemOre("mana_petal_cyan", "petalMana");
    public static ItemOre purplePetal = new ItemOre("mana_petal_purple", "petalMana");
    public static ItemOre bluePetal = new ItemOre("mana_petal_blue", "petalMana");
    public static ItemOre brownPetal = new ItemOre("mana_petal_brown", "petalMana");
    public static ItemOre greenPetal = new ItemOre("mana_petal_green", "petalMana");
    public static ItemOre redPetal = new ItemOre("mana_petal_red", "petalMana");
    public static ItemOre blackPetal = new ItemOre("mana_petal_black", "petalMana");
    public static white whitePetal = new white();

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                whitePetal,
                orangePetal,
                magentaPetal,
                lightbluePetal,
                yellowPetal,
                limePetal,
                pinkPetal,
                grayPetal,
                lightgrayPetal,
                cyanPetal,
                purplePetal,
                bluePetal,
                brownPetal,
                greenPetal,
                redPetal,
                blackPetal
                );
    }

    public static void registerModels() {
        whitePetal.registerItemModel();
        orangePetal.registerItemModel();
        magentaPetal.registerItemModel();
        lightbluePetal.registerItemModel();
        yellowPetal.registerItemModel();
        limePetal.registerItemModel();
        pinkPetal.registerItemModel();
        grayPetal.registerItemModel();
        lightgrayPetal.registerItemModel();
        cyanPetal.registerItemModel();
        purplePetal.registerItemModel();
        bluePetal.registerItemModel();
        brownPetal.registerItemModel();
        greenPetal.registerItemModel();
        redPetal.registerItemModel();
        blackPetal.registerItemModel();
    }

}
