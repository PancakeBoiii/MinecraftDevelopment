package io.github.pancakeboiii.core.OrdinalAPI.Minecraft;

import net.minecraft.core.BlockPosition;
import net.minecraft.core.IRegistry;
import net.minecraft.core.IRegistryWritable;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.world.level.biome.BiomeBase;
import net.minecraft.world.level.chunk.Chunk;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftServer;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;

public class GetBiome {
	public static BiomeBase getBiomeBase(Location location) {
	    // NMS position
	    BlockPosition pos = new BlockPosition(location.getBlockX(), 0, location.getBlockZ());

	    // NMS chunk from pos
	    Chunk nmsChunk = ((CraftWorld)location.getWorld()).getHandle().getChunkAtWorldCoords(pos);

	    if (nmsChunk != null) {
	        return nmsChunk.getBiomeIndex().getBiome(pos.getX(), 0, pos.getZ());
	    }
	    return null;
	}
	public static MinecraftKey getBiomeKey(Location location) {
	    DedicatedServer dedicatedServer = ((CraftServer) Bukkit.getServer()).getServer();

	    IRegistryWritable<BiomeBase> registry = dedicatedServer.getCustomRegistry().b(IRegistry.aO);

	    return registry.getKey(getBiomeBase(location)); // getBiomeBase() from above
	}

}
