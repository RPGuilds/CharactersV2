package me.XxXYaJrAbXxX.Characters.FileWriter;

import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.XxXYaJrAbXxX.Characters.Utilities;
import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;
import me.XxXYaJrAbXxX.Characters.Commands.CharCommand;

public class SetData implements Listener {
	
	@SuppressWarnings("unused")
	CharCommand CharCommand = new CharCommand(this);
	private static Logger logger = Logger.getLogger("Minecraft");
	private static Utilities Utilities;
	private static GetData GetData;
	public SetData(Utilities Utilities) {
		SetData.Utilities = Utilities;
	}

	
	public void Set(String player, String path, String value) {
		Config PlayerData = new Config(SetData.Utilities, player);
		PlayerData.set(path, value);
		PlayerData.save();
	}
		
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent player) {
		try {
			if (GetData.get(player.getPlayer().getName(), "pregenerated") == "false" ||
					GetData.get(player.getPlayer().getName(), "pregenerated") == null) {
				String playerString = player.getPlayer().getName();
				generatePlayerData(playerString);
			}
		} catch(Exception e) {
			String playerString = player.getPlayer().getName();
			generatePlayerData(playerString);
		}
	}
	public void generatePlayerData(String player) {
		Set(player, "selected", "1");
		for (int i = 1; i < 3; i++) {
			Set(player, "character" + i + ".name", "");
			Set(player, "character" + i + ".race", "");
			Set(player, "character" + i + ".class", "");
			Set(player, "character" + i + ".alignment", "");
			Set(player, "character" + i + ".hometown", "");
			Set(player, "character" + i + ".magic.pyromancy", "");
			Set(player, "character" + i + ".magic.aquamancy", "");
			Set(player, "character" + i + ".magic.aeromancy", "");
			Set(player, "character" + i + ".magic.geomancy", "");
			Set(player, "character" + i + ".magic.restoration", "");
			Set(player, "character" + i + ".magic.illusion", "");
			Set(player, "character" + i + ".magic.psionics", "");
			Set(player, "character" + i + ".magic.druidry", "");
			Set(player, "character" + i + ".magic.bloodmagic", "");
			Set(player, "character" + i + ".magic.necromancy", "");
		}
		Set(player, "pregenerated", "true");
	}

}
