package jss.multioptions.commands;

import java.util.ArrayList;
import java.util.List;
import jss.multioptions.MultiOptions;
import jss.multioptions.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
@SuppressWarnings("unused")
public class GmA implements CommandExecutor, TabCompleter {

	private MultiOptions plugin;

	public GmA(MultiOptions plugin) {
		this.plugin = plugin;
		plugin.getCommand("MGmC").setExecutor(this);
		plugin.getCommand("MGmC").setTabCompleter(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {

			return false;
		}

		return true;
	}

	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player))
			return new ArrayList<>();
		List<String> options = new ArrayList<>();
		String lastArgs = (args.length != 0) ? args[args.length - 1] : "";
		Player j = (Player) sender;
		switch (args.length) {
		case 0:
		case 1:
			if (!j.hasPermission("MultiOptions.Tab.Gamemode") || !j.isOp())
				return null;
			for (Player p : Bukkit.getOnlinePlayers())
				options.add(p.getName());
			break;
		}
		return Utils.setLimitTab(options, lastArgs);
	}
}
