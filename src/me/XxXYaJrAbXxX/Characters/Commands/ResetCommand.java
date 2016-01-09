package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.FileWriter.SetData;
import net.md_5.bungee.api.ChatColor;

public class ResetCommand {
	private static SetData SetData;

	public ResetCommand(SetData SetData) {
		ResetCommand.SetData = SetData;
	}

	public static void Reset(CommandSender sender, String[] args) {
		SetData.generatePlayerData(sender.getName());
		sender.sendMessage(ChatColor.GREEN + "Character templates were reset and saved!");
	}
}
