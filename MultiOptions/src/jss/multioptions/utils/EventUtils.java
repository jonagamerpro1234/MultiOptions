package jss.multioptions.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import jss.multioptions.MultiOptions;

public class EventUtils {

	private MultiOptions plugin;

	public EventUtils(MultiOptions plugin) {
		this.plugin = plugin;
	}

	public  void addEventList(Listener listener) {
		getEventManager().registerEvents(listener, plugin);
	}
	
	public PluginManager getEventManager() {
		return Bukkit.getPluginManager();
	}
	
	public ConsoleCommandSender getConsoleSender() {
		return Bukkit.getConsoleSender();
	}
	
	@SuppressWarnings("unused")
	public boolean getClearChatAction(Object object, String type) {
		String tmp = type;
		if(tmp.equalsIgnoreCase("player")) {
			Player player = (Player) object;
			loopVoidChat(100);
			try {
				Utils.sendColorMessage("Test clear player");
			}catch(NullPointerException ex) {
				ex.printStackTrace();
			}
			return true;
		}else if(tmp.equalsIgnoreCase("server")) {
			loopVoidChat(100);
			try {
				Utils.sendColorMessage("Test clear server");
			}catch(NullPointerException ex) {
				ex.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
	public void loopVoidChat(int value) {
		try {
			for(int i = 0; i < value; i++) {
				Bukkit.broadcastMessage(" ");
				if(i == value) {
					break;
				}
			}	
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		}

	}
	
}
