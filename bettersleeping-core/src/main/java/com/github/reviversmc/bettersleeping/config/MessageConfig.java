package com.github.reviversmc.bettersleeping.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

public class MessageConfig {
	public String nightSkippedMessage = "Rise and shine!";
	public boolean sendNightSkippedMessageToEveryone = false;

	@Comment(
			"Placeholders:\n"
			+ "§f- {nightsAwake}\n"
			+ "§7   Number of nights skipped")
	public String debuffMessage = "You have been awake for {nightsAwake} nights and have been given a debuff.";

	@Comment(
			"Placeholders:\n"
			+ "§f- {asleepPlayers}\n"
			+ "§7   Number of asleep players\n"
			+ "§f- {totalPlayers}\n"
			+ "§7   Total number of players\n"
			+ "§f- {asleepPercentage}\n"
			+ "§7   Percentage of players that are asleep\n"
			+ "§f- {asleepPlayersRequired}\n"
			+ "§7   Number of players required to skip the night\n"
			+ "§f- {asleepPercentageRequired}\n"
			+ "§7   Percentage of players required to skip the night\n"
			+ "§f- {asleepPlayersAdditionallyNeeded}\n"
			+ "§7   Number of players additionally needed to sleep\n"
			+ "§7   to skip the night")
	public String playersAsleepMessage = "{asleepPlayers}/{totalPlayers} ({asleepPercentage}%) players are now sleeping!";

	@Comment(
			"Placeholders:\n"
			+ "§f- {asleepPlayers}\n"
			+ "§7   Number of asleep players\n"
			+ "§f- {totalPlayers}\n"
			+ "§7   Total number of players\n"
			+ "§f- {asleepPercentage}\n"
			+ "§7   Percentage of players that are asleep\n"
			+ "§f- {asleepPlayersRequired}\n"
			+ "§7   Number of players required to skip the night\n"
			+ "§f- {asleepPercentageRequired}\n"
			+ "§7   Percentage of players required to skip the night\n"
			+ "§f- {asleepPlayersAdditionallyNeeded}\n"
			+ "§7   Number of players additionally needed to sleep\n"
			+ "§7   to skip the night")
	public String notEnoughPlayersAsleepMessage = "{asleepPlayers}/{totalPlayers} ({asleepPercentage}%) players are now sleeping. {asleepPlayersAdditionallyNeeded} more required to skip the night!";

	@Comment("List of formatting codes. See here: https://minecraft.wiki/w/Formatting_codes")
	public List<String> messageFormatting = new ArrayList<>(Arrays.asList("gold"));
}
