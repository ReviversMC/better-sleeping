package com.github.reviversmc.bettersleeping.events;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.dimension.DimensionType;

import com.github.reviversmc.bettersleeping.BetterSleeping;

public class EventHandler119 extends EventHandler117 {
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
		return player.getWorld();
	}

	@Override
	protected boolean isBedWorking(DimensionType dimension) {
		return dimension.bedWorks();
	}
}
