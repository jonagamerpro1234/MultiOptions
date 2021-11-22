package jss.multioptions.commands.gamemode;

import jss.multioptions.MultiOptions;
import jss.multioptions.config.Settings;
import jss.multioptions.modules.Module;

public class GameModeModule implements Module{
	
	private MultiOptions plugin;
	
	public GameModeModule(MultiOptions plugin) {
		this.plugin = plugin;
	}
	
	public void load() {
		if(!Settings.module_gamemode) {
			return;
		}
		
		this.registerCommands();
	}
	
	public void registerCommands() {
		new GamemodeCmd(plugin);
		/*new GmA(plugin);
		new GmC(plugin);
		new GmS(plugin);
		new GmSP(plugin);*/
	}
	
}
