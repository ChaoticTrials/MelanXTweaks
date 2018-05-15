package de.melanx.mxtweaks.recipes;

import de.melanx.mxtweaks.blocks.ModBlocks;
import vazkii.botania.api.BotaniaAPI;

public final class PureDaisyRecipes {

    public static void init(){
        BotaniaAPI.registerPureDaisyRecipe(ModBlocks.infinityBlock, ModBlocks.pinkRock.getDefaultState(), 621000);
    }
}
