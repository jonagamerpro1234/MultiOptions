package jss.multioptions.listener;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import jss.multioptions.MultiOptions;
import jss.multioptions.config.Settings;
import jss.multioptions.manager.EventManager;
import jss.multioptions.utils.EventUtils;
import jss.multioptions.utils.Utils;

public class JoinListener implements Listener{

	private EventManager eventManager;
	private MultiOptions plugin = eventManager.getPlugin();
	private EventUtils eventUtils = new EventUtils(plugin);
	
	public JoinListener(EventManager eventManager) {
		this.eventManager = eventManager;
		Utils.sendColorMessage(eventUtils.getConsoleSender(), "&bTest eventUtils: AddEventList: onJoin");
	}
	
	public void onUpdate() {
		if(Settings.boolean_update) {
			
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player j = e.getPlayer();
		
		if(Settings.boolean_welcome) {
			List<String> list = Settings.message_welcomelist;
			for(int i = 0; i < list.size(); i++) {
				String text = (String) list.get(i);
				
				text = Utils.hexcolor(text);
				text = Utils.getVar(j, text);
				
				Utils.sendColorMessage(j, text);
				if(i == list.size()) {
					break;
				}
			}
		}
		
		if(Settings.boolean_join) {
			String join = Settings.message_join;
			join = Utils.hexcolor(join); 
			join = Utils.getVar(j, join);
			e.setJoinMessage(join);
		}else if(Settings.boolean_join_none) {
			e.setJoinMessage(null);
		}
	}
		
	public void onQuit(PlayerQuitEvent e) {
		Player j = e.getPlayer();
		if(Settings.boolean_quit) {
			String quit = Settings.message_quit;
			quit = Utils.hexcolor(quit);
			quit = Utils.getVar(j, quit);
			e.setQuitMessage(quit);
		}else if(Settings.boolean_quit_none) {
			e.setQuitMessage(null);
		}
	}
	
	
}
