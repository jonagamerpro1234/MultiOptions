package old.jss.multioptions.cmd;

import java.util.ArrayList;
import java.util.List;
import jss.multioptions.MultiOptions;
import jss.multioptions.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
@SuppressWarnings("unused")
public class MultiOptionsCmd implements CommandExecutor, TabCompleter {
  private MultiOptions plugin;
  
  private CommandSender c = (CommandSender)Bukkit.getConsoleSender();
  
  public MultiOptionsCmd(MultiOptions plugin) {
    this.plugin = plugin;
    plugin.getCommand("MultiOptions").setExecutor(this);
    plugin.getCommand("MultiOptions").setTabCompleter(this);
  }
  
  @SuppressWarnings("null")
public void sendHelp(Player player, String args0) {
    List<String> help1 = null;
    int i;
    List<String> help2 = null;
    int j;
    String str;
    switch ((str = args0).hashCode()) {
      case 49:
        if (!str.equals("1"))
          break; 
       // help1 = (this.plugin.myLocale()).page_1;
        for (i = 0; i < help1.size(); i++) {
          String text = help1.get(i);
          Utils.sendColorMessage(player, text);
        } 
        break;
      case 50:
        if (!str.equals("2"))
          break; 
        //help2 = (this.plugin.myLocale()).page_2;
        for (j = 0; j < help2.size(); j++) {
          String text = help2.get(j);
          Utils.sendColorMessage(player, text);
        } 
        break;
    } 
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/*    if (!(sender instanceof Player)) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + (this.plugin.myLocale()).Error_Console);
      return false;
    } 
    FileConfiguration config = this.plugin.getConfig();
    FileConfiguration wconfig = this.plugin.getWorldConfig();
    Player j = (Player)sender;
    if (args.length >= 1) {
      if (args[0].equalsIgnoreCase("info")) {
        Utils.sendColorMessage(j, "&5-=-=-=-=-=[&b" + this.plugin.name + "&5]=-=-=-=-=-=-");
        Utils.sendColorMessage(j, "&5> &3Name: &b" + this.plugin.name);
        Utils.sendColorMessage(j, "&5> &3Author: &6jonagamerpro1234");
        Utils.sendColorMessage(j, "&5> &3Version: &6" + this.plugin.version);
        Utils.sendColorMessage(j, "&5> &3Update: &a" + this.plugin.latestversion);
        Utils.sendColorMessage(j, "&5-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        return true;
      } 
      if (args[0].equalsIgnoreCase("dev")) {
        InvManager inv = new InvManager();
        inv.AdminInventory(j);
        Utils.sendColorMessage(j, "&aOpen 0");
        this.plugin.setDebug("inv", "&aAdmin panel &eId: 0");
        return true;
      } 
      if (args[0].equalsIgnoreCase("help")) {
        if (!j.hasPermission("MultiOptions.Commands.Help") || !j.isOp()) {
          TextComponent msg = new TextComponent();
          msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
          msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
          j.spigot().sendMessage((BaseComponent)msg);
          return true;
        } 
        if (args.length >= 2) {
          if (args[1].equalsIgnoreCase("1")) {
            Utils.sendColorMessage(j, "&5-=-=-=-=-=-=-=-=-=-=-=&6[&b" + this.plugin.name + "&6]&5=-=-=-=-=-=-=-=-=-=-=-");
            sendHelp(j, "1");
            Utils.sendColorMessage(j, Utils.getLine("&6[&d1&8/&b2&6]&5", "&5"));
            return true;
          } 
          if (args[1].equalsIgnoreCase("2")) {
            Utils.sendColorMessage(j, "&5-=-=-=-=-=-=-=-=-=-=-=&6[&b" + this.plugin.name + "&6]&5=-=-=-=-=-=-=-=-=-=-=-");
            sendHelp(j, "2");
            Utils.sendColorMessage(j, Utils.getLine("&6[&d2&8/&b2&6]&5", "&5"));
            return true;
          } 
          return true;
        } 
        Utils.sendColorMessage(j, "&5-=-=-=-=-=-=-=-=-=-=-=&6[&b" + this.plugin.name + "&6]&5=-=-=-=-=-=-=-=-=-=-=-");
        sendHelp(j, "1");
        Utils.sendColorMessage(j, Utils.getLine("&6[&d1&8/&b2&6]&5", "&5"));
        return true;
      } 
      if (args[0].equalsIgnoreCase("setLang")) {
        if (!j.hasPermission("MultiOptions.Commands.SetLang") || !j.isOp()) {
          TextComponent msg = new TextComponent();
          msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
          msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
          j.spigot().sendMessage((BaseComponent)msg);
          return true;
        } 
        config.set("Config.Lang", args[1]);
        this.plugin.saveConfig();
        this.plugin.reloadConfig();
        Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).ChangeLang);
        return true;
      } 
      if (args[0].equalsIgnoreCase("reload")) {
        if (!j.hasPermission("MultiOptions.Commands.Reload") || !j.isOp()) {
          TextComponent msg = new TextComponent();
          msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
          msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
          j.spigot().sendMessage((BaseComponent)msg);
          return true;
        } 
        if (args.length >= 2) {
          if (args[1].equalsIgnoreCase("config")) {
            if (!j.hasPermission("MultiOptions.Commands.Reload.Config") || !j.isOp()) {
              TextComponent msg = new TextComponent();
              msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
              msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
              j.spigot().sendMessage((BaseComponent)msg);
              return true;
            } 
            this.plugin.reloadConfig();
            Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Reload + " &b[&eConfig&b]");
            if (config.getString("Title.Enabled").equals("true")) {
              this.plugin.sendTitle(j, 20.0F, 40.0F, 20.0F, Utils.color((this.plugin.myLocale()).Reload), Utils.color("&eConfig"));
              return true;
            } 
            if (config.getString("ActionBar.Enabled").equals("true")) {
              this.plugin.sendActionBar(j, String.valueOf(Utils.color((this.plugin.myLocale()).Reload)) + " " + "&e Config");
              return true;
            } 
            return true;
          } 
          if (args[1].equalsIgnoreCase("All")) {
            if (!j.hasPermission("MultiOptions.Commands.Reload") || !j.isOp()) {
              TextComponent msg = new TextComponent();
              msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
              msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
              j.spigot().sendMessage((BaseComponent)msg);
              return true;
            } 
            this.plugin.reloadConfig();
            this.plugin.reloadWorldConfig();
            DefaultLang.loadConfig(this.plugin);
            Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Reload + " &b[&eAll&b]");
            if (config.getString("Title.Enabled").equals("true")) {
              this.plugin.sendTitle(j, 20.0F, 40.0F, 20.0F, Utils.color((this.plugin.myLocale()).Reload), Utils.color("&eAll"));
              return true;
            } 
            if (config.getString("ActionBar.Enabled").equals("true")) {
              this.plugin.sendActionBar(j, String.valueOf(Utils.color((this.plugin.myLocale()).Reload)) + " " + "&e All");
              return true;
            } 
            return true;
          } 
          if (args[1].equalsIgnoreCase("Worlds")) {
            if (!j.hasPermission("MultiOptions.Commands.Reload") || !j.isOp()) {
              TextComponent msg = new TextComponent();
              msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
              msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
              j.spigot().sendMessage((BaseComponent)msg);
              return true;
            } 
            this.plugin.reloadWorldConfig();
            Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Reload + " &b[&eWorlds&b]");
            if (config.getString("Title.Enabled").equals("true")) {
              this.plugin.sendTitle(j, 20.0F, 40.0F, 20.0F, Utils.color((this.plugin.myLocale()).Reload), Utils.color("&eWorlds"));
              return true;
            } 
            if (config.getString("ActionBar.Enabled").equals("true")) {
              this.plugin.sendActionBar(j, String.valueOf(Utils.color((this.plugin.myLocale()).Reload)) + " " + "&e Worlds");
              return true;
            } 
            return true;
          } 
          if (args[1].equalsIgnoreCase("Locale")) {
            if (!j.hasPermission("MultiOptions.Commands.Reload") || !j.isOp()) {
              TextComponent msg = new TextComponent();
              msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
              msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
              j.spigot().sendMessage((BaseComponent)msg);
              return true;
            } 
            DefaultLang.loadConfig(this.plugin);
            Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Reload + " &b[&eLocale Folder&b]");
            if (config.getString("Title.Enabled").equals("true")) {
              this.plugin.sendTitle(j, 20.0F, 40.0F, 20.0F, Utils.color((this.plugin.myLocale()).Reload), Utils.color("&eLocale"));
              return true;
            } 
            if (config.getString("ActionBar.Enabled").equals("true")) {
              this.plugin.sendActionBar(j, String.valueOf(Utils.color((this.plugin.myLocale()).Reload)) + " " + "&e Locale");
              return true;
            } 
            return true;
          } 
          Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Error_Args);
          return true;
        } 
        DefaultLang.loadConfig(this.plugin);
        this.plugin.reloadWorldConfig();
        this.plugin.reloadConfig();
        Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Reload);
        if (config.getString("Title.Enabled").equals("true")) {
          this.plugin.sendTitle(j, 20.0F, 40.0F, 20.0F, Utils.getPrefixMOPlayer(), Utils.color((this.plugin.myLocale()).Reload));
          return true;
        } 
        if (config.getString("ActionBar.Enabled").equals("true")) {
          this.plugin.sendActionBar(j, Utils.color((this.plugin.myLocale()).Reload));
          return true;
        } 
        return true;
      } 
      if (args[0].equalsIgnoreCase("lobby")) {
        if (!j.hasPermission("MultiOptions.Commands.Lobby") || !j.isOp()) {
          TextComponent msg = new TextComponent();
          msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
          msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
          j.spigot().sendMessage((BaseComponent)msg);
          return true;
        } 
        if (args.length >= 2) {
          if (args[1].equalsIgnoreCase("set")) {
            if (!j.hasPermission("MultiOptions.Commands.Lobby.Set") || !j.isOp()) {
              TextComponent msg = new TextComponent();
              msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
              msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
              j.spigot().sendMessage((BaseComponent)msg);
              return true;
            } 
            String name = args[2];
            LobbyManager lm = new LobbyManager(this.plugin);
            lm.setMultiLobby(j.getLocation(), name);
            Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + (this.plugin.myLocale()).Set_Lobby.replace("<lobby_name>", name));
            return true;
          } 
          if (args[1].equals("remove")) {
            if (!j.hasPermission("MultiOptions.Commands.Lobby.Remove") || !j.isOp()) {
              TextComponent msg = new TextComponent();
              msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
              msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
              j.spigot().sendMessage((BaseComponent)msg);
              return true;
            } 
            String name = args[2];
            LobbyManager lm = new LobbyManager(this.plugin);
            if (lm.getLobbyList().contains(name)) {
              lm.removeLobby(name);
              Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + (this.plugin.myLocale()).Remove_Lobby.replace("<lobby_name>", name));
              return true;
            } 
            return true;
          } 
          if (args[1].equalsIgnoreCase("setdefaultlobby")) {
            if (!j.hasPermission("MultiOptions.Commands.Lobby.Default.Set") || !j.isOp()) {
              TextComponent msg = new TextComponent();
              msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
              msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
              j.spigot().sendMessage((BaseComponent)msg);
              return true;
            } 
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            String path = "Lobby.Default.";
            Location l = j.getLocation();
            String world = j.getWorld().getName();
            double x = l.getX();
            double y = l.getY();
            double z = l.getZ();
            float yaw = l.getYaw();
            float pitch = l.getPitch();
            wconfig.set(String.valueOf(path) + "Name", world);
            wconfig.set(String.valueOf(path) + "X", Double.valueOf(nf.format(x)));
            wconfig.set(String.valueOf(path) + "Y", Double.valueOf(nf.format(y)));
            wconfig.set(String.valueOf(path) + "Z", Double.valueOf(nf.format(z)));
            wconfig.set(String.valueOf(path) + "Yaw", Float.valueOf(nf.format(yaw)));
            wconfig.set(String.valueOf(path) + "Pitch", Float.valueOf(nf.format(pitch)));
            try {
              String str;
              switch ((str = args[2]).hashCode()) {
                case 3569038:
                  if (!str.equals("true"))
                    break; 
                  wconfig.set("Lobby.Protect", Boolean.valueOf(true));
                  this.plugin.saveWorldConfig();
                  Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Set_Default_Lobby);
                  return true;
                case 97196323:
                  if (!str.equals("false"))
                    break; 
                  wconfig.set("Lobby.Protect", Boolean.valueOf(false));
                  this.plugin.saveWorldConfig();
                  Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Set_Default_Lobby);
                  return true;
              } 
              wconfig.set("Lobby.Protect", "false");
            } catch (ArrayIndexOutOfBoundsException ex) {
              Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + "&aTip&9: &7" + (this.plugin.myLocale()).tip_1);
              Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + "&aCmd: &b/Mo &elobby &dsetdefaultlobby &6< true | false >");
            } 
            this.plugin.saveWorldConfig();
            Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Set_Default_Lobby);
            return true;
          } 
          if (args[1].equalsIgnoreCase("removedefaultlobby")) {
            if (!j.hasPermission("MultiOptions.Commands.Lobby.Default.Remove") || !j.isOp()) {
              TextComponent msg = new TextComponent();
              msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
              msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
              j.spigot().sendMessage((BaseComponent)msg);
              return true;
            } 
            String path = "Lobby.Default.";
            wconfig.set(String.valueOf(path) + "Name", null);
            wconfig.set(String.valueOf(path) + "X", null);
            wconfig.set(String.valueOf(path) + "Y", null);
            wconfig.set(String.valueOf(path) + "Z", null);
            wconfig.set(String.valueOf(path) + "Yaw", null);
            wconfig.set(String.valueOf(path) + "Pitch", null);
            wconfig.set("Lobby.Protect", Boolean.valueOf(false));
            this.plugin.saveWorldConfig();
            this.plugin.reloadWorldConfig();
            Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Remove_Default_Lobby);
            return true;
          } 
          Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Error_Args);
          return true;
        } 
        Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Help_Lobby);
        return true;
      } 
      Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Error_Args);
      return true;
    } 
    Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Help_msg);*/
    return true;
  }
  
  public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return new ArrayList<>(); 
    List<String> options = new ArrayList<>();
    String lastArgs = (args.length != 0) ? args[args.length - 1] : "";
    Player j = (Player)sender;
    switch (args.length) {
      case 0:
      case 1:
        if (!j.hasPermission("MultiOptions.Tab") || !j.isOp())
          return null; 
        options.add("help");
        options.add("reload");
        options.add("info");
        options.add("chat");
        options.add("lobby");
        options.add("setLang");
        break;
      case 2:
        if (args[0].equalsIgnoreCase("lobby")) {
          if (!j.hasPermission("MultiOptions.Tab.Lobby") || !j.isOp())
            return null; 
          options.add("setdefaultlobby");
          options.add("removedefaultlobby");
          options.add("set");
          options.add("remove");
        } 
        if (args[0].equalsIgnoreCase("chat")) {
          if (!j.hasPermission("MultiOptions.Tab.Chat") || !j.isOp())
            return null; 
          options.add("add");
          options.add("clear");
        } 
        if (args[0].equalsIgnoreCase("Reload")) {
          if (!j.hasPermission("MultiOptions.Tab.Reload") || !j.isOp())
            return null; 
          options.add("Config");
          options.add("Worlds");
          options.add("All");
          options.add("Locale");
        } 
        if (args[0].equalsIgnoreCase("setLang")) {
          if (!j.hasPermission("MultiOptions.Tab.SetLang") || !j.isOp())
            return null; 
         // options.addAll(this.plugin.getAvailableLocales().keySet());
        } 
        break;
    } 
    return Utils.setLimitTab(options, lastArgs);
  }
}