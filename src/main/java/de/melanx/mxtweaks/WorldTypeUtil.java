package de.melanx.mxtweaks;

import de.melanx.mxtweaks.mixin.AccessorServerWorldInfo;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import net.minecraft.world.storage.ServerWorldInfo;
import vazkii.botania.common.world.SkyblockChunkGenerator;

public class WorldTypeUtil {
    public static void setupForDedicatedServer(DedicatedServer server) {
        DynamicRegistries registries = server.func_244267_aX();
        ServerWorldInfo worldInfo = (ServerWorldInfo) server.getServerConfiguration();
        DimensionGeneratorSettings generatorSettings = ((AccessorServerWorldInfo) worldInfo).getGeneratorSettings();
        long seed = generatorSettings.getSeed();
        Registry<DimensionType> dimensions = registries.getRegistry(Registry.DIMENSION_TYPE_KEY);
        Registry<Biome> biomes = registries.getRegistry(Registry.BIOME_KEY);
        Registry<DimensionSettings> dimensionSettings = registries.getRegistry(Registry.NOISE_SETTINGS_KEY);
        SimpleRegistry<Dimension> simpleregistry = DimensionType.getDefaultSimpleRegistry(dimensions, biomes, dimensionSettings, seed);
        SimpleRegistry<Dimension> skyblock = DimensionGeneratorSettings.func_242749_a(dimensions, simpleregistry, new SkyblockChunkGenerator(new OverworldBiomeProvider(seed, false, false, biomes), seed, () -> dimensionSettings.getOrThrow(DimensionSettings.field_242734_c)));
        ((AccessorServerWorldInfo) worldInfo).setGeneratorSettings(new DimensionGeneratorSettings(generatorSettings.getSeed(), generatorSettings.doesGenerateFeatures(), generatorSettings.hasBonusChest(), skyblock));
    }
}
