package me.XxXYaJrAbXxX.Characters.FileWriter;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.XxXYaJrAbXxX.Characters.Utilities;
import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;
import me.XxXYaJrAbXxX.Characters.Commands.CharCommand;

public class SetData implements Listener {

	CharCommand CharCommand = new CharCommand(this);
	private static Utilities Utilities;
	private static GetData GetData;

	public SetData(Utilities Utilities, GetData GetData) {
		SetData.Utilities = Utilities;
		SetData.GetData = GetData;
	}

	public void Set(String player, String path, String value) {
		Config PlayerData = new Config(SetData.Utilities, player);
		PlayerData.set(path, value);
		PlayerData.save();
	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent player) {
		try {
			if (GetData.get(player.getPlayer().getName(), "pregenerated") == "false"
					|| GetData.get(player.getPlayer().getName(), "pregenerated") == null) {
				String playerString = player.getPlayer().getName();
				generatePlayerData(playerString);
			}
		} catch (Exception e) {
			String playerString = player.getPlayer().getName();
			generatePlayerData(playerString);
		}
	}

	public void generatePlayerData(String player) {
		Set(player, "selected", "1");
		for (int i = 1; i < 3; i++) {
			Set(player, "character" + i + ".name", "");
			Set(player, "character" + i + ".gender", "");
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

	public void regeneratePlayerData(String player) {
		try {
			String selected = GetData.get(player, "selected");
			Set(player, "character" + selected + ".name", "");
			Set(player, "character" + selected + ".gender", "");
			Set(player, "character" + selected + ".race", "");
			Set(player, "character" + selected + ".class", "");
			Set(player, "character" + selected + ".alignment", "");
			Set(player, "character" + selected + ".hometown", "");
			Set(player, "character" + selected + ".magic.pyromancy", "");
			Set(player, "character" + selected + ".magic.aquamancy", "");
			Set(player, "character" + selected + ".magic.aeromancy", "");
			Set(player, "character" + selected + ".magic.geomancy", "");
			Set(player, "character" + selected + ".magic.restoration", "");
			Set(player, "character" + selected + ".magic.illusion", "");
			Set(player, "character" + selected + ".magic.psionics", "");
			Set(player, "character" + selected + ".magic.druidry", "");
			Set(player, "character" + selected + ".magic.bloodmagic", "");
			Set(player, "character" + selected + ".magic.necromancy", "");
		} catch (Exception e) {
			generatePlayerData(player);
		}
	}
}
