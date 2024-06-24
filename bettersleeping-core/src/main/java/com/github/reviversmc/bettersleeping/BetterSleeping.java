package com.github.reviversmc.bettersleeping;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.reviversmc.bettersleeping.compat.minecraft.McVersionCompatInvoker;
import com.github.reviversmc.bettersleeping.compat.mods.ClothConfigCompat;
import com.github.reviversmc.bettersleeping.config.BetterSleepingConfig;
import com.github.reviversmc.bettersleeping.events.EventHandlerBase;

public class BetterSleeping implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("BetterSleeping");
	public static final String NAMESPACE = "bettersleeping";
	public static BetterSleepingConfig config;
	public static EventHandlerBase eventHandler;

	@Override
	public void onInitialize() {
		McVersionCompatInvoker.run();

		if (FabricLoader.getInstance().isModLoaded("cloth-config2")) {
			config = ClothConfigCompat.loadConfig();
		} else {
			config = new BetterSleepingConfig();
		}
	}
}
