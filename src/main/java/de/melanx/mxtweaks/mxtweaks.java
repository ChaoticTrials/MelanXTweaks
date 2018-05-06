package de.melanx.mxtweaks;

import de.melanx.mxtweaks.client.OreDict;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import de.melanx.mxtweaks.blocks.ModBlocks;
import de.melanx.mxtweaks.client.mxtweaksTab;
import de.melanx.mxtweaks.items.ModItems;
import de.melanx.mxtweaks.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = mxtweaks.MODID, version = "b-0.1.1", name = "MelanX Tweaks", dependencies = "required-after:botania@[r1.10-354]")

public class mxtweaks {

    public static final String MODID = "mxtweaks";
    public static final mxtweaksTab creativeTab = new mxtweaksTab();

    @SidedProxy(clientSide = "de.melanx.mxtweaks.proxy.ClientProxy", serverSide = "de.melanx.mxtweaks.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(MODID + " is loading");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        OreDict.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println(MODID + " is finished.");
    }

}
