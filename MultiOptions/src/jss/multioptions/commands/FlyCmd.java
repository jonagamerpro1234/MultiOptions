package jss.multioptions.commands;

import jss.multioptions.MultiOptions;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
@SuppressWarnings("unused")
public class FlyCmd implements CommandExecutor, TabCompleter{

	private MultiOptions plugin;

	public FlyCmd(MultiOptions plugin) {
		this.plugin = plugin;
		plugin.getCommand("MFly").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {

			return false;
		}

		return true;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			return null;
		}
		return null;
	}
}