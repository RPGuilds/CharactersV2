package me.XxXYaJrAbXxX.Characters.Commands;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.Utilities;
import me.XxXYaJrAbXxX.Characters.FileWriter.Config;

public class ShowCommand {
	
	private static Utilities Utilities;
	private static String playersname = "";
	public ShowCommand(Utilities Utilities) {
		ShowCommand.Utilities = Utilities;
	}

	public static void Show(CommandSender sender, String[] args) {
		try {
			if (args[1] != null) {
				playersname = args[1];
			}
		} catch (Exception e) {
			playersname = sender.getName();
		}
		sender.sendMessage(playersname);
		Config PlayerData = new Config(ShowCommand.Utilities, "PlayerData" + File.separator + playersname + ".yml");
		sender.sendMessage(ChatColor.GOLD + "First Character:");
        sender.sendMessage(ChatColor.GOLD + "Your first character's name is: " + ChatColor.WHITE + (PlayerData.getString("character1.name") == null ? "N/A" : PlayerData.getString("character1.name")));
        sender.sendMessage(ChatColor.GOLD + "Your first character's gender is: " + ChatColor.WHITE + (PlayerData.getString("character1.gender") == null ? "N/A" : PlayerData.getString("character1.gender")));
        sender.sendMessage(ChatColor.GOLD + "Your first character's race is: " + ChatColor.WHITE + (PlayerData.getString("character1.race") == null ? "N/A" : PlayerData.getString("character1.race")));
        sender.sendMessage(ChatColor.GOLD + "Your first character's class is: " + ChatColor.WHITE + (PlayerData.getString("character1.class") == null ? "N/A" : PlayerData.getString("character1.class")));
        sender.sendMessage(ChatColor.GOLD + "Your first character's alignment is: " + ChatColor.WHITE + (PlayerData.getString("character1.alignment") == null ? "N/A" : PlayerData.getString("character1.alignment")));
        sender.sendMessage(ChatColor.GOLD + "Your first character's hometown is: " + ChatColor.WHITE + (PlayerData.getString("character1.hometown") == null ? "N/A" : PlayerData.getString("character1.hometown")));
        sender.sendMessage(ChatColor.GOLD + "Second Character:");
        sender.sendMessage(ChatColor.GOLD + "Your second character's name is: " + ChatColor.WHITE + (PlayerData.getString("character2.name") == null ? "N/A" : PlayerData.getString("character2.name")));
        sender.sendMessage(ChatColor.GOLD + "Your second character's gender is: " + ChatColor.WHITE + (PlayerData.getString("character2.gender") == null ? "N/A" : PlayerData.getString("character2.gender")));
        sender.sendMessage(ChatColor.GOLD + "Your second character's race is: " + ChatColor.WHITE + (PlayerData.getString("character2.race") == null ? "N/A" : PlayerData.getString("character2.race")));
        sender.sendMessage(ChatColor.GOLD + "Your second character's class is: " + ChatColor.WHITE + (PlayerData.getString("character2.class") == null ? "N/A" : PlayerData.getString("character2.class")));
        sender.sendMessage(ChatColor.GOLD + "Your second character's alignment is: " + ChatColor.WHITE + (PlayerData.getString("character2.alignment") == null ? "N/A" : PlayerData.getString("character2.alignment")));
        sender.sendMessage(ChatColor.GOLD + "Your second character's hometown is: " + ChatColor.WHITE + (PlayerData.getString("character2.hometown") == null ? "N/A" : PlayerData.getString("character2.hometown")));
	}
}
