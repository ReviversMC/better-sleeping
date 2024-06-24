package com.github.reviversmc.bettersleeping.compat.minecraft;

import java.util.List;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.EntrypointContainer;

public final class McVersionCompatInvoker {
	public static void run() {
		List<EntrypointContainer<McVersionCompatInitializer>> entryPoints = FabricLoader.getInstance().getEntrypointContainers("bettersleeping", McVersionCompatInitializer.class);
		int successfulInvokes = 0;

		for (EntrypointContainer<McVersionCompatInitializer> entryPoint : entryPoints) {
			if (entryPoint.getEntrypoint().isCompatible()) {
				entryPoint.getEntrypoint().initialize();
				successfulInvokes++;
			}
		}

		if (successfulInvokes == 0) {
			throw new RuntimeException("Couldn't find a BetterSleeping compatibility layer for the current Minecraft version");
		}

		if (successfulInvokes > 1) {
			throw new IllegalStateException("Found multiple BetterSleeping compatibility layers for the current Minecraft version");
		}
	}
}
