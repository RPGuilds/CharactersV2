package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;
import me.XxXYaJrAbXxX.Characters.FileWriter.SetData;
import net.md_5.bungee.api.ChatColor;

public class ClassCommand {
	private static GetData GetData;
	private static SetData SetData;

	public ClassCommand(GetData GetData, SetData SetData) {
		ClassCommand.GetData = GetData;
		ClassCommand.SetData = SetData;
	}

	public static void Class(CommandSender sender, String[] args) {
		try {
			String selected = GetData.get(sender.getName(), "selected");
			if (args[1].equalsIgnoreCase("Brute") || args[1].equalsIgnoreCase("Wizard")
					|| args[1].equalsIgnoreCase("Archer") || args[1].equalsIgnoreCase("Scout")
					|| args[1].equalsIgnoreCase("Battlemage") || args[1].equalsIgnoreCase("Monk")
					|| args[1].equalsIgnoreCase("Warrior") || args[1].equalsIgnoreCase("Warlock")
					|| args[1].equalsIgnoreCase("Ranger") || args[1].equalsIgnoreCase("Rogue")
					|| args[1].equalsIgnoreCase("Child")) {
				String playerClass = args[1].toLowerCase();
				playerClass = playerClass.substring(0, 1).toUpperCase() + playerClass.substring(1);
				SetData.Set(sender.getName(), "character" + selected + ".class", playerClass);
				sender.sendMessage(ChatColor.GREEN + "Character class saved!");
			} else {
				sender.sendMessage(ChatColor.RED
						+ "Invalid arguments! /char class [Brute, Wizard, Archer, Scout, Battlemage, Monk, Warrior, Warlock, Ranger, Rogue or Child]");
			}
		} catch (Exception e) {
			sender.sendMessage(ChatColor.RED
					+ "Invalid arguments! /char class [Brute, Wizard, Archer, Scout, Battlemage, Monk, Warrior, Warlock, Ranger, Rogue or Child]");
		}
	}
}
