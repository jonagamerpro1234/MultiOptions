package jss.multioptions.hook;

import org.bukkit.Bukkit;

import jss.multioptions.utils.EventUtils;
import jss.multioptions.utils.Logger;
import jss.multioptions.utils.Utils;
import jss.multioptions.utils.interfaces.LoaderHook;

public class PlaceholderApiHook implements LoaderHook{

	private HooksManager hooksManager;
	private boolean isEnabled;

	public PlaceholderApiHook(HooksManager hooksManager) {
		this.hooksManager = hooksManager;
	}

	public void load() {
		if(!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
			isEnabled = false;
			Logger.warning("placeholderapi - not enabled! - Disable Features");
			return;
		}
		
		Utils.sendColorMessage(EventUtils.getStaticConsoleSender(), Utils.getPrefix() + " " + "Loading placeholderapi...");
		
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}
	
	public HooksManager getHooksManager() {
		return hooksManager;
	}
	
}
