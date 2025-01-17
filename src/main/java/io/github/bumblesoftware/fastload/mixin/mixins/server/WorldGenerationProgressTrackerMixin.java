package io.github.bumblesoftware.fastload.mixin.mixins.server;

import io.github.bumblesoftware.fastload.config.init.FLMath;
import net.minecraft.client.gui.WorldGenerationProgressTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * Not really needed, but can never be too safe
 */
@Mixin(WorldGenerationProgressTracker.class)
public class WorldGenerationProgressTrackerMixin {
    @ModifyVariable(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/WorldGenerationProgressLogger;<init>(I)V"), argsOnly = true)
    public int getRadius(int radius) {
        return FLMath.getPregenRadius(false);
    }
}
