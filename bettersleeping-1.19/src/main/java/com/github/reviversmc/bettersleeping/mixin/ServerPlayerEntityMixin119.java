package com.github.reviversmc.bettersleeping.mixin;

import com.mojang.authlib.GameProfile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.github.reviversmc.bettersleeping.BetterSleeping;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin119 extends PlayerEntity {
	public ServerPlayerEntityMixin119(World world, BlockPos pos, float yaw, GameProfile profile, PlayerPublicKey publicKey) {
		super(world, pos, yaw, profile, publicKey);
	}

	@Inject(method = "sleep", at = @At("TAIL"))
	public void onSleep(BlockPos position, CallbackInfo callbackInfo) {
		BetterSleeping.eventHandler.onSleep(cast(this));
	}

	@Inject(method = "wakeUp", at = @At("TAIL"))
	private void onWakeUp(boolean skipSleepTimer, boolean updateSleepingPlayers, CallbackInfo callbackInfo) {
		BetterSleeping.eventHandler.onWakeUp(cast(this));
	}

	private ServerPlayerEntity cast(PlayerEntity player) {
		return (ServerPlayerEntity) player;
	}
}
