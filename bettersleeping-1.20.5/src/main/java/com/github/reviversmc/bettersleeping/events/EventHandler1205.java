package com.github.reviversmc.bettersleeping.events;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class EventHandler1205 extends EventHandler1193 {
	@Override
	protected StatusEffectInstance newStatusEffectInstance(String id, int duration, int amplifier) {
		return new StatusEffectInstance(Registries.STATUS_EFFECT.getEntry(Identifier.tryParse(id)).get(), duration, amplifier);
	}

	@Override
	protected void removeStatusEffect(ServerPlayerEntity player, String id) {
		player.removeStatusEffect(Registries.STATUS_EFFECT.getEntry(Identifier.tryParse(id)).get());
	}
}
