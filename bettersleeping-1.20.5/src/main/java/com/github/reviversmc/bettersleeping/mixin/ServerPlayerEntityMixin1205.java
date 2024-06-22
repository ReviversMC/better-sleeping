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

import com.github.reviversmc.bettersleeping.BetterSleeping1205;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin1205 extends PlayerEntity {
	public ServerPlayerEntityMixin1205(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
		super(world, pos, yaw, gameProfile);
	}

	@Inject(method = "sleep", at = @At("TAIL"))
	public void onSleep(BlockPos position, CallbackInfo callbackInfo) {
		BetterSleeping1205.eventHandler.onSleep(cast(this));
	}

	@Inject(method = "wakeUp", at = @At("RETURN"))
	private void onWakeUp(boolean skipSleepTimer, boolean updateSleepingPlayers, CallbackInfo callbackInfo) {
		BetterSleeping1205.eventHandler.onWakeUp(cast(this));
	}

	private ServerPlayerEntity cast(PlayerEntity player) {
		return (ServerPlayerEntity) player;
	}
}
