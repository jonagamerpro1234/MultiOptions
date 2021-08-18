package jss.multioptions.hook;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import jss.multioptions.MultiOptions;
import jss.multioptions.utils.EventUtils;
import jss.multioptions.utils.Logger;
import jss.multioptions.utils.Logger.Level;
import jss.multioptions.utils.Utils;
import jss.multioptions.utils.interfaces.LoaderHook;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
@SuppressWarnings("unused")
public class VaultHook implements LoaderHook {

	private MultiOptions plugin;
	private HooksManager hooksManager;
	private EventUtils eventUtils = new EventUtils(plugin);
	private Logger logger = new Logger(plugin);
	public Permission permission;
	public Chat chat;
	public Economy economy;

	public VaultHook(HooksManager hooksManager) {
		this.hooksManager = hooksManager;
	}

	public void load() {
		if(!Bukkit.getPluginManager().isPluginEnabled("Vault")) {
			logger.Log(Level.WARNING, "vault not enabled! - Disable Features...");
			return;
		}
		
		Utils.sendColorMessage(eventUtils.getConsoleSender(), Utils.getPrefix() + " " + "&aLoading vault features...");
		RegisteredServiceProvider<Economy> rspE = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
		RegisteredServiceProvider<Permission> rspP = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
		RegisteredServiceProvider<Chat> rspC = Bukkit.getServer().getServicesManager().getRegistration(Chat.class);
		
		if(rspE != null) {
			economy = rspE.getProvider();
		}
		if(rspP != null) {
			permission = rspP.getProvider();
		}
		if(rspC != null) {
			chat = rspC.getProvider();
		}
	}
	
	public Economy getEconomy() {
		return economy;
	}

	public Permission getPermissions() {
		return permission;
	}

	public Chat getChat() {
		return chat;
	}
}
