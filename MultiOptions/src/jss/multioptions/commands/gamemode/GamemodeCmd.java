package jss.multioptions.commands.gamemode;

import java.util.ArrayList;
import java.util.List;
import jss.multioptions.MultiOptions;
import jss.multioptions.utils.EventUtils;
import jss.multioptions.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class GamemodeCmd implements CommandExecutor, TabCompleter {

	private MultiOptions plugin;

	public GamemodeCmd(MultiOptions plugin) {
		this.plugin = plugin;
		plugin.getCommand("MGamemode").setExecutor(this);
		plugin.getCommand("MGamemode").setTabCompleter(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {			
			if(args.length >= 1) {
				
				String mode = args[0];
				if(mode == null) {
					if(args.length >= 2) {
						Player p = Bukkit.getPlayerExact(args[1]);
						Utils.setGamemode(p, mode, "");
						return true;
					}
				}else{
					//
					return true;
				}
				
				//
				return true;
			}
			
			return false;
		}
		
		Player j = (Player)sender;
		if((j.isOp()) || (j.hasPermission("MultiOptions.Gamemode"))) {
			if(args.length >= 1) {
				
				String mode = args[0];
				if(mode == null) {
					if(args.length >= 2) {
						Player p = Bukkit.getPlayerExact(args[1]);
						Utils.setGamemode(p, mode, "");
						return true;
					}
				}else{
					return true;
				}
				
				return true;
			}
		}
		
		return true;
	}

	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		List<String> listoptions = new ArrayList<>();
		String lastArgs = (args.length != 0) ? args[args.length - 1] : "";
		if(!(sender instanceof Player)) {
			switch (args.length) {
			case 0:
			case 1:
				listoptions.add("survival");
				listoptions.add("creative");
				listoptions.add("adventure");
				listoptions.add("spectator");
				break;
			case 2:
				for(Player p : Bukkit.getOnlinePlayers()) {
					listoptions.add(p.getName());
				}
				break;
			}
			return Utils.setLimitTab(listoptions, lastArgs);
		}

		Player j = (Player) sender;
		if((j.isOp()) || (j.hasPermission("MulTiOptions.Tab.Gamemode"))) {
			switch (args.length) {
			case 0:
			case 1:
				listoptions.add("survival");
				listoptions.add("creative");
				listoptions.add("adventure");
				listoptions.add("spectator");
				break;
			case 2:
				for(Player p : Bukkit.getOnlinePlayers()) {
					listoptions.add(p.getName());
				}
				break;
			}
		}
		return Utils.setLimitTab(listoptions, lastArgs);
	}
}