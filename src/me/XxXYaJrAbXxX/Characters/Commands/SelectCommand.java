package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;
import me.XxXYaJrAbXxX.Characters.FileWriter.SetData;
import net.md_5.bungee.api.ChatColor;

public class SelectCommand {
	private static SetData SetData;
	private static GetData GetData;

	public SelectCommand(GetData GetData, SetData SetData) {
		SelectCommand.GetData = GetData;
		SelectCommand.SetData = SetData;
	}

	public static void Select(CommandSender sender, String[] args) {
		try {
			int toSet = Integer.parseInt(args[1]);
			if (toSet == 1 || toSet == 2) {
				SetData.Set(sender.getName(), "selected", args[1]);
				sender.sendMessage(ChatColor.GREEN + "Character selection saved!");
				String name = GetData.get(sender.getName(), "character" + args[1] + ".name");
				if (name.contains(" ")) {
					String nickname = name.replace(" ", "_");
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
							"nick " + sender.getName() + " " + nickname);
				} else {
					String nickname = name;
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
							"nick " + sender.getName() + " " + nickname);
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Invalid arguments! Must be 1 or 2!");
			}
		} catch (Exception e) {
			sender.sendMessage(ChatColor.RED + "Invalid arguments! /char select [1/2]");
		}
	}

}
