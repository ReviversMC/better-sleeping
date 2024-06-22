package com.github.reviversmc.bettersleeping.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

import com.github.reviversmc.bettersleeping.StatusEffectIds;

public class BuffConfig {
	public boolean applySleepBuffs = true;
	public List<Buff> buffs = new ArrayList<>(Arrays.asList(new Buff(StatusEffectIds.REGENERATION, 15, 2)));

	public static class Buff {
		public String id;

		@ConfigEntry.BoundedDiscrete(min = 1, max = 60)
		public int duration;

		@ConfigEntry.BoundedDiscrete(min = 1, max = 5)
		public int level;

		public Buff() {
		}

		public Buff(String id, int duration, int level) {
			this.id = id;
			this.duration = duration;
			this.level = level;
		}
	}
}
