package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.command.CommandSender;
import me.XxXYaJrAbXxX.Characters.FileWriter.*;
import net.md_5.bungee.api.ChatColor;
import me.XxXYaJrAbXxX.Characters.DataCollect.*;

public class GenderCommand {
	private static GetData GetData;
	private static SetData SetData;

	public GenderCommand(GetData GetData, SetData SetData) {
		GenderCommand.GetData = GetData;
		GenderCommand.SetData = SetData;
	}

	public static void Gender(CommandSender sender, String[] args) {
		try {
			String selected = GetData.get(sender.getName(), "selected");
			if (args[1].equalsIgnoreCase("male") || args[1].equalsIgnoreCase("female")) {
				String gender = args[1].toLowerCase();
				gender = gender.substring(0, 1).toUpperCase() + gender.substring(1);
				SetData.Set(sender.getName(), "character" + selected + ".gender", gender);
				sender.sendMessage(ChatColor.GREEN + "Character gender saved!");
			} else {
				sender.sendMessage(ChatColor.RED + "Invalid argements! /char gender [male/female]");
			}
		} catch (Exception e) {
			sender.sendMessage(ChatColor.RED + "Invalid arguments! /char gender [male/female]");
		}
	}

}
