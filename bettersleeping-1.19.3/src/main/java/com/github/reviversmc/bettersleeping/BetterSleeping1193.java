package com.github.reviversmc.bettersleeping;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import com.github.reviversmc.bettersleeping.events.EventHandler1193;

public class BetterSleeping1193 implements ModInitializer {
	public static EventHandler1193 eventHandler;

	@Override
	public void onInitialize() {
		eventHandler = new EventHandler1193();

		ServerTickEvents.END_SERVER_TICK.register(eventHandler::onTick);
	}
}
