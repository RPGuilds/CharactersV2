package me.XxXYaJrAbXxX.Characters.FileWriter;

import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.XxXYaJrAbXxX.Characters.Utilities;

public class SetData implements Listener {
	private final Utilities utilities;
	
	public SetData(Utilities utilities) {
		this.utilities = utilities;
	}
	
	public void Set(CommandSender sender, String parm1, String parm2, String value) {
		Config PlayerData = new Config(this.utilities, sender.getName());
		int Selected = PlayerData.getInt("Selected");
		PlayerData.set("character" + Selected + parm1 + parm2, value);
		PlayerData.save();
		}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent player) {
		Config PlayerData = new Config(this.utilities, (player.getPlayer().getName()));
		if (PlayerData.get("Selected") == null) {
			PlayerData.createFile();
		} else {
		}

	}

}
