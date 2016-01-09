package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.FileWriter.SetData;
import net.md_5.bungee.api.ChatColor;

public class SelectCommand {
	private static SetData SetData;

	public SelectCommand(SetData SetData) {
		SelectCommand.SetData = SetData;
	}

	public static void Select(CommandSender sender, String[] args) {
		try {
			int toSet = Integer.parseInt(args[1]);
			if (toSet == 1 || toSet == 2) {
				SetData.Set(sender.getName(), "selected", args[1]);
				sender.sendMessage(ChatColor.GREEN + "Character selection saved!");
			} else {
				sender.sendMessage(ChatColor.RED + "Invalid arguments! Must be 1 or 2!");
			}
		} catch (Exception e) {
			sender.sendMessage(ChatColor.RED + "Invalid arguments! /char select [1/2]");
		}
	}

}
