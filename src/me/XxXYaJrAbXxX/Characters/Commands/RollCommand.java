package me.XxXYaJrAbXxX.Characters.Commands;

import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import me.XxXYaJrAbXxX.Characters.DataCollect.*;

public class RollCommand {
	private static GetData GetData;
	private Random Random = new Random();

	public RollCommand(GetData GetData) {
		RollCommand.GetData = GetData;
	}

	@SuppressWarnings("static-access")
	public void onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
			throws NullPointerException {
		try {
			String selected = GetData.get(sender.getName(), "selected");
			String characterRace = GetData.get(sender.getName(), "character" + selected + ".race");
			String characterClass = GetData.get(sender.getName(), "character" + selected + ".class");
			int raceAgility = (int) GetData.getDefaultConfig(characterRace + "_Agility");
			int classAgility = (int) GetData.getDefaultConfig(characterClass + "_Agility");
			int Agility = raceAgility + classAgility;
			int raceDexterity = (int) GetData.getDefaultConfig(characterRace + "_Dexterity");
			int classDexterity = (int) GetData.getDefaultConfig(characterClass + "_Dexterity");
			int Dexterity = raceDexterity + classDexterity;
			int raceStrength = (int) GetData.getDefaultConfig(characterRace + "_Strength");
			int classStrength = (int) GetData.getDefaultConfig(characterClass + "_Strength");
			int Strength = raceStrength + classStrength;
			int raceWisdom = (int) GetData.getDefaultConfig(characterRace + "_Wisdom");
			int classWisdom = (int) GetData.getDefaultConfig(characterClass + "_Wisdom");
			int Wisdom = raceWisdom + classWisdom;
			int range = (int) GetData.getDefaultConfig("Roll_Range");
			Player player = Bukkit.getServer().getPlayer(sender.getName());
			if (args[0].equalsIgnoreCase("agility")) {
				int roll = Random.nextInt(20);
				List<Entity> players = player.getNearbyEntities(range, range, range);
				for (int i = 0; i < players.size(); i++) {
					if ((players.get(i) instanceof Player)) {
						((Player) players.get(i)).sendMessage(
								ChatColor.DARK_AQUA + GetData.get(sender.getName(), "character" + selected + ".name")
										+ ChatColor.WHITE + " rolled a " + (roll + 1) + " making their agility roll "
										+ ((roll + 1) + Agility) + "!");
					}
				}
				sender.sendMessage(ChatColor.DARK_AQUA + "You " + ChatColor.WHITE + "rolled a " + (roll + 1)
						+ " making your agility roll " + ((roll + 1) + Agility) + "!");
			} else if (args[0].equalsIgnoreCase("dexterity")) {
				int roll = Random.nextInt(20);
				List<Entity> players = player.getNearbyEntities(range, range, range);
				for (int i = 0; i < players.size(); i++) {
					if ((players.get(i) instanceof Player)) {
						((Player) players.get(i)).sendMessage(
								ChatColor.DARK_AQUA + GetData.get(sender.getName(), "character" + selected + ".name")
										+ ChatColor.WHITE + " rolled a " + (roll + 1) + " making their dexterity roll "
										+ ((roll + 1) + Dexterity) + "!");
					}
				}
				sender.sendMessage(ChatColor.DARK_AQUA + "You " + ChatColor.WHITE + "rolled a " + (roll + 1)
						+ " making your dexterity roll " + ((roll + 1) + Dexterity) + "!");
			} else if (args[0].equalsIgnoreCase("strength")) {
				int roll = Random.nextInt(20);
				List<Entity> players = player.getNearbyEntities(range, range, range);
				for (int i = 0; i < players.size(); i++) {
					if ((players.get(i) instanceof Player)) {
						((Player) players.get(i)).sendMessage(
								ChatColor.DARK_AQUA + GetData.get(sender.getName(), "character" + selected + ".name")
										+ ChatColor.WHITE + " rolled a " + (roll + 1) + " making their strength roll "
										+ ((roll + 1) + Strength) + "!");
					}
				}
				sender.sendMessage(ChatColor.DARK_AQUA + "You " + ChatColor.WHITE + "rolled a " + (roll + 1)
						+ " making your strength roll " + ((roll + 1) + Strength) + "!");
			} else if (args[0].equalsIgnoreCase("wisdom")) {
				int roll = Random.nextInt(20);
				List<Entity> players = player.getNearbyEntities(range, range, range);
				for (int i = 0; i < players.size(); i++) {
					if ((players.get(i) instanceof Player)) {
						((Player) players.get(i)).sendMessage(
								ChatColor.DARK_AQUA + GetData.get(sender.getName(), "character" + selected + ".name")
										+ ChatColor.WHITE + " rolled a " + (roll + 1) + " making their wisdom roll "
										+ ((roll + 1) + Wisdom) + "!");
					}
				}
				sender.sendMessage(ChatColor.DARK_AQUA + "You " + ChatColor.WHITE + "rolled a " + (roll + 1)
						+ " making your wisdom roll " + ((roll + 1) + Wisdom) + "!");
			}
		} catch (Exception e) {
			int range = (int) GetData.getDefaultConfig("Roll_Range");
			String selected = GetData.get(sender.getName(), "selected");
			Player player = Bukkit.getPlayer(sender.getName());
			int roll = Random.nextInt(20);
			List<Entity> players = player.getNearbyEntities(range, range, range);
			if (GetData.get(player.getName(), "character" + selected + ".name").equalsIgnoreCase("")
					|| GetData.get(player.getName(), "character" + selected + ".race").equalsIgnoreCase("")
					|| GetData.get(player.getName(), "character" + selected + ".class").equalsIgnoreCase("")) {
				sender.sendMessage(ChatColor.RED + "You must set up your character sheet properly first!");
			} else {
				for (int i = 0; i < players.size(); i++) {
					if ((players.get(i) instanceof Player)) {
						((Player) players.get(i)).sendMessage(
								ChatColor.DARK_AQUA + GetData.get(sender.getName(), "character" + selected + ".name")
										+ ChatColor.WHITE + " rolled a " + (roll + 1) + "!");
					}
				}
				sender.sendMessage(ChatColor.DARK_AQUA + "You " + ChatColor.WHITE + "rolled a " + (roll + 1) + "!");
			}
		}
	}
}
