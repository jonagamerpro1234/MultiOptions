package jss.multioptions.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

import org.bukkit.Bukkit;

import jss.multioptions.MultiOptions;
import jss.multioptions.utils.Logger.Level;
import jss.multioptions.utils.interfaces.UpdateHelper;

public class UpdateChecker implements UpdateHelper{

	private MultiOptions plugin;
	private Logger logger = new Logger(plugin);
	private int ID;
	
	public UpdateChecker(MultiOptions plugin, int iD) {
		this.plugin = plugin;
		ID = iD;
	}

	public void getUpdateVersion(Consumer<String> consumer) {
		Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
			try (InputStream inputStream = new URL(UpdateSettings.SPIGOT_UPDATE_API + this.ID).openStream();
					Scanner scanner = new Scanner(inputStream)) {
				if (scanner.hasNext()) {
					consumer.accept(scanner.next());
				}
			} catch (IOException e) {
				logger.Log(Level.INFO, " Could not check for updates:&c " + e.getMessage());
			}
		});
	}

}
