package com.github.reviversmc.bettersleeping.compat.mods;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

import net.minecraft.client.gui.screen.Screen;

import com.github.reviversmc.bettersleeping.config.BetterSleepingConfig;

public class ClothConfigCompat {
	public static BetterSleepingConfig loadConfig() {
		return AutoConfig.register(BetterSleepingConfig.class, JanksonConfigSerializer::new).getConfig();
	}

	public static Screen getScreen(Screen parent) {
		return AutoConfig.getConfigScreen(BetterSleepingConfig.class, parent).get();
	}
}
