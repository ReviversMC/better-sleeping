package com.github.reviversmc.bettersleeping.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import com.github.reviversmc.bettersleeping.BetterSleeping;

@Config(name = BetterSleeping.NAMESPACE)
public class BetterSleepingConfig implements ConfigData {
	@ConfigEntry.Category("messages")
	@ConfigEntry.Gui.TransitiveObject
	public MessageConfig messages = new MessageConfig();

	@ConfigEntry.Category("buffs")
	@ConfigEntry.Gui.TransitiveObject
	public BuffConfig buffs = new BuffConfig();

	@ConfigEntry.Category("debuffs")
	@ConfigEntry.Gui.TransitiveObject
	public DebuffConfig debuffs = new DebuffConfig();
}
