package me.XxXYaJrAbXxX.Characters.DataCollect;

import java.util.logging.Level;
import java.util.logging.Logger;

import me.XxXYaJrAbXxX.Characters.Utilities;
import me.XxXYaJrAbXxX.Characters.Commands.*;
import me.XxXYaJrAbXxX.Characters.FileWriter.Config;

import org.bukkit.ChatColor;

public class GetData {
	static Logger logger = Logger.getLogger("Minecraft");
	CharCommand CharCommand = new CharCommand(this);

	private static Utilities Utilities;

	public GetData(Utilities Utilities) {
		GetData.Utilities = Utilities;
	}

	public String get(String player, String path) {
		Config PlayerData = new Config(GetData.Utilities, player);
		String data = PlayerData.getString(path);
		return data;
	}

	public static Object getDefaultConfig(String string) {
		try {
			Object data = Utilities.getConfig().options().configuration().get(string);
			return data;
		} catch (NullPointerException e) {
			logger.log(Level.SEVERE, ChatColor.RED + "Error Code: NPE-GD.30");
		}
		return null;
	}

}
