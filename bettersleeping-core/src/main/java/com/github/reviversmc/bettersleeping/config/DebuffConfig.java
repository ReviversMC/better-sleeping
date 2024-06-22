package com.github.reviversmc.bettersleeping.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

import com.github.reviversmc.bettersleeping.StatusEffectIds;

public class DebuffConfig {
	public boolean applyAwakeDebuffs = true;
	public boolean applyAwakeDebuffsWhenAloneOnServer = true;

	public List<Debuff> debuffs = new ArrayList<>(Arrays.asList(
		new Debuff(StatusEffectIds.SLOWNESS, 2, 10, 1.3f, 180, 1.2f, 2),
		new Debuff(StatusEffectIds.WEAKNESS, 3, 10, 1.3f, 240, 1f, 1),
		new Debuff(StatusEffectIds.NAUSEA, 4, 10, 1.2f, 60, 1f, 1),
		new Debuff(StatusEffectIds.MINING_FATIGUE, 4, 10, 1.2f, 120, 1.1f, 2),
		new Debuff(StatusEffectIds.BLINDNESS, 5, 7, 1.2f, 40, 1f, 1)));

	public static class Debuff {
		public String id;

		@ConfigEntry.BoundedDiscrete(min = 1, max = 20)
		public int allowedAwakeNightsBeforeActivating;

		@ConfigEntry.BoundedDiscrete(min = 1, max = 40)
		public int baseDuration;

		@ConfigEntry.BoundedDiscrete(min = 1, max = 5)
		public float durationAmplifier;

		@ConfigEntry.BoundedDiscrete(min = 30, max = 1200) // up to a full day (20 minutes)
		public int maxDuration;

		@ConfigEntry.BoundedDiscrete(min = 1, max = 3)
		public float levelAmplifier;

		@ConfigEntry.BoundedDiscrete(min = 1, max = 5)
		public int maxLevel;

		public Debuff() {
		}

		public Debuff(
				String id,
				int allowedAwakeNightsBeforeActivating,
				int baseDuration,
				float durationAmplifier,
				int maxDuration,
				float levelAmplifier,
				int maxLevel) {
			this.id = id;
			this.allowedAwakeNightsBeforeActivating = allowedAwakeNightsBeforeActivating;
			this.baseDuration = baseDuration;
			this.durationAmplifier = durationAmplifier;
			this.maxDuration = maxDuration;
			this.levelAmplifier = levelAmplifier;
			this.maxLevel = maxLevel;
		}
	}
}
