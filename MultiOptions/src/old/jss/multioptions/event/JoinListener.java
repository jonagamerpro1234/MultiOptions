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
  
  private CommandSender c = (CommandSender)Bukkit.getConsoleSender();
  
  public JoinListener(MultiOptions plugin) {
    this.plugin = plugin;
    Manager().registerEvents(this, (Plugin)plugin);
  }
  
  @SuppressWarnings("deprecation")
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
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.valueOf(getActionHoverType(hovermode)), (new ComponentBuilder(texthover)).color(ChatColor.valueOf(hovercolor)).create()));
        j.spigot().sendMessage((BaseComponent)msg);
      } else if (config.getString(type).equals("Click")) {
        e.setJoinMessage(null);
        TextComponent msg = new TextComponent();
        msg.setText(defaulttextjoin);
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.valueOf(getActionClickType(clickmode)), actionclick));
        j.spigot().sendMessage((BaseComponent)msg);
      } else if (config.getString(type).equals("Double")) {
        e.setJoinMessage(null);
        TextComponent msg = new TextComponent();
        msg.setText(defaulttextjoin);
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.valueOf(getActionHoverType(hovermode)), (new ComponentBuilder(texthover)).color(ChatColor.valueOf(hovercolor.toUpperCase())).create()));
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.valueOf(getActionClickType(clickmode)), actionclick));
        j.spigot().sendMessage((BaseComponent)msg);
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
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.valueOf(getActionHoverType(hovermode)), (new ComponentBuilder(texthover)).color(ChatColor.valueOf(hovercolor)).create()));
        j.spigot().sendMessage((BaseComponent)msg);
      } else if (config.getString(type).equals("Click")) {
        e.setQuitMessage(null);
        TextComponent msg = new TextComponent();
        msg.setText(defaulttextquit);
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.valueOf(getActionClickType(clickmode)), actionclick));
        j.spigot().sendMessage((BaseComponent)msg);
      } else if (config.getString(type).equals("Double")) {
        e.setQuitMessage(null);
        TextComponent msg = new TextComponent();
        msg.setText(defaulttextquit);
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.valueOf(getActionHoverType(hovermode)), (new ComponentBuilder(texthover)).color(ChatColor.valueOf(hovercolor.toUpperCase())).create()));
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.valueOf(getActionClickType(clickmode)), actionclick));
        j.spigot().sendMessage((BaseComponent)msg);
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
    if (config.getString(path).equals("true")) {}
     // this.plugin.sendActionBar(j, text); 
  }
  
  @EventHandler
  public void sendJoinUpdate(PlayerJoinEvent e) {
    FileConfiguration config = this.plugin.getConfig();
    Player j = e.getPlayer();
    /*UpdateChecker update = new UpdateChecker(this.plugin);
    if (!j.hasPermission("MultiOptions.Update.Notify") || !j.isOp()) {
      if (config.getString("Config.Debug.Enabled").equals("true")) {
        TextComponent msg = new TextComponent();
        msg.setText(Utils.color("&c&l&n[!]&7 You do not have permission"));
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder("ask an admin or owner for help for more information")).color(ChatColor.YELLOW).create()));
        j.spigot().sendMessage((BaseComponent)msg);
      } 
      return;
    } 
    update.Update(j);*/
  }
  
  @EventHandler
  public void SendToLobby(PlayerJoinEvent e) {
    /*FileConfiguration worlds = this.plugin.getWorldConfig();
    FileConfiguration config = this.plugin.getConfig();
    Player j = e.getPlayer();
    String path = "Settings.Teleport-To-Join-Lobby";
    try {
      if (config.getString(path).equals("true"))
        if (worlds.contains("Lobby.Default.X")) {
          double x = Double.valueOf(worlds.getString("Lobby.Default.X")).doubleValue();
          double y = Double.valueOf(worlds.getString("Lobby.Default.Y")).doubleValue();
          double z = Double.valueOf(worlds.getString("Lobby.Default.Z")).doubleValue();
          float pitch = Float.valueOf(worlds.getString("Lobby.Default.Pitch")).floatValue();
          float yaw = Float.valueOf(worlds.getString("Lobby.Default.Yaw")).floatValue();
          World mundo = this.plugin.getServer().getWorld(worlds.getString("Lobby.Default.Name"));
          Location l = new Location(mundo, x, y, z, yaw, pitch);
          j.teleport(l);
        } else {
          if (!j.hasPermission("MultiOptions.Lobby.Notify.Error") || !j.isOp())
            return; 
          Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Error_Lobby_Main);
          return;
        }  
    } catch (NullPointerException ex) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " " + "&cError: &bSettings.Teleport-To-Join-Lobby &9== &eNull &d?");
    } */
  }
  
  @Deprecated
  public void test(PlayerJoinEvent e) {
    Player j = e.getPlayer();
    Firework firework = (Firework)j.getWorld().spawn(j.getLocation(), Firework.class);
    FireworkMeta meta = firework.getFireworkMeta();
    meta.setPower(1);
    meta.addEffects(new FireworkEffect[] { FireworkEffect.builder().flicker(true).trail(true).with(FireworkEffect.Type.CREEPER).withColor(Color.AQUA).withFade(Color.BLACK).build() });
    firework.setFireworkMeta(meta);
  }
  
  public void sendFireWork(PlayerJoinEvent e) {
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
        Firework firework = (Firework)j.getWorld().spawn(j.getLocation(), Firework.class);
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
        meta.addEffect(FireworkEffect.builder().flicker(flicker).trail(trail).with(FireworkEffect.Type.valueOf(type.toUpperCase())).withColor(color1).withFade(color2).build());
        meta.setPower(power);
        firework.setFireworkMeta(meta);
        if (f == max)
          break; 
      }  
  }
  
  public PluginManager Manager() {
    return Bukkit.getPluginManager();
  }
  
  public String replacePlaceholderAPI(Player p, String message) {
    String holders = message;
    /*if (this.plugin.placeholders && PlaceholderAPI.containsPlaceholders(holders))
      holders = PlaceholderAPI.setPlaceholders(p, holders); */
    return holders;
  }
  
  public String getType(String type) {
    String args = type;
    if (args.equalsIgnoreCase("BALL"))
      return "BALL"; 
    if (args.equalsIgnoreCase("BALL_LARGE"))
      return "BALL_LARGE"; 
    if (args.equalsIgnoreCase("BURST"))
      return "BURST"; 
    if (args.equalsIgnoreCase("CREEPER"))
      return "CREEPER"; 
    if (args.equalsIgnoreCase("STAR"))
      return "STAR"; 
    return null;
  }
  
  public Color getColor(String color) {
    String args = color;
    if (color != null)
      return Color.WHITE; 
    if (args.equalsIgnoreCase("AQUA"))
      return Color.AQUA; 
    if (args.equalsIgnoreCase("BLACK"))
      return Color.BLACK; 
    if (args.equalsIgnoreCase("BLUE"))
      return Color.BLUE; 
    if (args.equalsIgnoreCase("FUCHSIA"))
      return Color.FUCHSIA; 
    if (args.equalsIgnoreCase("GRAY"))
      return Color.GRAY; 
    if (args.equalsIgnoreCase("GREEN"))
      return Color.GREEN; 
    if (args.equalsIgnoreCase("LIME"))
      return Color.LIME; 
    if (args.equalsIgnoreCase("MAROON"))
      return Color.MAROON; 
    if (args.equalsIgnoreCase("NAVY"))
      return Color.NAVY; 
    if (args.equalsIgnoreCase("OLIVE"))
      return Color.OLIVE; 
    if (args.equalsIgnoreCase("ORANGE"))
      return Color.ORANGE; 
    if (args.equalsIgnoreCase("PURPLE"))
      return Color.PURPLE; 
    if (args.equalsIgnoreCase("RED"))
      return Color.RED; 
    if (args.equalsIgnoreCase("SILVER"))
      return Color.SILVER; 
    if (args.equalsIgnoreCase("TEAL"))
      return Color.TEAL; 
    if (args.equalsIgnoreCase("WHITE"))
      return Color.WHITE; 
    if (args.equalsIgnoreCase("YELLOW"))
      return Color.YELLOW; 
    return null;
  }
  
  public String getActionHoverType(String arg) {
    String temp = arg;
    if (temp.equalsIgnoreCase("text"))
      return "SHOW_TEXT"; 
    if (temp.equalsIgnoreCase("item"))
      return "SHOW_ITEM"; 
    if (temp.equalsIgnoreCase("entity"))
      return "SHOW_ENTITY"; 
    return null;
  }
  
  public String getActionClickType(String arg) {
    String temp = arg;
    if (temp.equalsIgnoreCase("url"))
      return "OPER_URL"; 
    if (temp.equalsIgnoreCase("cmd"))
      return "RUN_COMMAND"; 
    return null;
  }
  
  public String getAllVars(Player j, String msg) {
    /*int playersOnline = 0;
    try {
      if (Bukkit.class.getMethod("getOnlinePlayers", new Class[0]).getReturnType() == Collection.class) {
        playersOnline = ((Collection)Bukkit.class.getMethod("getOnlinePlayers", new Class[0]).invoke(null, new Object[0])).size();
      } else {
        playersOnline = ((Player[])Bukkit.class.getMethod("getOnlinePlayers", new Class[0]).invoke(null, new Object[0])).length;
      } 
    } catch (NoSuchMethodException noSuchMethodException) {
    
    } catch (InvocationTargetException invocationTargetException) {
    
    } catch (IllegalAccessException illegalAccessException) {}
    try {
      msg = msg.replace("<Name>", j.getName());
      msg = msg.replace("<Displayname>", j.getDisplayName());
      msg = msg.replace("<MaxPlayer>", this.plugin.getServer().getMaxPlayers());
      msg = msg.replace("<Online>", playersOnline);
      msg = msg.replace("<Server>", this.plugin.getServer().getServerName());
      msg = msg.replace("<Version>", this.plugin.getServer().getBukkitVersion());
      msg = msg.replace("<World>", j.getWorld().getName());
      msg = msg.replace("<Player_Ip>", j.getAddress().getHostName());
      msg = msg.replace("<name>", j.getName());
      msg = msg.replace("<displayname>", j.getDisplayName());
      msg = msg.replace("<maxPlayer>", this.plugin.getServer().getMaxPlayers());
      msg = msg.replace("<online>", playersOnline);
      msg = msg.replace("<server>", this.plugin.getServer().getServerName());
      msg = msg.replace("<version>", this.plugin.getServer().getBukkitVersion());
      msg = msg.replace("<world>", j.getWorld().getName());
    } catch (Exception exception) {}
   */ return msg;
  
  }
}
