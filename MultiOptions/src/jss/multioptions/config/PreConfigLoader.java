package jss.multioptions.config;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import jss.multioptions.MultiOptions;

public class PreConfigLoader {
	
	private MultiOptions plugin;
	public PreConfigLoader(MultiOptions plugin) {
		this.plugin = plugin;
	}

	public void load() {
		try {
			Settings.boolean_update = getString("config", "Settings.Update").equals("true");
			//Settings.boolean_join = getString("config", "Join.Enabled").equals("true");
			//Settings.boolean_join_none = getString("config", "Join.Enabled").equals("none");
			//Settings.boolean_welcome = getString("config", "Welcome.Enabled").equals("true");
			//Settings.message_join = getString("config", "Join.Text");
			//Settings.message_welcomelist = getStringList("config", "Welcome.Text");
			Settings.message_helpcmd = getString("message","Help-Message");
			Settings.message_helplist1 = getStringList("message","Help-Messages.Page-1");
			Settings.message_helplist2 = getStringList("message","Help-Messages.Page-2");
			Settings.message_reload = getString("message","Reload");
			Settings.message_errorargs = getString("message","Error-Arguments");
			Settings.message_errorhelppage = getString("message","Error-Help-Page");
			Settings.message_errornumberformat = getString("message","Error-NumberFormat");
			Settings.message_nopermission = getString("message","No-Permission");
			Settings.message_nopermissionlabel = getString("message","No-Permission-Hover");
			Settings.module_gamemode = getBoolean("config", "Settings.Modules.Gamemode");
			
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public String getString(String type,String path) {
		FileConfiguration message_config = plugin.getMessagesFile().getConfig();
		FileConfiguration config = plugin.getConfigFile().getConfig();
		if(path == null) return null;
		
		if(type.equalsIgnoreCase("config")) {
			return config.getString(path);
		}
		if(type.equalsIgnoreCase("message")) {
			return message_config.getString(path);
		}
		return null;
	}
	
	public List<String> getStringList(String type, String path) {
		FileConfiguration message_config = plugin.getMessagesFile().getConfig();
		FileConfiguration config = plugin.getConfigFile().getConfig();
		if(path == null) return null;
		
		if(type.equalsIgnoreCase("config")) {
			return config.getStringList(path);
		}
		if(type.equalsIgnoreCase("message")) {
			return message_config.getStringList(path);
		}
		return null;
	}
	
	public boolean getBoolean(String type,String path) {
		FileConfiguration message_config = plugin.getMessagesFile().getConfig();
		FileConfiguration config = plugin.getConfigFile().getConfig();
		if(path == null) return true;
		
		if(type.equalsIgnoreCase("config")) {
			return config.getBoolean(path);
		}
		if(type.equalsIgnoreCase("message")) {
			return message_config.getBoolean(path);
		}
		return false;
	}

}
