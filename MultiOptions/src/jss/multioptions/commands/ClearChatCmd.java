package jss.multioptions.commands;

import jss.multioptions.MultiOptions;
import jss.multioptions.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ClearChatCmd implements CommandExecutor {
	
	private MultiOptions plugin;

	public ClearChatCmd(MultiOptions plugin) {
		this.plugin = plugin;
		plugin.getCommand("MClearChat").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {

			return false;
		}
		Player j = (Player) sender;
		FileConfiguration config = this.plugin.getConfig();
		String path = "Settings.Use-Default-Prefix";
		if (args.length == 0) {
			if (!j.hasPermission("MultiOptions.Commands.ClearChat") || !j.isOp())
				return true;
			for (int i = 0; i < 100; i++)
				Bukkit.broadcastMessage(" ");
			String prefix = config.getString("Settings.Prefix");
			String msg = null ;
			msg = Utils.getVar(j, msg);
			if (config.getString(path).equals("true")) {
				Utils.sendColorMessage(String.valueOf(Utils.getPrefixPlayer()) + " " + msg);
			} else if (config.getString(path).equals("false")) {
				Utils.sendColorMessage(String.valueOf(prefix) + " " + msg);
			}
			return true;
		}
		return true;
	}
	
}