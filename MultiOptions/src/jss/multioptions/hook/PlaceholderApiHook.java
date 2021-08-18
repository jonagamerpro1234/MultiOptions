package jss.multioptions.hook;

import org.bukkit.Bukkit;
import jss.multioptions.MultiOptions;
import jss.multioptions.utils.EventUtils;
import jss.multioptions.utils.Logger;
import jss.multioptions.utils.Logger.Level;
import jss.multioptions.utils.Utils;
import jss.multioptions.utils.interfaces.LoaderHook;

public class PlaceholderApiHook implements LoaderHook{

	private MultiOptions plugin;
	private HooksManager hooksManager;
	private EventUtils eventUtils = new EventUtils(plugin);
	private Logger logger = new Logger(plugin);
	private boolean isEnabled;

	public PlaceholderApiHook(HooksManager hooksManager) {
		this.hooksManager = hooksManager;
	}

	public void load() {
		if(!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
			isEnabled = false;
			logger.Log(Level.WARNING, "placeholderapi - not enabled! - Disable Features");
			return;
		}
		
		Utils.sendColorMessage(eventUtils.getConsoleSender(), Utils.getPrefix() + " " + "Loading placeholderapi...");
		
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}
	
	public HooksManager getHooksManager() {
		return hooksManager;
	}
	
}
