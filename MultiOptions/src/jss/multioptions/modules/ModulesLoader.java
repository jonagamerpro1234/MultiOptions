package jss.multioptions.modules;

import jss.multioptions.MultiOptions;
import jss.multioptions.commands.gamemode.GameModeModule;

public class ModulesLoader {
	
	private MultiOptions plugin;
	
	public ModulesLoader(MultiOptions plugin) {
		this.plugin = plugin;
	}	
	
	private void init(Module... modules) {
		for(Module module : modules) {
			module.load();
		}
	}
	
	public void getLoader() {
		init(
				new GameModeModule(plugin)
				
				);
	}
}
