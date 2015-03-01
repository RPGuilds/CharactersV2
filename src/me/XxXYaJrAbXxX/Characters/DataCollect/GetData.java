package me.XxXYaJrAbXxX.Characters.DataCollect;

import java.util.logging.Level;
import java.util.logging.Logger;

import me.XxXYaJrAbXxX.Characters.Utilities;
import me.XxXYaJrAbXxX.Characters.FileWriter.Config;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class GetData implements Listener {
	Logger logger = Logger.getLogger("Minecraft");
	private final Utilities utilities;
	
	public GetData(Utilities utilities) {
		this.utilities = utilities;
	}
	
	public String get(CommandSender sender, String parm1, String parm2) {
		try {
			Config PlayerData = new Config(this.utilities, sender.getName());
			int Selected = PlayerData.getInt("Selected");
			String data = PlayerData.getString("character" + Selected + parm1
					+ parm2);
			return data;
		} catch (NullPointerException e) {
			sender.sendMessage(ChatColor.RED + "Error Code: NPE-RD.17");
		}
		return null;
	}

	public Object getDefaultConfig(String string) {
		try {
		Object data = this.utilities.getConfig().options().configuration().get(string);
		return data;
		} catch (NullPointerException e) {
			logger.log(Level.SEVERE ,ChatColor.RED + "Error Code: NPE-GD.36/37");
		}
		return null;
	}

}
