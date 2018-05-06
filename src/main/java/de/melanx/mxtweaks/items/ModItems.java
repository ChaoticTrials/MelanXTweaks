package de.melanx.mxtweaks.items;

import de.melanx.mxtweaks.items.petals.*;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static white whitePetal = new white();
    public static orange orangePetal = new orange();
    public static magenta magentaPetal = new magenta();
    public static lightblue lightbluePetal = new lightblue();
    public static yellow yellowPetal = new yellow();
    public static lime limePetal = new lime();
    public static pink pinkPetal = new pink();
    public static gray grayPetal = new gray();
    public static lightgray lightgrayPetal = new lightgray();
    public static cyan cyanPetal = new cyan();
    public static purple purplePetal = new purple();
    public static blue bluePetal = new blue();
    public static brown brownPetal = new brown();
    public static green greenPetal = new green();
    public static red redPetal = new red();
    public static black blackPetal = new black();

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
