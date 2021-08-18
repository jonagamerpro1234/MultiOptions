package jss.multioptions.hook;

import jss.multioptions.MultiOptions;
import jss.multioptions.utils.interfaces.LoaderHook;

public class HooksManager {
	
	private MultiOptions plugin;
	private PlaceholderApiHook placeholderApi;
	
	public HooksManager(MultiOptions plugin) {
		this.plugin = plugin;
	}

	public void load() {
		initLoaderHook(new PlaceholderApiHook(this));
	}
	
	private void initLoaderHook(LoaderHook... hooks) {
		for(LoaderHook hook : hooks) {
			hook.load();
		}
	}
	
	public PlaceholderApiHook getPlaceholderApi() {
		return placeholderApi;
	}
	
	public MultiOptions getPlugin() {
		return plugin;
	}
	
}
