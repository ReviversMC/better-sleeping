package com.github.reviversmc.bettersleeping.compat.mods;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;

import com.github.reviversmc.bettersleeping.config.BetterSleepingConfig;

/**
 * Removes the {@code ConfigData} interface from the {@link BetterSleepingConfig} class in case Cloth Config isn't loaded,
 * to prevent a ClassNotFoundException.
 */
public class ClothConfigCompatTransformer implements Runnable {
	@Override
	public void run() {
		if (FabricLoader.getInstance().isModLoaded("cloth-config2")) return;

		ClassTinkerers.addTransformation("com.github.reviversmc.bettersleeping.config.BetterSleepingConfig", classNode -> {
			classNode.interfaces.remove("me/shedaniel/autoconfig/ConfigData");
		});
	}
}
