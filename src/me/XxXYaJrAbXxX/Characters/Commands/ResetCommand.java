package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.FileWriter.SetData;
import net.md_5.bungee.api.ChatColor;

public class ResetCommand {
	private static SetData SetData;

	public ResetCommand(SetData SetData) {
		ResetCommand.SetData = SetData;
	}

	public static void Reset(CommandSender sender, String[] args) {
		try {
			if (args[1].equalsIgnoreCase(null)) {

			} else {
				if ((Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[1])) == true)
						&& sender.hasPermission("characters.character.reset.others")) {
					SetData.regeneratePlayerData(args[1]);
					sender.sendMessage(ChatColor.GREEN + "Their selected character template was reset and saved!");
					Bukkit.getPlayer(args[1])
							.sendMessage(ChatColor.GREEN + "Your selected character template was reset and saved!");
				} else {
					sender.sendMessage(ChatColor.RED + "That player must be either online or does not exist!");
				}
			}
		} catch (Exception e) {
			SetData.generatePlayerData(sender.getName());
			sender.sendMessage(ChatColor.GREEN + "Your selected character template was reset and saved!");
		}
	}
}