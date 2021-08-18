package jss.multioptions.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import jss.multioptions.ConfigFile;
import jss.multioptions.MessagesFile;
import jss.multioptions.MultiOptions;
import jss.multioptions.utils.EventUtils;
import jss.multioptions.utils.Settings;
import jss.multioptions.utils.Utils;

public class MultiOptionsCmd implements CommandExecutor {

	private MultiOptions plugin;
	private EventUtils eventUtils = new EventUtils(plugin);
	
	public MultiOptionsCmd(MultiOptions plugin, ConfigFile configFile) {
		this.plugin = plugin;
		plugin.getCommand("MultiOptions").setExecutor(this);
		if(configFile.getConfig().getString("Settings.Debug").equals("true")) {
			Utils.sendColorMessage(eventUtils.getConsoleSender(), Utils.getPrefix() + "&5 <|| &c* &eDebug Mode: &bLoad MultiOptionsCommand");
			Utils.sendColorMessage(eventUtils.getConsoleSender(), Utils.getPrefix() + "&5 <|| &c* &eDebug Mode:  &e&bLoad Sub Commands:");
			Utils.sendColorMessage(eventUtils.getConsoleSender(), Utils.getPrefix() + "&5 <|| &c* &eDebug Mode:    &b>> &aReload");
			Utils.sendColorMessage(eventUtils.getConsoleSender(), Utils.getPrefix() + "&5 <|| &c* &eDebug Mode:    &b>> &aHelp");
		}else {
			Utils.sendColorMessage(eventUtils.getConsoleSender(), Utils.getPrefix() + "&5 <|| &c* &7Loading &d[&bMultiOptionsCommand&d]");
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		ConfigFile configFile = plugin.getConfigFile();
		MessagesFile messagesFile = plugin.getMessagesFile();
		if(!(sender instanceof Player)) {
			if(args.length >= 1) {
				
				if(args[0].equalsIgnoreCase("reload")) {
					configFile.reloadConfig();
					messagesFile.reloadConfig();
					plugin.getPreConfigLoader().load();
					Utils.sendColorMessage(eventUtils.getConsoleSender(), Utils.getPrefix() + " " + Settings.message_reload);
				}else if(args[0].equalsIgnoreCase("help")) {
					
					if(args.length >= 2) {
						try {
							int pag = Integer.parseInt(args[1]);
							Utils.sendEmptyLine(eventUtils.getConsoleSender());
							Utils.sendColorMessage(eventUtils.getConsoleSender(), "&5-=-=-=-=-=-=-=-=-=-=-=&6[&b" + plugin.name + "&6]&5=-=-=-=-=-=-=-=-=-=-=-");
							getHelpMessage("server", null, pag);
							Utils.sendColorMessage(eventUtils.getConsoleSender(), "&5-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
						}catch(NumberFormatException e) {
							Utils.sendColorMessage(eventUtils.getConsoleSender(), "&5-=-=-=-=-=-=-=-=-=-=-=&6[&b" + plugin.name + "&6]&5=-=-=-=-=-=-=-=-=-=-=-");
							Utils.sendColorMessage(eventUtils.getConsoleSender(), Settings.message_errornumberformat);
							Utils.sendColorMessage(eventUtils.getConsoleSender(), "&5-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
						}

						return true;
					}
					Utils.sendEmptyLine(eventUtils.getConsoleSender());
					Utils.sendColorMessage(eventUtils.getConsoleSender(), "&5-=-=-=-=-=-=-=-=-=-=-=&6[&b" + plugin.name + "&6]&5=-=-=-=-=-=-=-=-=-=-=-");
					getHelpMessage("server", null, 1);
					Utils.sendColorMessage(eventUtils.getConsoleSender(), "&5-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				}else {
					Utils.sendColorMessage(eventUtils.getConsoleSender(), Utils.getPrefix() + " " + Settings.message_errorargs);
				}
				return true;
			}
			Utils.sendColorMessage(eventUtils.getConsoleSender(), Settings.message_helpcmd);
			return false;
		}
		Player j = (Player) sender;
		if((j.isOp()) || (j.hasPermission("MultiOptions.Admin"))) {
			if(args.length >= 1) {
				
				if(args[0].equalsIgnoreCase("reload")) {
					if((j.isOp()) || (j.hasPermission("MultiOptions.Admin.Reload"))) {
						configFile.reloadConfig();
						messagesFile.reloadConfig();
						plugin.getPreConfigLoader().load();
						Utils.sendColorMessage(j, Utils.getPrefixPlayer() + " " + Settings.message_reload);
					}else {
						Utils.sendHoverEvent(j, "text", Settings.message_nopermission, Settings.message_nopermissionlabel);
					}
					return true;
				}
				if(args[0].equalsIgnoreCase("help")) {
					if((j.isOp()) || (j.hasPermission("MultiOptions.Admin.Help"))) {
						if(args.length >= 2) {
							try {
								int pag = Integer.parseInt(args[1]);
								Utils.sendEmptyLine(j);
								Utils.sendColorMessage(j, "&5-=-=-=-=-=-=-=-=-=-=-=&6[&b" + plugin.name + "&6]&5=-=-=-=-=-=-=-=-=-=-=-");
								getHelpMessage("player", j, pag);
								Utils.sendColorMessage(j, "&5-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
							}catch(NumberFormatException e) {
								Utils.sendColorMessage(j, "&5-=-=-=-=-=-=-=-=-=-=-=&6[&b" + plugin.name + "&6]&5=-=-=-=-=-=-=-=-=-=-=-");
								Utils.sendColorMessage(j, Settings.message_errornumberformat);
								Utils.sendColorMessage(j, "&5-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
							}
							return true;
						}
						Utils.sendEmptyLine(j);
						Utils.sendColorMessage(j, "&5-=-=-=-=-=-=-=-=-=-=-=&6[&b" + plugin.name + "&6]&5=-=-=-=-=-=-=-=-=-=-=-");
						getHelpMessage("player", j, 1);
						Utils.sendColorMessage(j, "&5-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
					}else {
						Utils.sendHoverEvent(j, "text", Settings.message_nopermission, Settings.message_nopermissionlabel);
					}
					return true;
				}
				Utils.sendColorMessage(j, Utils.getPrefixPlayer() + " " + Settings.message_errorargs);
				return true;
			}
		}else {
			Utils.sendHoverEvent(j, "text", Settings.message_nopermission, Settings.message_nopermissionlabel);
			return true;
		}
		Utils.sendColorMessage(j, Settings.message_helpcmd);
		return true;
	}
	
	private void getHelpMessage(String key, Object obj, int pag) {
		int max = 2;
		if (pag > 0 && pag <= max) {
			switch (pag) {
			case 1:
				List<String> list = Settings.message_helplist1;
				for (int i = 0; i < list.size(); i++) {
					String t = (String) list.get(i);
					switch (key) {
					case "server":
						Utils.sendColorMessage(eventUtils.getConsoleSender(), t);
						break;
					case "player":
						Player p = (Player) obj;
						Utils.sendColorMessage(p, t);
						break;
					}
				}
				break;
			case 2:
				List<String> list1 = Settings.message_helplist2;
				for (int i = 0; i < list1.size(); i++) {
					String t2 = (String) list1.get(i);
					switch (key) {
					case "server":
						Utils.sendColorMessage(eventUtils.getConsoleSender(), t2);
						break;
					case "player":
						Player p = (Player) obj;
						Utils.sendColorMessage(p, t2);
						break;
					}
				}
				break;
			}
		} else {
			switch (key) {
			case "server":
				Utils.sendColorMessage(eventUtils.getConsoleSender(), Settings.message_errorhelppage);
				break;
			case "player":
				Player p = (Player) obj;
				Utils.sendColorMessage(p, Settings.message_errorhelppage);
				break;
			}
			return;
		}
	}
	
}
