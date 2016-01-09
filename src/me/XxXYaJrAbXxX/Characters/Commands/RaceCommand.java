package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;
import me.XxXYaJrAbXxX.Characters.DataCollect.*;
import me.XxXYaJrAbXxX.Characters.FileWriter.*;

public class RaceCommand {
	private static GetData GetData;
	private static SetData SetData;
	
	public RaceCommand(GetData GetData, SetData SetData) {
		RaceCommand.GetData = GetData;
		RaceCommand.SetData = SetData;
	}

	public static void Race(CommandSender sender, String[] args) {
		try {
			String selected = GetData.get(sender.getName(), "selected");
			if (args[1].equalsIgnoreCase("Human") || args[1].equalsIgnoreCase("Dwarf") ||
					args[1].equalsIgnoreCase("JaQol") || args[1].equalsIgnoreCase("Orc") ||
					args[1].equalsIgnoreCase("Droconar") || args[1].equalsIgnoreCase("Elf") ||
					args[1].equalsIgnoreCase("DarkElf")) {
				String race = args[1].toLowerCase();
				race = race.substring(0, 1).toUpperCase() + race.substring(1);
				SetData.Set(sender.getName(), "character" + selected + ".race", race);
				sender.sendMessage(ChatColor.GREEN + "Character race saved!");
			} else {
				sender.sendMessage(ChatColor.RED + "Invalid modifiers! /char race [Human, Dwarf, JaQol, Orc, Droconar, Elf or DarkElf]");
			}
		} catch (Exception e) {
			sender.sendMessage(ChatColor.RED + "Invalid modifiers! /char race [Human, Dwarf, JaQol, Orc, Droconar, Elf or DarkElf]");
		}
	}

}
