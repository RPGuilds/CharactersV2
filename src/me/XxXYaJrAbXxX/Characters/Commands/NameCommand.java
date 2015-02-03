package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.Utilities;

public class NameCommand {
	
	public static void Name(CommandSender sender, String[] args) {
		String name = args[1];
		for (int i = 2; i < args.length; i++) {
			name += " " + args[i];
		}
		Utilities.Set(sender, "name", "", name);
	}
}
