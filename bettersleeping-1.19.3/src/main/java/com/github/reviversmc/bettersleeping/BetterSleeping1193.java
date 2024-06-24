package com.github.reviversmc.bettersleeping;

import java.util.function.Supplier;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import com.github.reviversmc.bettersleeping.compat.minecraft.McVersionCompatInitializer;
import com.github.reviversmc.bettersleeping.compat.minecraft.McVersionHelper;
import com.github.reviversmc.bettersleeping.events.EventHandler1193;

public class BetterSleeping1193 extends McVersionCompatInitializer {
	static final Supplier<Boolean> IS_COMPATIBLE = () -> McVersionHelper.isWithin("1.19.3", "1.20.4");

	@Override
	public boolean isCompatible() {
		return IS_COMPATIBLE.get();
	}

	@Override
	public void initialize() {
		BetterSleeping.eventHandler = new EventHandler1193();

		ServerTickEvents.END_SERVER_TICK.register(BetterSleeping.eventHandler::onTick);
	}
}
