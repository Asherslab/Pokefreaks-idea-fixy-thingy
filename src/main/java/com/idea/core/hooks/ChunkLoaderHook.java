package com.idea.core.hooks;

import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.server.management.PlayerChunkMapEntry;
import net.minecraft.util.ReportedException;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.world.gen.IChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(ChunkProviderServer.class)
public abstract class ChunkLoaderHook implements IChunkGenerator
{
    @Shadow @Nullable public abstract Chunk loadChunk(final int x, final int z);

    @Inject(method = "provideChunk", at = @At("HEAD"))
    protected void onProvideChunk(int x, int z, final CallbackInfoReturnable<Chunk> info)
    {
        Chunk chunk = this.loadChunk(x, z);

        if (chunk == null)
        {
            System.out.println("Chunk Provided: X: " + x + " Z: " + z);
        }
    }
}
