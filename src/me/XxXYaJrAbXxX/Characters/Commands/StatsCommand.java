package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;
import net.md_5.bungee.api.ChatColor;

public class StatsCommand {
	private static GetData GetData;
	private static String playersname = "";

	public StatsCommand(GetData GetData) {
		StatsCommand.GetData = GetData;
	}

	@SuppressWarnings("static-access")
	public static void Stats(CommandSender sender, String[] args) {
		try {
			if (args[1] != null) {
				playersname = args[1];
			}
		} catch (Exception e) {
			playersname = sender.getName();
		}
		try {
			String selected = GetData.get(playersname, "selected");
			String characterRace = GetData.get(playersname, "character" + selected + ".race");
			String characterClass = GetData.get(playersname, "character" + selected + ".class");
			int raceStrength = (int) GetData.getDefaultConfig(characterRace + "_Strength");
			int raceDexterity = (int) GetData.getDefaultConfig(characterRace + "_Dexterity");
			int raceWisdom = (int) GetData.getDefaultConfig(characterRace + "_Wisdom");
			int raceAgility = (int) GetData.getDefaultConfig(characterRace + "_Agility");
			int classStrength = (int) GetData.getDefaultConfig(characterClass + "_Strength");
			int classDexterity = (int) GetData.getDefaultConfig(characterClass + "_Dexterity");
			int classWisdom = (int) GetData.getDefaultConfig(characterClass + "_Wisdom");
			int classAgility = (int) GetData.getDefaultConfig(characterClass + "_Agility");
			int Strength = raceStrength + classStrength;
			int Dexterity = raceDexterity + classDexterity;
			int Wisdom = raceWisdom + classWisdom;
			int Agility = raceAgility + classAgility;
			if (playersname == sender.getName()) {
				sender.sendMessage(ChatColor.GOLD + "Your character's strength stat is: " + ChatColor.WHITE + Strength);
				sender.sendMessage(ChatColor.GOLD + "Your character's ranged stat is: " + ChatColor.WHITE + Dexterity);
				sender.sendMessage(ChatColor.GOLD + "Your character's magic stat is: " + ChatColor.WHITE + Wisdom);
				sender.sendMessage(ChatColor.GOLD + "Your character's agility stat is: " + ChatColor.WHITE + Agility);
			} else {
				sender.sendMessage(
						ChatColor.GOLD + "Their character's strength stat is: " + ChatColor.WHITE + Strength);
				sender.sendMessage(ChatColor.GOLD + "Their character's ranged stat is: " + ChatColor.WHITE + Dexterity);
				sender.sendMessage(ChatColor.GOLD + "Their character's magic stat is: " + ChatColor.WHITE + Wisdom);
				sender.sendMessage(ChatColor.GOLD + "Their character's agility stat is: " + ChatColor.WHITE + Agility);
			}
		} catch (Exception e) {
			sender.sendMessage(ChatColor.RED + "You must set up your character sheet properly first!");
		}
	}
}
