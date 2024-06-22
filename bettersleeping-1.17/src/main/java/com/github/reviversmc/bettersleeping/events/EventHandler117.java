package com.github.reviversmc.bettersleeping.events;

import java.util.List;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.dimension.DimensionType;

import com.github.reviversmc.bettersleeping.BetterSleeping;

public class EventHandler117 extends EventHandlerBase {
	@Override
	protected void sendPlayerMessage(ServerPlayerEntity player, String message) {
		LiteralText formattedMessage = new LiteralText(message);

		for (String format : BetterSleeping.config.messages.messageFormatting) {
			formattedMessage.formatted(Formatting.byName(format));
		}

		player.sendSystemMessage(formattedMessage, player.getUuid());
	}

	@Override
	protected ServerWorld getServerWorld(ServerPlayerEntity player) {
		return player.getServerWorld();
	}

	@Override
	protected boolean isBedWorking(DimensionType dimension) {
		return dimension.isBedWorking();
	}

	@Override
	protected List<StatusEffect> getHarmfulEffects() {
		return Registry.STATUS_EFFECT.stream()
				.filter(effect -> effect.getCategory() != StatusEffectCategory.BENEFICIAL)
				.toList();
	}

	@Override
	protected List<StatusEffect> getBeneficialEffects() {
		return Registry.STATUS_EFFECT.stream()
				.filter(effect -> effect.getCategory() != StatusEffectCategory.HARMFUL)
				.toList();
	}

	@Override
	protected StatusEffectInstance newStatusEffectInstance(String id, int duration, int amplifier) {
		return new StatusEffectInstance(Registry.STATUS_EFFECT.get(new Identifier(id)), duration, amplifier);
	}

	@Override
	protected void removeStatusEffect(ServerPlayerEntity player, String id) {
		player.removeStatusEffect(Registry.STATUS_EFFECT.get(new Identifier(id)));
	}
}
