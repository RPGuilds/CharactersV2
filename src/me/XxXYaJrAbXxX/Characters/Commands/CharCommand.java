package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CharCommand {
	HelpCommand HelpCommand = new HelpCommand();
	NameCommand NameCommand = new NameCommand(null);
	
	public void onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
			if (args[0].equalsIgnoreCase("help")) {
				me.XxXYaJrAbXxX.Characters.Commands.HelpCommand.help(sender);
			} else if (args[0].equalsIgnoreCase("name")) {
				me.XxXYaJrAbXxX.Characters.Commands.NameCommand.Name(sender, args);
			} else if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Type '/char help' for a list of commands!");
			} else {
				sender.sendMessage(ChatColor.RED + "Type '/char help' for a list of commands!");
			}		
	}
}