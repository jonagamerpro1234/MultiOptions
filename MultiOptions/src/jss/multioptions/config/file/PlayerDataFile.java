package jss.multioptions.config.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import jss.multioptions.MultiOptions;
import jss.multioptions.config.FileManager;
import jss.multioptions.utils.EventUtils;
import jss.multioptions.utils.Utils;
import jss.multioptions.utils.interfaces.FileHelper;
import jss.multioptions.utils.interfaces.FolderHelper;

public class PlayerDataFile extends FileManager implements FileHelper, FolderHelper{
	
	private MultiOptions plugin;
	private EventUtils eventUtils = new EventUtils(plugin);
	private File file;
	private FileConfiguration config;
	private String path = "player.yml";
	private String pathfolde = "Data";

	public PlayerDataFile(MultiOptions plugin) {
		super(plugin);
		this.plugin = plugin;
	}

	public void create() {
		this.file = new File(getDataFolder() + File.separator + this.pathfolde, this.path);
		if(!this.file.exists()) {
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
		if(getConfig().getString("Settings.Debug").equals("true")) {
			Utils.sendColorMessage(eventUtils.getConsoleSender(), Utils.getPrefix() + "&5 <|| &c* &eDebug Mode: &bLoad "+ this.path);
		}else {
			Utils.sendColorMessage(eventUtils.getConsoleSender(), Utils.getPrefix() + "&5 <|| &c* &7Loading &d[&b"+this.path+"&d]");
		}
	}

	public FileConfiguration getConfig() {
		if(this.config == null) {
			reloadConfig();
		}
		return this.config;
	}

	public void saveConfig() {
		try {
			this.config.save(this.file);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public void reloadConfig() {
		if(this.config == null) {
			this.file = new File(getDataFolder(), this.path);
		}
		this.config = YamlConfiguration.loadConfiguration(this.file);
		Reader defaultConfigStream;
		try {
			defaultConfigStream = new InputStreamReader(getResources(this.path), "UTF8");
			BufferedReader in = new BufferedReader(defaultConfigStream);
			if(defaultConfigStream != null) {
				YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(in);
				config.setDefaults(defaultConfig);
			}
		}catch(UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
	}

	public String getPath() {
		return this.path;
	}

	public MultiOptions getPlugin() {
		return plugin;
	}

	public void saveDefaultConfig() {
		if(this.file == null) {
			this.file = new File(getDataFolder(), this.path);
		}
		if(!this.file.exists()) {
			saveResources(this.path, false);
		}
	}

	public void resetConfig() {
		if(this.file == null) {
			this.file = new File(getDataFolder(), this.path);
		}
		if(!this.file.exists()) {
			saveResources(this.path, true);
		}
	}
	
	public String getFolderPath() {
		return this.pathfolde;
	}

	public List<String> getJarFileList() throws IOException {
		return null;
	}
	
}
