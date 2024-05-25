package com.github.reviversmc.bettersleeping.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.dimension.DimensionType;

import com.github.reviversmc.bettersleeping.BetterSleeping;

public class EventHandler119 extends EventHandlerBase {
	@Override
	protected void sendPlayerMessage(PlayerEntity player, String message) {
		MutableText formattedMessage = Text.literal(message);

		for (String format : BetterSleeping.config.messages.messageFormatting) {
			formattedMessage.formatted(Formatting.byName(format));
		}

		((ServerPlayerEntity) player).sendMessage(formattedMessage);
	}

	@Override
	protected ServerWorld getServerWorld(ServerPlayerEntity player) {
		// ServerPlayerEntity#getWorld() is method_14220, which doesn't exist in 1.20+.
		// Entity#getWorld() is method_37908, which still exists in 1.20+.
		return (ServerWorld) ((Entity) player).getWorld();
	}

	@Override
	protected boolean isBedWorking(DimensionType dimension) {
		return dimension.bedWorks();
	}
}
