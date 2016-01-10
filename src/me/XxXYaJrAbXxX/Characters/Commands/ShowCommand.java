package me.XxXYaJrAbXxX.Characters.Commands;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;

public class ShowCommand {
	
	private static GetData GetData;
	private static String playersname = "";
	Logger logger = Logger.getLogger("Minecraft");
	public ShowCommand(GetData GetData) {
		ShowCommand.GetData = GetData;
	}


	public static void Show(CommandSender sender, String[] args) {
		try {
			if (args[1] != null) {
				playersname = args[1];
			}
		} catch (Exception e) {
			playersname = sender.getName();
		}
		try {
			String selected = GetData.get(playersname, "selected");
			if (playersname == sender.getName()) {
				sender.sendMessage(ChatColor.GOLD + "Your selected character's name is: " + ChatColor.WHITE + (GetData.get(playersname, "character" + selected + ".name") == null ? "" : GetData.get(playersname, "character" + selected + ".name")));
				sender.sendMessage(ChatColor.GOLD + "Your selected character's gender is: " + ChatColor.WHITE + (GetData.get(playersname, "character" + selected + ".gender") == null ? "" : GetData.get(playersname, "character" + selected + ".gender")));
				sender.sendMessage(ChatColor.GOLD + "Your selected character's race is: " + ChatColor.WHITE + (GetData.get(playersname, "character" + selected + ".race") == null ? "" : GetData.get(playersname, "character" + selected + ".race")));
				sender.sendMessage(ChatColor.GOLD + "Your selected character's class is: " + ChatColor.WHITE + (GetData.get(playersname, "character" + selected + ".class") == null ? "" : GetData.get(playersname, "character" + selected + ".class")));
				String learntMagics = "";
				String[] magics = new String[10];
				magics[0] = GetData.get(playersname, "character" + selected + ".magic.pyromancy");
				magics[1] = GetData.get(playersname, "character" + selected + ".magic.aquamancy");
				magics[2] = GetData.get(playersname, "character" + selected + ".magic.aeromancy");
				magics[3] = GetData.get(playersname, "character" + selected + ".magic.geomancy");
				magics[4] = GetData.get(playersname, "character" + selected + ".magic.restoration");
				magics[5] = GetData.get(playersname, "character" + selected + ".magic.illusion");
				magics[6] = GetData.get(playersname, "character" + selected + ".magic.psionics");
				magics[7] = GetData.get(playersname, "character" + selected + ".magic.druidry");
				magics[8] = GetData.get(playersname, "character" + selected + ".magic.bloodmagic");
				magics[9] = GetData.get(playersname, "character" + selected + ".magic.necromancy");
				for (int i = 0; i < 10; i++) {
					try {
						if (magics[i].equals(null) || magics[i].equals("")) {
						} else {
						learntMagics += magics[i] + ", ";
						}
					} catch (Exception e) {
						
					}
				}
				learntMagics.trim();
				try {
					learntMagics = learntMagics.substring(0, learntMagics.length()-1);
				} catch (Exception e) {
					
				}
				sender.sendMessage(ChatColor.GOLD + "Your selected character's magic knowledge is: " + ChatColor.WHITE + ((learntMagics == null) || (learntMagics == "") ? "None" : learntMagics));
				sender.sendMessage(ChatColor.GOLD + "Your selected character's alignment is: " + ChatColor.WHITE + (GetData.get(playersname, "character" + selected + ".alignment") == null ? "" : GetData.get(playersname, "character" + selected + ".alignment")));
				sender.sendMessage(ChatColor.GOLD + "Your selected character's hometown is: " + ChatColor.WHITE + (GetData.get(playersname, "character" + selected + ".hometown") == null ? "" : GetData.get(playersname, "character" + selected + ".hometown")));
				sender.sendMessage(ChatColor.GOLD + "Your selected character is: " + ChatColor.WHITE + (GetData.get(playersname, "selected") == null ? "1" : GetData.get(playersname, "selected")));
			} else if (playersname != sender.getName()) {
				sender.sendMessage(ChatColor.GOLD + "Their selected character's name is: " + ChatColor.WHITE + (GetData.get(playersname, "character" + selected + ".name") == null ? "" : GetData.get(playersname, "character" + selected + ".name")));
				sender.sendMessage(ChatColor.GOLD + "Their selected character's gender is: " + ChatColor.WHITE + (GetData.get(playersname, "character" + selected + ".gender") == null ? "" : GetData.get(playersname, "character" + selected + ".gender")));
				sender.sendMessage(ChatColor.GOLD + "Their selected character's race is: " + ChatColor.WHITE + (GetData.get(playersname, "character" + selected + ".race") == null ? "" : GetData.get(playersname, "character" + selected + ".race")));
				sender.sendMessage(ChatColor.GOLD + "Their selected character's class is: " + ChatColor.WHITE + (GetData.get(playersname, "character" + selected + ".class") == null ? "" : GetData.get(playersname, "character" + selected + ".class")));
				String learntMagics = "";
				String[] magics = new String[10];
				magics[0] = GetData.get(playersname, "character" + selected + ".magic.pyromancy");
				magics[1] = GetData.get(playersname, "character" + selected + ".magic.aquamancy");
				magics[2] = GetData.get(playersname, "character" + selected + ".magic.aeromancy");
				magics[3] = GetData.get(playersname, "character" + selected + ".magic.geomancy");
				magics[4] = GetData.get(playersname, "character" + selected + ".magic.restoration");
				magics[5] = GetData.get(playersname, "character" + selected + ".magic.illusion");
				magics[6] = GetData.get(playersname, "character" + selected + ".magic.psionics");
				magics[7] = GetData.get(playersname, "character" + selected + ".magic.druidry");
				magics[8] = GetData.get(playersname, "character" + selected + ".magic.bloodmagic");
				magics[9] = GetData.get(playersname, "character" + selected + ".magic.necromancy");
				for (int i = 0; i < 10; i++) {
					try {
						if (magics[i].equals(null) || magics[i].equals("")) {
						} else {
						learntMagics += magics[i] + ", ";
						}
					} catch (Exception e) {
						
					}
				}
				learntMagics.trim();
				try {
					learntMagics = learntMagics.substring(0, learntMagics.length()-1);
				} catch (Exception e) {
					
				}
				sender.sendMessage(ChatColor.GOLD + "Their selected character's magic knowledge is: " + ChatColor.WHITE + ((learntMagics == null) || (learntMagics == "") ? "None" : learntMagics));
				sender.sendMessage(ChatColor.GOLD + "Their selected character's alignment is: " + ChatColor.WHITE + (GetData.get(playersname, "character" + selected + ".alignment") == null ? "" : GetData.get(playersname, "character" + selected + ".alignment")));
				sender.sendMessage(ChatColor.GOLD + "Their selected character's hometown is: " + ChatColor.WHITE + (GetData.get(playersname, "character" + selected + ".hometown") == null ? "" : GetData.get(playersname, "character" + selected + ".hometown")));
				sender.sendMessage(ChatColor.GOLD + "Their selected character is: " + ChatColor.WHITE + (GetData.get(playersname, "selected") == null ? "1" : GetData.get(playersname, "selected")));
			} 
		} catch (Exception e) {
		}
	}
}