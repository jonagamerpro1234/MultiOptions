package jss.multioptions;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import jss.multioptions.hook.HooksManager;
import jss.multioptions.utils.FileManager;
import jss.multioptions.utils.Logger;
import jss.multioptions.utils.Logger.Level;
import jss.multioptions.utils.UpdateChecker;
import jss.multioptions.utils.UpdateSettings;
import jss.multioptions.utils.Utils;

public class MultiOptions extends JavaPlugin {

	private PluginDescriptionFile jss = getDescription();
	
	private static MultiOptions plugin;
	
	private PreConfigLoader preConfigLoader = new PreConfigLoader(this);
	
	private FileManager fileManager = new FileManager(this);
	
	private HooksManager hooksManager = new HooksManager(this);
	
	private ConfigFile configFile = new ConfigFile(this);
	
	private MessagesFile messagesFile = new MessagesFile(this);
	
	private WorldDataFile worldDataFile = new WorldDataFile(this);
	
	public String name = this.jss.getName();
	
	public String version = this.jss.getVersion();
	
	public boolean placeholder = false;
	
	public boolean ess = false;
	
	public boolean vault = false;
	
	public Metrics metrics;
	
	public Logger logger = new Logger(this);
	
	public void onEnable() {
		Utils.setEnabled(version);
		plugin = this;
		try {
			metrics = new Metrics(this, 4583);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		plugin.logger.Log(Level.INFO, "&bLoading Config File...");
		configFile.create();
		plugin.logger.Log(Level.INFO, "&bLoading PreConfig...");
		preConfigLoader.load();
		plugin.logger.Log(Level.INFO, "&bLoading Data Folder...");
		fileManager.createVoidFolder("Data");
		plugin.logger.Log(Level.INFO, "&bLoading Gui Folder...");
		fileManager.createVoidFolder("Gui");
		plugin.logger.Log(Level.INFO, "&bLoading Messages File...");
		messagesFile.create();
		plugin.logger.Log(Level.INFO, "&bLoading Worlds File...");
		worldDataFile.create();
		plugin.logger.Log(Level.INFO, "&bLoading hooks...");
		this.hooksManager.load();
		new UpdateChecker(this, UpdateSettings.ID[0]).getUpdateVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.Log(Level.SUCCESS, "&a" + this.name + " is up to date!");
            } else {
                logger.Log(Level.OUTLINE, "&5<||" + Utils.getLine("&5"));
                logger.Log(Level.WARNING, "&5<||" + "&b" + this.name + "is outdated!");
                logger.Log(Level.WARNING, "&5<||" + "&bNewest version: &a" + version);
                logger.Log(Level.WARNING, "&5<||" + "&bYour version: &d" + UpdateSettings.VERSION);
                logger.Log(Level.WARNING, "&5<||" + "&bUpdate Here on Spigot: &e" + UpdateSettings.URL_PLUGIN[0]);
                logger.Log(Level.OUTLINE, "&5<||" + Utils.getLine("&5"));
            }
		});
	}
	
	public void onDisable() {
		Utils.setDisabled(version);
		placeholder = false;
		vault = false;
		ess = false;
		metrics = null;
	}
	
	public ConfigFile getConfigFile() {
		return configFile;
	}

	public MessagesFile getMessagesFile() {
		return messagesFile;
	}
	
	public WorldDataFile getWorldDataFile() {
		return worldDataFile;
	}

	public PreConfigLoader getPreConfigLoader() {
		return preConfigLoader;
	}
	
	public static MultiOptions getPlugin() {
		return plugin;
	}
}
