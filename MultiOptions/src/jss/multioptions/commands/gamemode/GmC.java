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
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
@SuppressWarnings("unused")
public class GmC implements CommandExecutor, TabCompleter {

	private MultiOptions plugin;
	private EventUtils eventUtils = new EventUtils(plugin);

	public GmC(MultiOptions plugin) {
		this.plugin = plugin;
		plugin.getCommand("MGmS").setExecutor(this);
		plugin.getCommand("MGmS").setTabCompleter(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return true;
	}

	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		List<String> options = new ArrayList<>();
		String lastArgs = (args.length != 0) ? args[args.length - 1] : "";
		if (!(sender instanceof Player))
			return new ArrayList<>();

		Player j = (Player) sender;
		if (!j.hasPermission("MultiOptions.Tab.Gamemode") || !j.isOp()) {
			switch (args.length) {
			case 0:
			case 1:
				for (Player p : Bukkit.getOnlinePlayers())
					options.add(p.getName());
				break;
			}
		}

		return Utils.setLimitTab(options, lastArgs);
	}

}