package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.XxXYaJrAbXxX.Characters.Utilities;
import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;
import me.XxXYaJrAbXxX.Characters.FileWriter.SetData;

public class CharCommand {
	@SuppressWarnings("unused")
	private static Utilities Utilities;
	private static GetData GetData;
	private static SetData SetData;

	HelpCommand HelpCommand = new HelpCommand();
	NameCommand NameCommand = new NameCommand(GetData, SetData);
	ShowCommand ShowCommand = new ShowCommand(GetData);
	SelectCommand SelectCommand = new SelectCommand(GetData, SetData);
	GenderCommand GenderCommand = new GenderCommand(GetData, SetData);
	RaceCommand RaceCommand = new RaceCommand(GetData, SetData);
	StatsCommand StatsCommand = new StatsCommand(GetData);
	ClassCommand ClassCommand = new ClassCommand(GetData, SetData);
	AlignmentCommand AlignmentCommand = new AlignmentCommand(GetData, SetData);
	MagicCommand MagicCommand = new MagicCommand(GetData, SetData);
	HometownCommand HometownCommand = new HometownCommand(GetData, SetData);
	ResetCommand ResetCommand = new ResetCommand(SetData);

	public CharCommand(GetData GetData) {
		CharCommand.GetData = GetData;
	}

	public CharCommand(SetData SetData) {
		CharCommand.SetData = SetData;
	}

	public CharCommand(Utilities Utilities) {
		CharCommand.Utilities = Utilities;
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
		} else if (args[0].equalsIgnoreCase("gender")) {
			me.XxXYaJrAbXxX.Characters.Commands.GenderCommand.Gender(sender, args);
		} else if (args[0].equalsIgnoreCase("race")) {
			me.XxXYaJrAbXxX.Characters.Commands.RaceCommand.Race(sender, args);
		} else if (args[0].equalsIgnoreCase("class")) {
			me.XxXYaJrAbXxX.Characters.Commands.ClassCommand.Class(sender, args);
		} else if (args[0].equalsIgnoreCase("alignment")) {
			me.XxXYaJrAbXxX.Characters.Commands.AlignmentCommand.Alignment(sender, args);
		} else if (args[0].equalsIgnoreCase("hometown")) {
			me.XxXYaJrAbXxX.Characters.Commands.HometownCommand.Hometown(sender, args);
		} else if (args[0].equalsIgnoreCase("magic")) {
			me.XxXYaJrAbXxX.Characters.Commands.MagicCommand.Magic(sender, args);
		} else if (args[0].equalsIgnoreCase("reset")) {
			me.XxXYaJrAbXxX.Characters.Commands.ResetCommand.Reset(sender, args);
		} else if (args[0].equalsIgnoreCase("stats")) {
			me.XxXYaJrAbXxX.Characters.Commands.StatsCommand.Stats(sender, args);
		} else {
			sender.sendMessage(ChatColor.RED + "Type '/char help' for a list of commands!");
		}
	}
}