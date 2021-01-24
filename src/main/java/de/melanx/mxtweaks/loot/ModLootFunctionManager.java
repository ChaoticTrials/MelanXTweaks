package de.melanx.mxtweaks.loot;

import de.melanx.mxtweaks.MelanXTweaks;
import de.melanx.mxtweaks.loot.functions.EnchantExact;
import net.minecraft.loot.ILootSerializer;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.functions.ILootFunction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class ModLootFunctionManager {
    public static final LootFunctionType EXACT_ENCHANTMENTS = register("enchant_exact", new EnchantExact.Serializer());

    public static void init() {
        MelanXTweaks.LOGGER.info("Registered loot functions");
    }

    private static LootFunctionType register(String name, ILootSerializer<? extends ILootFunction> serializer) {
        return Registry.register(Registry.LOOT_FUNCTION_TYPE, new ResourceLocation(MelanXTweaks.MODID, name), new LootFunctionType(serializer));
    }
}
