package jss.multioptions.utils;

import jss.multioptions.MultiOptions;

public class UpdateSettings {
	
	private static MultiOptions plugin = MultiOptions.getPlugin();
	public static String[] URL_PLUGIN = new String[] {"https://www.spigotmc.org/resources/multi-options-1-7-x-1-16-x.53655/","coming soon songoda","&cDebug Url plugin"};
	public static int[] ID = new int[] {53655,0};
	public static String NAME = plugin.name;
	public static String VERSION = plugin.version;
	public static String SPIGOT_UPDATE_API = "https://api.spigotmc.org/legacy/update.php?resource=";
}
