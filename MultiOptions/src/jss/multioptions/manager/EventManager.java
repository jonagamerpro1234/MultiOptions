package jss.multioptions.manager;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import jss.multioptions.MultiOptions;
import jss.multioptions.listener.JoinListener;

public class EventManager {

	private MultiOptions plugin;
	
	public EventManager(MultiOptions plugin) {
		this.plugin = plugin;
	}

	public void load() {
		initEvent(new JoinListener(this));
	}
	
	private void initEvent(Listener... listeners) {
		for(Listener listener : listeners) {
			Bukkit.getPluginManager().registerEvents(listener, plugin);
		}
	}
	
	public MultiOptions getPlugin() {
		return plugin;
	}
}
