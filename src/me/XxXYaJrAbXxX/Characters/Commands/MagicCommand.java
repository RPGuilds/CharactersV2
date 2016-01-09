package me.XxXYaJrAbXxX.Characters.Commands;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;
import me.XxXYaJrAbXxX.Characters.FileWriter.SetData;
import net.md_5.bungee.api.ChatColor;

public class MagicCommand {
	private static GetData GetData;
	private static SetData SetData;

	public MagicCommand(GetData GetData, SetData SetData) {
		MagicCommand.GetData = GetData;
		MagicCommand.SetData = SetData;
	}

	public static void Magic(CommandSender sender, String[] args) {
		try {
			String teacherSelected = GetData.get(sender.getName(), "selected");
			if (args[1] != null) {
				Collection<? extends Player> playerList = (Bukkit.getOnlinePlayers());
				Player player = Bukkit.getServer().getPlayer(args[1]);
				if (playerList.contains(player) == true && player.getName() != sender.getName()) {
					if (args[2].equalsIgnoreCase("pyromancy") || args[2].equalsIgnoreCase("aquamancy")
							|| args[2].equalsIgnoreCase("geomancy") || args[2].equalsIgnoreCase("aeromancy")
							|| args[2].equalsIgnoreCase("restoration") || args[2].equalsIgnoreCase("psionics")
							|| args[2].equalsIgnoreCase("druidry") || args[2].equalsIgnoreCase("bloodmagic")
							|| args[2].equalsIgnoreCase("necromancy") || args[2].equalsIgnoreCase("illusions")) {
						if (args[3].equalsIgnoreCase("novice") || args[3].equalsIgnoreCase("apprentice")
								|| args[3].equalsIgnoreCase("adept") || args[3].equalsIgnoreCase("expert")
								|| args[3].equalsIgnoreCase("master")) {
							String magic = args[2].toLowerCase();
							String studentSelected = GetData.get(player.getName(), "selected");
							String teacherLevel = GetData.get(sender.getName(),
									"character" + teacherSelected + ".magic." + magic);
							if (args[3].equalsIgnoreCase("novice")
									&& (teacherLevel.equalsIgnoreCase("Apprentice in " + magic)
											|| teacherLevel.equalsIgnoreCase("Adept in " + magic)
											|| teacherLevel.equalsIgnoreCase("Expert in " + magic)
											|| teacherLevel.equalsIgnoreCase("Master in " + magic))) {
								SetData.Set(player.getName(), "character" + studentSelected + ".magic." + magic,
										"Novice in " + magic);
								sender.sendMessage(
										ChatColor.GREEN + player.getName() + " is now a novice in " + magic + "!");
								player.sendMessage(ChatColor.GREEN + "You are now a novice in " + magic + "!");
							} else if (args[3].equalsIgnoreCase("apprentice")
									&& (teacherLevel.equalsIgnoreCase("Adept in " + magic)
											|| teacherLevel.equalsIgnoreCase("Expert in " + magic)
											|| teacherLevel.equalsIgnoreCase("Master in " + magic))) {
								SetData.Set(player.getName(), "character" + studentSelected + ".magic." + magic,
										"Apprentice in " + magic);
								sender.sendMessage(
										ChatColor.GREEN + player.getName() + " is now an apprentice in " + magic + "!");
								player.sendMessage(ChatColor.GREEN + "You are now an apprentice in " + magic + "!");
							} else if (args[3].equalsIgnoreCase("adept")
									&& (teacherLevel.equalsIgnoreCase("Adept in " + magic)
											|| teacherLevel.equalsIgnoreCase("Expert in " + magic)
											|| teacherLevel.equalsIgnoreCase("Master in " + magic))) {
								SetData.Set(player.getName(), "character" + studentSelected + ".magic." + magic,
										"Adept in " + magic);
								sender.sendMessage(
										ChatColor.GREEN + player.getName() + " is now an adept in " + magic + "!");
								player.sendMessage(ChatColor.GREEN + "You are now an adept in " + magic + "!");
							} else if (args[3].equalsIgnoreCase("expert")
									&& (teacherLevel.equalsIgnoreCase("Expert in " + magic)
											|| teacherLevel.equalsIgnoreCase("Master in " + magic))) {
								SetData.Set(player.getName(), "character" + studentSelected + ".magic." + magic,
										"Expert in " + magic);
								sender.sendMessage(
										ChatColor.GREEN + player.getName() + " is now an expert in " + magic + "!");
								player.sendMessage(ChatColor.GREEN + "You are now a expert in " + magic + "!");
							} else if (args[3].equalsIgnoreCase("master")
									&& sender.hasPermission("characters.character.magic.master")) {
								SetData.Set(player.getName(), "character" + studentSelected + ".magic." + magic,
										"Master in " + magic);
								sender.sendMessage(
										ChatColor.GREEN + player.getName() + " is now a master in " + magic + "!");
								player.sendMessage(ChatColor.GREEN + "You are now a master in " + magic + "!");
							} else {
								sender.sendMessage(ChatColor.RED
										+ "You are not a high enough magic level to level this character up!");
							}
						} else {
							sender.sendMessage(ChatColor.RED
									+ "This expertise does not exist! /char magic [name] [magic] [level]");
						}
					} else {
						sender.sendMessage(
								ChatColor.RED + "This magic does not exist! /char magic [name] [magic] [level]");
					}
				} else {
					sender.sendMessage(
							ChatColor.RED + "That player cannot be found! /char magic [name] [magic] [level]");
				}
			}
		} catch (Exception e) {
			sender.sendMessage(ChatColor.RED + "Invalid arguments! /char magic [name] [magic] [level]");
		}
	}
}