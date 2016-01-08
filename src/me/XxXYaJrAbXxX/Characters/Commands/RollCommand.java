package me.XxXYaJrAbXxX.Characters.Commands;

import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import me.XxXYaJrAbXxX.Characters.Utilities;
import me.XxXYaJrAbXxX.Characters.FileWriter.*;

public class RollCommand implements CommandExecutor {
	private static Utilities Utilities;

	
	public RollCommand(Utilities Utilities) {
		RollCommand.Utilities = Utilities;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd,
			String CommandLabel, String[] args) {
		if (CommandLabel.equalsIgnoreCase("roll") && sender instanceof Player) {
			if (args.length == 0) {
				Player player = (Player) sender;
				Config PlayerData = new Config(RollCommand.Utilities, sender.getName());
				int selected = PlayerData.getInt("selected");
				String name = PlayerData.getString("character." + selected + ".name");
				if (name == null) {
					sender.sendMessage(ChatColor.RED
							+ "Unable to obtain data. Please contact an Admin!");
					return true;
				} else {
					int range = (int) me.XxXYaJrAbXxX.Characters.DataCollect.GetData.getDefaultConfig("Roll_Range");
					Random rand = new Random();
					int n = rand.nextInt(20);
					sender.sendMessage(ChatColor.DARK_AQUA + "You "
							+ ChatColor.WHITE + "rolled a " + (n + 1) + "!");
					List<Entity> players = player.getNearbyEntities(range,
							range, range);
					for (int i1 = 0; i1 < players.size(); i1++) {
						if (players.get(i1) instanceof Player) {
							((Player) players.get(i1))
									.sendMessage(ChatColor.DARK_AQUA + name
											+ ChatColor.WHITE + "rolled a "
											+ (n + 1) + "!");
						}
					}
				}
			}
			if (args[0].equalsIgnoreCase("Dexterity")) {

			}
		}
		return false;
	}
}
