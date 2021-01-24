package de.melanx.mxtweaks.loot.functions;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.*;
import de.melanx.mxtweaks.loot.ModLootFunctionManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootFunction;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import java.util.Map;

public class EnchantExact extends LootFunction {
    private final Map<Enchantment, Integer> enchantments;

    protected EnchantExact(ILootCondition[] conditionsIn, @Nonnull Map<Enchantment, Integer> enchantments) {
        super(conditionsIn);
        this.enchantments = ImmutableMap.copyOf(enchantments);
    }

    @Nonnull
    @Override
    protected ItemStack doApply(@Nonnull ItemStack stack, @Nonnull LootContext context) {
        if (!this.enchantments.isEmpty()) {
            ItemStack stack1 = stack.getItem() != Items.BOOK ? stack.copy() : new ItemStack(Items.ENCHANTED_BOOK);
            for (Map.Entry<Enchantment, Integer> entry : this.enchantments.entrySet()) {
                stack1.addEnchantment(entry.getKey(), entry.getValue());
            }
            return stack1;
        }
        return stack;
    }

    @Nonnull
    @Override
    public LootFunctionType getFunctionType() {
        return ModLootFunctionManager.EXACT_ENCHANTMENTS;
    }

    public static LootFunction.Builder<?> builder(Map<Enchantment, Integer> map) {
        return builder((conditions) -> new EnchantExact(conditions, map));
    }

    public static LootFunction.Builder<?> builder(Pair<Enchantment, Integer> entry) {
        return builder((conditions) -> {
            Map<Enchantment, Integer> map = Maps.newHashMap();
            map.put(entry.getKey(), entry.getValue());
            return new EnchantExact(conditions, map);
        });
    }

    public static class Serializer extends LootFunction.Serializer<EnchantExact> {
        @Override
        public void serialize(@Nonnull JsonObject json, @Nonnull EnchantExact function, @Nonnull JsonSerializationContext context) {
            super.serialize(json, function, context);
            JsonArray enchantments = new JsonArray();
            function.enchantments.forEach((enchantment, level) -> {
                JsonObject object = new JsonObject();
                //noinspection ConstantConditions
                object.addProperty("enchantment", enchantment.getRegistryName().toString());
                object.addProperty("level", level);
                enchantments.add(object);
            });

            json.add("enchantments", enchantments);
        }

        @Nonnull
        @Override
        public EnchantExact deserialize(@Nonnull JsonObject json, @Nonnull JsonDeserializationContext context, @Nonnull ILootCondition[] conditions) {
            Map<Enchantment, Integer> enchantments = Maps.newHashMap();
            if (json.has("enchantments")) {
                for (JsonElement e : JSONUtils.getJsonArray(json, "enchantments")) {
                    JsonObject element = (JsonObject) e;
                    String s = JSONUtils.getString(element, "enchantment");
                    Enchantment enchantment = ForgeRegistries.ENCHANTMENTS.getValue(ResourceLocation.tryCreate(s));
                    if (enchantment == null) throw new JsonSyntaxException("Unknown enchantment '" + s + "'");
                    int level = element.has("level") ? JSONUtils.getInt(element, "level") : 1;

                    enchantments.put(enchantment, level);
                }
            }

            return new EnchantExact(conditions, enchantments);
        }
    }
}
