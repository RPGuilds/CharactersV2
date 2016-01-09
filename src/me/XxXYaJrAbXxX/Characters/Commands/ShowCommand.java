package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;

public class ShowCommand {
	
	private static GetData GetData;
	private static String playersname = "";
	public ShowCommand(GetData GetData) {
		ShowCommand.GetData = GetData;
	}

	public static void Show(CommandSender sender, String[] args) {
		try {
			if (args[1] != null) {
				playersname = args[1];
			}
		} catch (Exception e) {
			playersname = sender.getName();
		}
		if (playersname == sender.getName()) {
			sender.sendMessage(ChatColor.GOLD + "First Character:");
			sender.sendMessage(ChatColor.GOLD + "Your first character's name is: " + ChatColor.WHITE + (GetData.get(playersname, "character1.name") == null ? "" : GetData.get(playersname, "character1.name")));
			sender.sendMessage(ChatColor.GOLD + "Your first character's gender is: " + ChatColor.WHITE + (GetData.get(playersname, "character1.gender") == null ? "" : GetData.get(playersname, "character1.gender")));
        	sender.sendMessage(ChatColor.GOLD + "Your first character's race is: " + ChatColor.WHITE + (GetData.get(playersname, "character1.race") == null ? "" : GetData.get(playersname, "character1.race")));
        	sender.sendMessage(ChatColor.GOLD + "Your first character's class is: " + ChatColor.WHITE + (GetData.get(playersname, "character1.class") == null ? "" : GetData.get(playersname, "character1.class")));
        	sender.sendMessage(ChatColor.GOLD + "Your first character's alignment is: " + ChatColor.WHITE + (GetData.get(playersname, "character1.alignment") == null ? "" : GetData.get(playersname, "character1.alignment")));
        	sender.sendMessage(ChatColor.GOLD + "Your first character's hometown is: " + ChatColor.WHITE + (GetData.get(playersname, "character1.hometown") == null ? "" : GetData.get(playersname, "character1.hometown")));
        	sender.sendMessage(ChatColor.GOLD + "Second Character:");
        	sender.sendMessage(ChatColor.GOLD + "Your second character's name is: " + ChatColor.WHITE + (GetData.get(playersname, "character2.name") == null ? "" : GetData.get(playersname, "character2.name")));
        	sender.sendMessage(ChatColor.GOLD + "Your second character's gender is: " + ChatColor.WHITE + (GetData.get(playersname, "character2.gender") == null ? "" : GetData.get(playersname, "character2.gender")));
        	sender.sendMessage(ChatColor.GOLD + "Your second character's race is: " + ChatColor.WHITE + (GetData.get(playersname, "character2.race") == null ? "" : GetData.get(playersname, "character2.race")));
        	sender.sendMessage(ChatColor.GOLD + "Your second character's class is: " + ChatColor.WHITE + (GetData.get(playersname, "character2.class") == null ? "" : GetData.get(playersname, "character2.class")));
        	sender.sendMessage(ChatColor.GOLD + "Your second character's alignment is: " + ChatColor.WHITE + (GetData.get(playersname, "character2.alignment") == null ? "" : GetData.get(playersname, "character2.alignment")));
        	sender.sendMessage(ChatColor.GOLD + "Your second character's hometown is: " + ChatColor.WHITE + (GetData.get(playersname, "character2.hometown") == null ? "" : GetData.get(playersname, "character2.hometown")));
        	sender.sendMessage(ChatColor.GOLD + "Character in use: " + ChatColor.WHITE + (GetData.get(playersname, "selected") == null ? "1" : GetData.get(playersname, "selected")));
		} else if (playersname != sender.getName()) {
			sender.sendMessage(ChatColor.GOLD + "First Character:");
			sender.sendMessage(ChatColor.GOLD + "Their first character's name is: " + ChatColor.WHITE + (GetData.get(playersname, "character1.name") == null ? "" : GetData.get(playersname, "character1.name")));
			sender.sendMessage(ChatColor.GOLD + "Their first character's gender is: " + ChatColor.WHITE + (GetData.get(playersname, "character1.gender") == null ? "" : GetData.get(playersname, "character1.gender")));
        	sender.sendMessage(ChatColor.GOLD + "Their first character's race is: " + ChatColor.WHITE + (GetData.get(playersname, "character1.race") == null ? "" : GetData.get(playersname, "character1.race")));
        	sender.sendMessage(ChatColor.GOLD + "Their first character's class is: " + ChatColor.WHITE + (GetData.get(playersname, "character1.class") == null ? "" : GetData.get(playersname, "character1.class")));
        	sender.sendMessage(ChatColor.GOLD + "Their first character's alignment is: " + ChatColor.WHITE + (GetData.get(playersname, "character1.alignment") == null ? "" : GetData.get(playersname, "character1.alignment")));
        	sender.sendMessage(ChatColor.GOLD + "Their first character's hometown is: " + ChatColor.WHITE + (GetData.get(playersname, "character1.hometown") == null ? "" : GetData.get(playersname, "character1.hometown")));
        	sender.sendMessage(ChatColor.GOLD + "Second Character:");
        	sender.sendMessage(ChatColor.GOLD + "Their second character's name is: " + ChatColor.WHITE + (GetData.get(playersname, "character2.name") == null ? "" : GetData.get(playersname, "character2.name")));
        	sender.sendMessage(ChatColor.GOLD + "Their second character's gender is: " + ChatColor.WHITE + (GetData.get(playersname, "character2.gender") == null ? "" : GetData.get(playersname, "character2.gender")));
        	sender.sendMessage(ChatColor.GOLD + "Their second character's race is: " + ChatColor.WHITE + (GetData.get(playersname, "character2.race") == null ? "" : GetData.get(playersname, "character2.race")));
        	sender.sendMessage(ChatColor.GOLD + "Their second character's class is: " + ChatColor.WHITE + (GetData.get(playersname, "character2.class") == null ? "" : GetData.get(playersname, "character2.class")));
        	sender.sendMessage(ChatColor.GOLD + "Their second character's alignment is: " + ChatColor.WHITE + (GetData.get(playersname, "character2.alignment") == null ? "" : GetData.get(playersname, "character2.alignment")));
        	sender.sendMessage(ChatColor.GOLD + "Their second character's hometown is: " + ChatColor.WHITE + (GetData.get(playersname, "character2.hometown") == null ? "" : GetData.get(playersname, "character2.hometown")));
        	sender.sendMessage(ChatColor.GOLD + "Character in use: " + ChatColor.WHITE + (GetData.get(playersname, "selected") == null ? "1" : GetData.get(playersname, "selected")));
		}
	}
}
