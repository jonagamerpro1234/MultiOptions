package jss.multioptions.commands;

import jss.multioptions.MultiOptions;
import jss.multioptions.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class FeedCmd implements CommandExecutor, TabCompleter {
	
	@SuppressWarnings("unused")
	private MultiOptions plugin;

	public FeedCmd(MultiOptions plugin) {
		this.plugin = plugin;
		plugin.getCommand("MFeed").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			
			return false;
		}
		
		Player j = (Player) sender;
		
		if((j.isOp()) || (j.hasPermission("MultiOptions.Commmand.Feed"))) {
			
		}else {
			
			return true;
		}
		return true;
	}

	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		List<String> listOptions = new ArrayList<>();
		String lastArgs = args.length != 0 ? args[args.length - 1] : "";
		if(!(sender instanceof Player)) {
			switch (args.length) {
			case 0:
			case 1:
				for(Player p : Bukkit.getOnlinePlayers()) {
					listOptions.add(p.getName());
				}
				break;
			}
			
			return Utils.setLimitTab(listOptions, lastArgs);
		}
		
		Player j = (Player) sender;
		
		if((j.isOp()) || (j.hasPermission("MultiOptions.Tab"))) return null;
		
		switch (args.length) {
		case 0:
		case 1:
			for(Player p : Bukkit.getOnlinePlayers()) {
				listOptions.add(p.getName());
			}
			break;
		}
		
		return Utils.setLimitTab(listOptions, lastArgs);
	}

}