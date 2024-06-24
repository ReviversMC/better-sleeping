package com.github.reviversmc.bettersleeping;

import java.util.Collections;
import java.util.List;

import com.github.reviversmc.bettersleeping.compat.minecraft.McVersionMixinProvider;

public class MixinProvider117 extends McVersionMixinProvider {
	@Override
	public List<String> getMixins() {
		if (BetterSleeping117.IS_COMPATIBLE.get()) {
			return Collections.singletonList("ServerPlayerEntityMixin117");
		}

		return null;
	}
}
