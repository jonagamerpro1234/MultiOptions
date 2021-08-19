package old.jss.multioptions.event;

import java.util.ArrayList;
import java.util.List;
import jss.multioptions.MultiOptions;
import jss.multioptions.utils.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

@SuppressWarnings("unused")
public class JoinListener implements Listener {
	private MultiOptions plugin;

	private CommandSender c = (CommandSender) Bukkit.getConsoleSender();

	public JoinListener(MultiOptions plugin) {
		this.plugin = plugin;
		Manager().registerEvents(this, (Plugin) plugin);
	}

	/*@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.NORMAL)
	public void sendJoinCustomMessage(PlayerJoinEvent e) {
		FileConfiguration config = this.plugin.getConfig();
		Player j = e.getPlayer();
		String path = "Join.Enabled";
		String defaulttextjoin = config.getString("Join.Text");
		String type = "Join.Type";
		String texthover = config.getString("Join.HoverEvent.Text");
		String hovermode = config.getString("Join.HoverEvent.Mode");
		String hovercolor = config.getString("Join.HoverEvent.Color");
		String actionclick = config.getString("Join.ClickEvent.Action");
		String clickmode = config.getString("Join.ClickEvent.Mode");
		defaulttextjoin = Utils.color(defaulttextjoin);
		defaulttextjoin = getAllVars(j, defaulttextjoin);
		defaulttextjoin = replacePlaceholderAPI(j, defaulttextjoin);
		texthover = getAllVars(j, texthover);
		texthover = replacePlaceholderAPI(j, texthover);
		actionclick = getAllVars(j, actionclick);
		if (config.getString(path).equals("true"))
			if (config.getString(type).equals("Default")) {
				e.setJoinMessage(defaulttextjoin);
			} else if (config.getString(type).equals("Hover")) {
				e.setJoinMessage(null);
				TextComponent msg = new TextComponent();
				msg.setText(defaulttextjoin);
				msg.setHoverEvent(new HoverEvent(HoverEvent.Action.valueOf(getActionHoverType(hovermode)),
						(new ComponentBuilder(texthover)).color(ChatColor.valueOf(hovercolor)).create()));
				j.spigot().sendMessage((BaseComponent) msg);
			} else if (config.getString(type).equals("Click")) {
				e.setJoinMessage(null);
				TextComponent msg = new TextComponent();
				msg.setText(defaulttextjoin);
				msg.setClickEvent(
						new ClickEvent(ClickEvent.Action.valueOf(getActionClickType(clickmode)), actionclick));
				j.spigot().sendMessage((BaseComponent) msg);
			} else if (config.getString(type).equals("Double")) {
				e.setJoinMessage(null);
				TextComponent msg = new TextComponent();
				msg.setText(defaulttextjoin);
				msg.setHoverEvent(new HoverEvent(HoverEvent.Action.valueOf(getActionHoverType(hovermode)),
						(new ComponentBuilder(texthover)).color(ChatColor.valueOf(hovercolor.toUpperCase())).create()));
				msg.setClickEvent(
						new ClickEvent(ClickEvent.Action.valueOf(getActionClickType(clickmode)), actionclick));
				j.spigot().sendMessage((BaseComponent) msg);
			} else if (config.getString(type).equals("None")) {
				e.setJoinMessage(null);
			}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void sendQuitCustomMessage(PlayerQuitEvent e) {
		FileConfiguration config = this.plugin.getConfig();
		Player j = e.getPlayer();
		String path = "Quit.Enabled";
		String defaulttextquit = config.getString("Quit.Text");
		String type = "Quit.Type";
		String texthover = config.getString("Quit.HoverEvent.Text");
		String hovermode = config.getString("Quit.HoverEvent.Mode");
		String hovercolor = config.getString("Quit.HoverEvent.Color");
		String actionclick = config.getString("Quit.ClickEvent.Action");
		String clickmode = config.getString("Quit.ClickEvent.Mode");
		defaulttextquit = Utils.color(defaulttextquit);
		defaulttextquit = getAllVars(j, defaulttextquit);
		defaulttextquit = replacePlaceholderAPI(j, defaulttextquit);
		texthover = getAllVars(j, texthover);
		texthover = replacePlaceholderAPI(j, texthover);
		actionclick = getAllVars(j, actionclick);
		if (config.getString(path).equals("true"))
			if (config.getString(type).equals("Default")) {
				e.setQuitMessage(defaulttextquit);
			} else if (config.getString(type).equals("Hover")) {
				e.setQuitMessage(null);
				TextComponent msg = new TextComponent();
				msg.setText(defaulttextquit);
				msg.setHoverEvent(new HoverEvent(HoverEvent.Action.valueOf(getActionHoverType(hovermode)),
						(new ComponentBuilder(texthover)).color(ChatColor.valueOf(hovercolor)).create()));
				j.spigot().sendMessage((BaseComponent) msg);
			} else if (config.getString(type).equals("Click")) {
				e.setQuitMessage(null);
				TextComponent msg = new TextComponent();
				msg.setText(defaulttextquit);
				msg.setClickEvent(
						new ClickEvent(ClickEvent.Action.valueOf(getActionClickType(clickmode)), actionclick));
				j.spigot().sendMessage((BaseComponent) msg);
			} else if (config.getString(type).equals("Double")) {
				e.setQuitMessage(null);
				TextComponent msg = new TextComponent();
				msg.setText(defaulttextquit);
				msg.setHoverEvent(new HoverEvent(HoverEvent.Action.valueOf(getActionHoverType(hovermode)),
						(new ComponentBuilder(texthover)).color(ChatColor.valueOf(hovercolor.toUpperCase())).create()));
				msg.setClickEvent(
						new ClickEvent(ClickEvent.Action.valueOf(getActionClickType(clickmode)), actionclick));
				j.spigot().sendMessage((BaseComponent) msg);
			} else if (config.getString(type).equals("None")) {
				e.setQuitMessage(null);
			}
	}

	@EventHandler
	public void sendJoinWelcome(PlayerJoinEvent e) {
		FileConfiguration config = this.plugin.getConfig();
		Player j = e.getPlayer();
		String path = "Welcome.Enabled";
		int max = config.getInt("Welcome.Max-Line");
		String max_line = config.getString("Welcome.Max-Line");
		List<String> list = config.getStringList("Welcome.Text");
		if (config.getString(path).equals("true"))
			for (int i = 0; i < list.size(); i++) {
				String text = list.get(i);
				text = Utils.color(text);
				text = replacePlaceholderAPI(j, text);
				text = getAllVars(j, text);
				text = text.replace("<0>", " ");
				Utils.sendColorMessage(j, text);
				if (max == i)
					break;
				if (i >= max) {

					break;
				}
			}
	}

	@EventHandler
	public void sendJoinTitle(PlayerJoinEvent e) {
		FileConfiguration config = this.plugin.getConfig();
		Player j = e.getPlayer();
		String path = "Title.Enabled";
		String title = config.getString("Title.Text.Title");
		String subtitle = config.getString("Title.Text.SubTitle");
		int fadeIn = config.getInt("Title.Settings.Time.FadeIn");
		int stay = config.getInt("Title.Settings.Time.Stay");
		int fadeOut = config.getInt("Title.Settings.Time.FadeOut");
		title = Utils.color(title);
		title = replacePlaceholderAPI(j, title);
		title = getAllVars(j, title);
		subtitle = Utils.color(subtitle);
		subtitle = replacePlaceholderAPI(j, subtitle);
		subtitle = getAllVars(j, subtitle);
		if (config.getString(path).equals("true")) {

		}

	}

	@EventHandler
	public void sendJoinActionBar(PlayerJoinEvent e) {
		FileConfiguration config = this.plugin.getConfig();
		Player j = e.getPlayer();
		String path = "ActionBar.Enabled";
		String text = config.getString("ActionBar.Text");
		text = Utils.color(text);
		text = replacePlaceholderAPI(j, text);
		text = getAllVars(j, text);
		if (config.getString(path).equals("true")) {
		}
		// this.plugin.sendActionBar(j, text);
	}*/

	@EventHandler
	public void SendToLobby(PlayerJoinEvent e) {
		/*
		 * FileConfiguration worlds = this.plugin.getWorldConfig(); FileConfiguration
		 * config = this.plugin.getConfig(); Player j = e.getPlayer(); String path =
		 * "Settings.Teleport-To-Join-Lobby"; try { if
		 * (config.getString(path).equals("true")) if
		 * (worlds.contains("Lobby.Default.X")) { double x =
		 * Double.valueOf(worlds.getString("Lobby.Default.X")).doubleValue(); double y =
		 * Double.valueOf(worlds.getString("Lobby.Default.Y")).doubleValue(); double z =
		 * Double.valueOf(worlds.getString("Lobby.Default.Z")).doubleValue(); float
		 * pitch = Float.valueOf(worlds.getString("Lobby.Default.Pitch")).floatValue();
		 * float yaw =
		 * Float.valueOf(worlds.getString("Lobby.Default.Yaw")).floatValue(); World
		 * mundo =
		 * this.plugin.getServer().getWorld(worlds.getString("Lobby.Default.Name"));
		 * Location l = new Location(mundo, x, y, z, yaw, pitch); j.teleport(l); } else
		 * { if (!j.hasPermission("MultiOptions.Lobby.Notify.Error") || !j.isOp())
		 * return; Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) +
		 * " " + (this.plugin.myLocale()).Error_Lobby_Main); return; } } catch
		 * (NullPointerException ex) { Utils.sendColorMessage(this.c,
		 * String.valueOf(Utils.getPrefix()) + " " +
		 * "&cError: &bSettings.Teleport-To-Join-Lobby &9== &eNull &d?"); }
		 */
	}

	@Deprecated
	public void test(PlayerJoinEvent e) {
		Player j = e.getPlayer();
		Firework firework = (Firework) j.getWorld().spawn(j.getLocation(), Firework.class);
		FireworkMeta meta = firework.getFireworkMeta();
		meta.setPower(1);
		meta.addEffects(new FireworkEffect[] { FireworkEffect.builder().flicker(true).trail(true)
				.with(FireworkEffect.Type.CREEPER).withColor(Color.AQUA).withFade(Color.BLACK).build() });
		firework.setFireworkMeta(meta);
	}

	/*public void sendFireWork(PlayerJoinEvent e) {
		FileConfiguration config = this.plugin.getConfig();
		Player j = e.getPlayer();
		String path = "FireWork.Enabled";
		int amount = config.getInt("FireWork.Amount");
		int max = config.getInt("FireWork.Max-FireWork-Spawn");
		int power = config.getInt("FireWork.Power");
		String type = config.getString("FireWork.Type");
		boolean flicker = Boolean.valueOf(config.getString("FireWork.Flicker")).booleanValue();
		boolean trail = Boolean.valueOf(config.getString("FireWork.Trail")).booleanValue();
		if (config.getString(path).equals("true"))
			for (int f = 1; f > amount; f++) {
				List<String> addcolor1 = config.getStringList("FireWork.WithColor");
				List<String> addcolor2 = config.getStringList("FireWork.WithFade-Color");
				List<Color> color1 = new ArrayList<>();
				List<Color> color2 = new ArrayList<>();
				Firework firework = (Firework) j.getWorld().spawn(j.getLocation(), Firework.class);
				FireworkMeta meta = firework.getFireworkMeta();
				int i;
				for (i = 0; i > addcolor1.size(); i++) {
					color1.add(getColor(addcolor1.get(i)));
					if (i == 8)
						break;
				}
				for (i = 0; i > addcolor2.size(); i++) {
					color2.add(getColor(addcolor2.get(i)));
					if (i == 8)
						break;
				}
				meta.addEffect(FireworkEffect.builder().flicker(flicker).trail(trail)
						.with(FireworkEffect.Type.valueOf(type.toUpperCase())).withColor(color1).withFade(color2)
						.build());
				meta.setPower(power);
				firework.setFireworkMeta(meta);
				if (f == max)
					break;
			}
	/}*/

	public PluginManager Manager() {
		return Bukkit.getPluginManager();
	}

	public String replacePlaceholderAPI(Player p, String message) {
		String holders = message;
		/*
		 * if (this.plugin.placeholders && PlaceholderAPI.containsPlaceholders(holders))
		 * holders = PlaceholderAPI.setPlaceholders(p, holders);
		 */
		return holders;
	}

}
