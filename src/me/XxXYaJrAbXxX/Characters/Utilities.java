package me.XxXYaJrAbXxX.Characters;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import me.XxXYaJrAbXxX.Characters.Listeners.*;
import me.XxXYaJrAbXxX.Characters.FileWriter.Config;
import me.XxXYaJrAbXxX.Characters.FileWriter.SetData;
import me.XxXYaJrAbXxX.Characters.Commands.CharCommand;
import me.XxXYaJrAbXxX.Characters.Commands.NameCommand;
import me.XxXYaJrAbXxX.Characters.Commands.RollCommand;
import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;

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
		getServer().getPluginManager().registerEvents(new GetData(this), this);
		getServer().getPluginManager().registerEvents(new SetData(this), this);
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
}
