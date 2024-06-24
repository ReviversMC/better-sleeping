package com.github.reviversmc.bettersleeping.events;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

public class EventHandler1193 extends EventHandler119 {
	@Override
	protected ServerWorld getServerWorld(ServerPlayerEntity player) {
		// ServerPlayerEntity#getWorld() is method_14220, which doesn't exist in 1.20+.
		// Entity#getWorld() is method_37908, which still exists in 1.20+.
		return (ServerWorld) ((Entity) player).getWorld();
	}

	@Override
	protected List<StatusEffect> getHarmfulEffects() {
		return Registries.STATUS_EFFECT.stream()
				.filter(effect -> effect.getCategory() != StatusEffectCategory.BENEFICIAL)
				.toList();
	}

	@Override
	protected List<StatusEffect> getBeneficialEffects() {
		return Registries.STATUS_EFFECT.stream()
				.filter(effect -> effect.getCategory() != StatusEffectCategory.HARMFUL)
				.toList();
	}

	@Override
	protected StatusEffectInstance newStatusEffectInstance(String id, int duration, int amplifier) {
		return new StatusEffectInstance(Registries.STATUS_EFFECT.get(new Identifier(id)), duration, amplifier);
	}

	@Override
	protected void removeStatusEffect(ServerPlayerEntity player, String id) {
		player.removeStatusEffect(Registries.STATUS_EFFECT.get(new Identifier(id)));
	}
}
