package de.melanx.mxtweaks;

import de.melanx.mxtweaks.loot.ModLootFunctionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MelanXTweaks.MODID)
public class MelanXTweaks {

    public static final String MODID = "mxtweaks";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final String ITEM_RECEIVED_TAG = "itemReceived";

    public MelanXTweaks() {
        ModLootFunctionManager.init();
        MinecraftForge.EVENT_BUS.addListener(this::onPlayerJoin);
        MinecraftForge.EVENT_BUS.addListener(this::clonePlayer);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    private void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        World world = player.getEntityWorld();
        if (!world.isRemote && !player.getPersistentData().getBoolean(ITEM_RECEIVED_TAG)) {
            player.getPersistentData().putBoolean(ITEM_RECEIVED_TAG, true);
            player.inventory.addItemStackToInventory(new ItemStack(Registry.ITEM.getOrDefault(new ResourceLocation("ftbquests", "book"))));
        }
    }

    private void clonePlayer(PlayerEvent.Clone event) {
        event.getPlayer().getPersistentData().putBoolean(ITEM_RECEIVED_TAG, event.getOriginal().getPersistentData().getBoolean(ITEM_RECEIVED_TAG));
    }

    @SubscribeEvent
    public void serverAboutToStart(FMLServerAboutToStartEvent event) {
        if (event.getServer() instanceof DedicatedServer) {
            WorldTypeUtil.setupForDedicatedServer((DedicatedServer) event.getServer());
        }
    }
}
