package jss.multioptions.manager;

import jss.multioptions.MultiOptions;

public class EventManager {

	private MultiOptions plugin;
	
	public EventManager(MultiOptions plugin) {
		this.plugin = plugin;
	}

	public MultiOptions getPlugin() {
		return plugin;
	}
}
