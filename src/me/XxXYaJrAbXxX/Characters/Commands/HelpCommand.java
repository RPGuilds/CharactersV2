package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.Commands.*;

@SuppressWarnings("unused")
public class HelpCommand {

	public static void help(CommandSender sender) {
		sender.sendMessage(ChatColor.GOLD + "Available commands:");
		sender.sendMessage(ChatColor.GOLD + "/char select <1/2>: " + ChatColor.WHITE
				+ "selects the roleplay character you are using/editing");
		sender.sendMessage(
				ChatColor.GOLD + "/char name <name>: " + ChatColor.WHITE + "sets your roleplay characters name");
		sender.sendMessage(
				ChatColor.GOLD + "/char gender <gender>: " + ChatColor.WHITE + "sets your roleplay characters gender");
		sender.sendMessage(
				ChatColor.GOLD + "/char race <race>: " + ChatColor.WHITE + "sets your roleplay characters race");
		sender.sendMessage(
				ChatColor.GOLD + "/char class <class>: " + ChatColor.WHITE + "sets your roleplay characters class");
		sender.sendMessage(ChatColor.GOLD + "/char alignment <alignment>: " + ChatColor.WHITE
				+ "sets your roleplay characters alignment");
		sender.sendMessage(ChatColor.GOLD + "/char hometown <hometown>: " + ChatColor.WHITE
				+ "sets your roleplay characters hometown");
		sender.sendMessage(
				ChatColor.GOLD + "/char show <name>: " + ChatColor.WHITE + "shows roleplay character information");
		sender.sendMessage(
				ChatColor.GOLD + "/char stats <name>: " + ChatColor.WHITE + "shows roleplay character stats");
		sender.sendMessage(ChatColor.GOLD + "/char reset: " + ChatColor.WHITE + "resets entire roleplay character");
		sender.sendMessage(
				ChatColor.GOLD + "/roll <melee, dexterity or magic>: " + ChatColor.WHITE + "rolls a dice for a skill");
	}
}