package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.Utilities;
import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;
import me.XxXYaJrAbXxX.Characters.FileWriter.SetData;

public class CharCommand {
	
	private static Utilities Utilities;
	private static GetData GetData;
	private static SetData SetData;
	HelpCommand HelpCommand = new HelpCommand();
	NameCommand NameCommand = new NameCommand(GetData, SetData);
	ShowCommand ShowCommand = new ShowCommand(Utilities);
	
	public CharCommand(Utilities Utilities) {
		CharCommand.Utilities = Utilities;
	}
	
	public CharCommand(GetData GetData) {
		CharCommand.GetData = GetData;
	}
	
	public CharCommand(SetData SetData) {
		CharCommand.SetData = SetData;
	}

	public void onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
			if (args[0].equalsIgnoreCase("help")) {
				me.XxXYaJrAbXxX.Characters.Commands.HelpCommand.help(sender);
			} else if (args[0].equalsIgnoreCase("select")) {
				me.XxXYaJrAbXxX.Characters.Commands.SelectCommand.Select(sender, args);
			} else if (args[0].equalsIgnoreCase("name")) {
				me.XxXYaJrAbXxX.Characters.Commands.NameCommand.Name(sender, args);
			} else if (args[0].equalsIgnoreCase("show")) {
				me.XxXYaJrAbXxX.Characters.Commands.ShowCommand.Show(sender, args);
			} else {
				sender.sendMessage(ChatColor.RED + "Type '/char help' for a list of commands!");
			}		
	}
}