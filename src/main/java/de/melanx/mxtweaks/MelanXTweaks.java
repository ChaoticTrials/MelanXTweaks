package de.melanx.mxtweaks;

import de.melanx.mxtweaks.loot.ModLootFunctionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

@Mod(MelanXTweaks.MODID)
public class MelanXTweaks {

    public static final String MODID = "mxtweaks";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final String ITEM_RECEIVED_TAG = "itemReceived";

    public MelanXTweaks() {
        ModLootFunctionManager.init();
        MinecraftForge.EVENT_BUS.addListener(this::onPlayerJoin);
        MinecraftForge.EVENT_BUS.addListener(this::clonePlayer);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
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

    public static class Config {

        public static final ForgeConfigSpec SERVER_CONFIG;
        private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

        static {
            init(SERVER_BUILDER);
            SERVER_CONFIG = SERVER_BUILDER.build();
        }

        public static ForgeConfigSpec.ConfigValue<List<? extends String>> startupMessages;

        public static void init(ForgeConfigSpec.Builder builder) {
            startupMessages = builder.comment("Messages which will be shown on each world join.")
                    .defineList("messages", Collections.emptyList(), obj -> obj instanceof String);
        }
    }
}
