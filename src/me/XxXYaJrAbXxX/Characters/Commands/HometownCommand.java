package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;
import me.XxXYaJrAbXxX.Characters.FileWriter.SetData;
import net.md_5.bungee.api.ChatColor;

public class HometownCommand {
	private static GetData GetData;
	private static SetData SetData;

	public HometownCommand(GetData GetData, SetData SetData) {
		HometownCommand.GetData = GetData;
		HometownCommand.SetData = SetData;
	}

	public static void Hometown(CommandSender sender, String[] args) {
		try {
			String selected = GetData.get(sender.getName(), "selected");
			if (args[1] != null) {
				String hometown = args[1].toLowerCase();
				hometown = hometown.substring(0, 1).toUpperCase() + hometown.substring(1);
				SetData.Set(sender.getName(), "character" + selected + ".hometown", hometown);
				sender.sendMessage(ChatColor.GREEN + "Character hometown saved!");
			}
		} catch (Exception e) {
			sender.sendMessage(ChatColor.RED + "Invalid arguments! /char hometown [hometown name]");
		}
	}
}
