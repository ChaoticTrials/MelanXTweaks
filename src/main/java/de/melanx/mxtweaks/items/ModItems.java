package de.melanx.mxtweaks.items;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemBase whitePetal = new ItemBase("mana_petal_white");
    public static ItemBase orangePetal = new ItemBase("mana_petal_orange");
    public static ItemBase magentaPetal = new ItemBase("mana_petal_magenta");
    public static ItemBase lightbluePetal = new ItemBase("mana_petal_lightblue");
    public static ItemBase yellowPetal = new ItemBase("mana_petal_yellow");
    public static ItemBase limePetal = new ItemBase("mana_petal_lime");
    public static ItemBase pinkPetal = new ItemBase("mana_petal_pink");
    public static ItemBase grayPetal = new ItemBase("mana_petal_gray");
    public static ItemBase lightgrayPetal = new ItemBase("mana_petal_lightgray");
    public static ItemBase cyanPetal = new ItemBase("mana_petal_cyan");
    public static ItemBase purplePetal = new ItemBase("mana_petal_purple");
    public static ItemBase bluePetal = new ItemBase("mana_petal_blue");
    public static ItemBase brownPetal = new ItemBase("mana_petal_brown");
    public static ItemBase greenPetal = new ItemBase("mana_petal_green");
    public static ItemBase redPetal = new ItemBase("mana_petal_red");
    public static ItemBase blackPetal = new ItemBase("mana_petal_black");

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
