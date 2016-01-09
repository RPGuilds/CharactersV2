package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;
import me.XxXYaJrAbXxX.Characters.FileWriter.SetData;

public class AlignmentCommand {
	private static GetData GetData;
	private static SetData SetData;

	public AlignmentCommand(GetData GetData, SetData SetData) {
		AlignmentCommand.GetData = GetData;
		AlignmentCommand.SetData = SetData;
	}

	public static void Alignment(CommandSender sender, String[] args) {
		try {
			String selected = GetData.get(sender.getName(), "selected");
			if (args[1].equalsIgnoreCase("lg")) {
				String alignment = "Lawful good";
				SetData.Set(sender.getName(), "character" + selected + ".alignment", alignment);
				sender.sendMessage(ChatColor.GREEN + "Character alignment saved!");
			} else if (args[1].equalsIgnoreCase("ln")) {
				String alignment = "Lawful neutral";
				SetData.Set(sender.getName(), "character" + selected + ".alignment", alignment);
				sender.sendMessage(ChatColor.GREEN + "Character alignment saved!");
			} else if (args[1].equalsIgnoreCase("le")) {
				String alignment = "Lawful evil";
				SetData.Set(sender.getName(), "character" + selected + ".alignment", alignment);
				sender.sendMessage(ChatColor.GREEN + "Character alignment saved!");
			} else if (args[1].equalsIgnoreCase("ng")) {
				String alignment = "Neutral good";
				SetData.Set(sender.getName(), "character" + selected + ".alignment", alignment);
				sender.sendMessage(ChatColor.GREEN + "Character alignment saved!");
			} else if (args[1].equalsIgnoreCase("n")) {
				String alignment = "Neutral";
				SetData.Set(sender.getName(), "character" + selected + ".alignment", alignment);
				sender.sendMessage(ChatColor.GREEN + "Character alignment saved!");
			} else if (args[1].equalsIgnoreCase("ne")) {
				String alignment = "Neutral evil";
				SetData.Set(sender.getName(), "character" + selected + ".alignment", alignment);
				sender.sendMessage(ChatColor.GREEN + "Character alignment saved!");
			} else if (args[1].equalsIgnoreCase("cg")) {
				String alignment = "Chaotic good";
				SetData.Set(sender.getName(), "character" + selected + ".alignment", alignment);
				sender.sendMessage(ChatColor.GREEN + "Character alignment saved!");
			} else if (args[1].equalsIgnoreCase("cn")) {
				String alignment = "Chaotic neutral";
				SetData.Set(sender.getName(), "character" + selected + ".alignment", alignment);
				sender.sendMessage(ChatColor.GREEN + "Character alignment saved!");
			} else if (args[1].equalsIgnoreCase("ce")) {
				String alignment = "Chaotic evil";
				SetData.Set(sender.getName(), "character" + selected + ".alignment", alignment);
				sender.sendMessage(ChatColor.GREEN + "Character alignment saved!");
			} else {
				sender.sendMessage(
						ChatColor.RED + "Invalid arguments! /char alignment [lg, ln, le, ng, n, ne, cg, cn or ce]");
			}
		} catch (Exception e) {
			sender.sendMessage(
					ChatColor.RED + "Invalid arguments! /char alignment [lg, ln, le, ng, n, ne, cg, cn or ce]");
		}
	}
}
