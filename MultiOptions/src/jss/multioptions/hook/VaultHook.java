package jss.multioptions.hook;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import jss.multioptions.utils.EventUtils;
import jss.multioptions.utils.Logger;
import jss.multioptions.utils.Utils;
import jss.multioptions.utils.interfaces.LoaderHook;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class VaultHook implements LoaderHook {

	private HooksManager hooksManager;
	public static Permission permission;
	public static Chat chat;
	public static Economy economy;

	public VaultHook(HooksManager hooksManager) {
		this.hooksManager = hooksManager;
	}

	public void load() {
		if(!Bukkit.getPluginManager().isPluginEnabled("Vault")) {
			Logger.warning("vault not enabled! - Disable Features...");
			return;
		}
		
		Utils.sendColorMessage(EventUtils.getStaticConsoleSender(), Utils.getPrefix() + " " + "&aLoading vault features...");
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
	
	public static Economy getEconomy() {
		return economy;
	}

	public static Permission getPermissions() {
		return permission;
	}

	public static Chat getChat() {
		return chat;
	}
	
	public HooksManager getHooksManager() {
		return hooksManager;
	}
}
