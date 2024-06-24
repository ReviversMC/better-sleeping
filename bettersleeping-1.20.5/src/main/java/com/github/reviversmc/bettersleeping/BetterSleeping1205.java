package com.github.reviversmc.bettersleeping;

import java.util.function.Supplier;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import com.github.reviversmc.bettersleeping.compat.minecraft.McVersionCompatInitializer;
import com.github.reviversmc.bettersleeping.compat.minecraft.McVersionHelper;
import com.github.reviversmc.bettersleeping.events.EventHandler1205;

public class BetterSleeping1205 extends McVersionCompatInitializer {
	static final Supplier<Boolean> IS_COMPATIBLE = () -> McVersionHelper.isWithin("1.20.5", "1.20.6");

	@Override
	public boolean isCompatible() {
		return IS_COMPATIBLE.get();
	}

	@Override
	public void initialize() {
		BetterSleeping.eventHandler = new EventHandler1205();

		ServerTickEvents.END_SERVER_TICK.register(BetterSleeping.eventHandler::onTick);
	}
}
