package me.XxXYaJrAbXxX.Characters.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import me.XxXYaJrAbXxX.Characters.Utilities;
import me.XxXYaJrAbXxX.Characters.FileWriter.SetData;
import me.XxXYaJrAbXxX.Characters.DataCollect.GetData;

public class NameCommand implements Listener {
	@SuppressWarnings("unused")
	private static CharCommand CharCommand;
	private static SetData SetData;
	private static GetData GetData;

	public NameCommand(GetData GetData, SetData SetData) {
		NameCommand.GetData = GetData;
		NameCommand.SetData = SetData;
	}

	public static void Name(CommandSender sender, String[] args) {
		//try {
			String name = "";
			name = args[1];
			for (int i = 2; i < args.length; i++) {
				name += " " + args[i];
			}
			String selected = GetData.get(sender.getName(), "selected");
			SetData.Set(sender.getName(), "character" + selected + ".name" , name);
			sender.sendMessage(ChatColor.GREEN + "Character name saved!");
			//if (name.contains(" "))
		//	{
			//	String nickname = name.substring(0, name.indexOf(" "));
			//	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nick " + sender.getName() + " " + nickname);
			//}
			//else
			//{
		//		String nickname = name;
		//		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "nick " + sender.getName() + " " + nickname);
		//	}
		//} catch (Exception e) {
			
		//}
	}
}
//test
