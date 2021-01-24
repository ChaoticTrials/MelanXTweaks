package de.melanx.mxtweaks.data;

import com.google.common.collect.ImmutableList;
import de.melanx.mxtweaks.MelanXTweaks;
import de.melanx.mxtweaks.loot.functions.EnchantExact;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.ChestLootTables;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LootTables extends LootTableProvider {
    public LootTables(DataGenerator generator) {
        super(generator);
    }

    @Nonnull
    @Override
    protected List<com.mojang.datafixers.util.Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(com.mojang.datafixers.util.Pair.of(ModChestLootTables::new, LootParameterSets.CHEST));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationTracker tracker) {
        map.forEach((name, table) -> LootTableManager.validateLootTable(tracker, name, table));
    }

    private static class ModChestLootTables extends ChestLootTables {
        @Override
        public void accept(@Nonnull BiConsumer<ResourceLocation, LootTable.Builder> builder) {
            LootPool.Builder obtainable = LootPool.builder();
            LootPool.Builder unobtainable = LootPool.builder();
            for (Enchantment enchantment : Registry.ENCHANTMENT) {
                if (enchantment.isCurse() || enchantment.isTreasureEnchantment()) {
                    Pair<Enchantment, Integer> pair = Pair.of(enchantment, enchantment.getMaxLevel());
                    unobtainable.addEntry(ItemLootEntry.builder(Items.BOOK).acceptFunction(EnchantExact.builder(pair)));
                } else {
                    Pair<Enchantment, Integer> pair = Pair.of(enchantment, enchantment.getMaxLevel() + 1);
                    obtainable.addEntry(ItemLootEntry.builder(Items.BOOK).acceptFunction(EnchantExact.builder(pair)));
                }
            }
            builder.accept(new ResourceLocation(MelanXTweaks.MODID, "quests/higher_enchanted_books"),
                    LootTable.builder().addLootPool(obtainable));
            builder.accept(new ResourceLocation(MelanXTweaks.MODID, "quests/non_table_enchanted_books"),
                    LootTable.builder().addLootPool(unobtainable));
        }
    }
}
