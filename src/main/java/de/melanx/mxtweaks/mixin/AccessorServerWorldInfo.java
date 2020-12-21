package de.melanx.mxtweaks.mixin;

import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import net.minecraft.world.storage.ServerWorldInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerWorldInfo.class)
public interface AccessorServerWorldInfo {
    @Accessor
    DimensionGeneratorSettings getGeneratorSettings();

    @Accessor
    void setGeneratorSettings(DimensionGeneratorSettings settings);
}
