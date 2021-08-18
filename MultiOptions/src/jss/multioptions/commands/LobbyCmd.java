package jss.multioptions.commands;

import jss.multioptions.MultiOptions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
@SuppressWarnings("unused")
public class LobbyCmd implements CommandExecutor {
	
	
	private MultiOptions plugin;
	private CommandSender c = (CommandSender) Bukkit.getConsoleSender();

	public LobbyCmd(MultiOptions plugin) {
		this.plugin = plugin;
		plugin.getCommand("Lobby").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		
		Player j = (Player) sender;
		if(args.length >= 1) {
			
			
			if((j.isOp()) || (j.hasPermission("MultiOptions.Lobby"))) {
				
			}
			
			return true;
		}
		return true;
	}
}