package com.github.reviversmc.bettersleeping;

import java.util.List;

import com.github.reviversmc.bettersleeping.compat.minecraft.McVersionMixinProvider;

public class MixinProvider119 extends McVersionMixinProvider {
	@Override
	public List<String> getMixins() {
		if (BetterSleeping119.IS_COMPATIBLE.get()) {
			return List.of("ServerPlayerEntityMixin119");
		}

		return null;
	}
}
