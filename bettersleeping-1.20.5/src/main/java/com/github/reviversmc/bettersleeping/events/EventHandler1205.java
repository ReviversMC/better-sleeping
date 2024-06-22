package com.github.reviversmc.bettersleeping.events;

import java.util.List;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

import com.github.reviversmc.bettersleeping.BetterSleeping;

public class EventHandler1205 extends EventHandlerBase {
	@Override
	protected void sendPlayerMessage(ServerPlayerEntity player, String message) {
		MutableText formattedMessage = Text.literal(message);

		for (String format : BetterSleeping.config.messages.messageFormatting) {
			formattedMessage.formatted(Formatting.byName(format));
		}

		player.sendMessage(formattedMessage);
	}

	@Override
	protected ServerWorld getServerWorld(ServerPlayerEntity player) {
		return player.getServerWorld();
	}

	@Override
	protected boolean isBedWorking(DimensionType dimension) {
		return dimension.bedWorks();
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
		return new StatusEffectInstance(Registries.STATUS_EFFECT.getEntry(new Identifier(id)).get(), duration, amplifier);
	}

	@Override
	protected void removeStatusEffect(ServerPlayerEntity player, String id) {
		player.removeStatusEffect(Registries.STATUS_EFFECT.getEntry(new Identifier(id)).get());
	}
}
