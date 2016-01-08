package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.XxXYaJrAbXxX.Characters.Utilities;
import me.XxXYaJrAbXxX.Characters.FileWriter.Config;

public class NameCommand implements Listener {
	private final Utilities util;
	
	public NameCommand(Utilities util) {
		this.util = util;
	}

	public static void Name(CommandSender sender, String[] args) {
		String name = args[1];
		for (int i = 2; i < args.length; i++) {
			name += " " + args[i];
		}
	}
}
