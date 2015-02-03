package me.XxXYaJrAbXxX.Characters;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import me.XxXYaJrAbXxX.Characters.Listeners.*;
import me.XxXYaJrAbXxX.Characters.FileWriter.Config;
import me.XxXYaJrAbXxX.Characters.Commands.CharCommand;
import me.XxXYaJrAbXxX.Characters.Commands.RollCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Utilities extends JavaPlugin implements Listener {
	public JoinListener Joinlistener = new JoinListener();
	public RollCommand RollCommand = new RollCommand();
	public CharCommand CharCommand = new CharCommand();
	Logger logger = Logger.getLogger("Minecraft");

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		getConfig().options().copyDefaults(true);
		new File(this.getDataFolder(), null).mkdirs();
		File file = new File("/plugins/CharactersV2/");
		for (Player player : Bukkit.getOnlinePlayers()) {
			Config PlayerData = new Config(this, "PlayerData" + File.separator
					+ player.getName());
		}
		if (!file.exists()) {
			new File("/plugins/CharactersV2/").mkdirs();
		}
		try {
			this.getServer().getPluginManager()
					.registerEvents(Joinlistener, this);
		} catch (Exception e) {
			
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
	try {
	if (CommandLabel.equalsIgnoreCase("char")) {
		CharCommand.onCommand(sender, cmd, CommandLabel, args);
		return true;
	} else if (CommandLabel.equalsIgnoreCase("roll")) {
		RollCommand.onCommand(sender, cmd, CommandLabel, args);
		return true;
	}
	} catch (ArrayIndexOutOfBoundsException e) {
		sender.sendMessage(ChatColor.RED + "Type '/char help' for help!");
		return true;
	}
	return false;

	}
	
	//Data collection resources
	public String get(CommandSender sender, String parm1, String parm2) {
		try {
			Config PlayerData = new Config(this, sender.getName());
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
		Object data = this.getConfig().options().configuration().get(string);
		return data;
		} catch (NullPointerException e) {
			logger.log(Level.SEVERE ,ChatColor.RED + "Error Code: NPE-RD.17");
		}
		return null;
	}
	
	public void Set(CommandSender sender, String parm1, String parm2, String value) {
		Config PlayerData = new Config(this, sender.getName());
		int Selected = PlayerData.getInt("Selected");
		PlayerData.set("character" + Selected + parm1 + parm2, value);
		PlayerData.save();
		}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent player) {
		Config PlayerData = new Config(this, (player.getPlayer().getName()));
		if (PlayerData.get("Selected") == null) {
			PlayerData.createFile();
		} else {
		}

	}
}
