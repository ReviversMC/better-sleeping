package com.github.reviversmc.bettersleeping.mixin;

import com.mojang.authlib.GameProfile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.github.reviversmc.bettersleeping.BetterSleeping1193;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin1193 extends PlayerEntity {
	public ServerPlayerEntityMixin1193(World world, BlockPos pos, float yaw, GameProfile profile) {
		super(world, pos, yaw, profile);
	}

	@Inject(method = "sleep", at = @At("TAIL"))
	public void onSleep(BlockPos position, CallbackInfo callbackInfo) {
		BetterSleeping1193.eventHandler.onSleep(cast(this));
	}

	@Inject(method = "wakeUp", at = @At("RETURN"))
	private void onWakeUp(boolean skipSleepTimer, boolean updateSleepingPlayers, CallbackInfo callbackInfo) {
		BetterSleeping1193.eventHandler.onWakeUp(cast(this));
	}

	private ServerPlayerEntity cast(PlayerEntity player) {
		return (ServerPlayerEntity) player;
	}
}
