package old.jss.multioptions.cmd;

import java.util.ArrayList;
import java.util.List;
import old.jss.multioptions.MultiOptions;
import jss.multioptions.utils.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
@SuppressWarnings("unused")
public class GamemodeCmd implements CommandExecutor, TabCompleter {
  private MultiOptions plugin;
  
  private CommandSender c = (CommandSender)Bukkit.getConsoleSender();
  
  public GamemodeCmd(MultiOptions plugin) {
    this.plugin = plugin;
    plugin.getCommand("MGamemode").setExecutor(this);
    plugin.getCommand("MGamemode").setTabCompleter(this);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player)) {
     // Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " " + (this.plugin.myLocale()).Error_Console);
      return false;
    } 
    FileConfiguration config = this.plugin.getConfig();
    Player j = (Player)sender;
    String path = "Settings.Use-Default-Prefix";
    String prefix = config.getString("Settings.Prefix");
    if (args.length == 1) {
      if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
        if (!j.hasPermission("MultiOptions.Commands.Gamemode.Survival") || !j.isOp()) {
          TextComponent msg = new TextComponent();
         // msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
         // msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
          j.spigot().sendMessage((BaseComponent)msg);
          return true;
        } 
        j.setGameMode(GameMode.SURVIVAL);
        if (config.getString(path).equals("true")) {
        //  Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Set_Gamemode_Survival);
        } else if (config.getString(path).equals("false")) {
         // Utils.sendColorMessage(j, String.valueOf(prefix) + " " + (this.plugin.myLocale()).Set_Gamemode_Survival);
        } 
        return true;
      } 
      if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
        if (!j.hasPermission("MultiOptions.Commands.Gamemode.Creative") || !j.isOp()) {
          TextComponent msg = new TextComponent();
         // msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
         // msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
          j.spigot().sendMessage((BaseComponent)msg);
          return true;
        } 
        j.setGameMode(GameMode.CREATIVE);
        if (config.getString(path).equals("true")) {
          //Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Set_Gamemode_Creative);
        } else if (config.getString(path).equals("false")) {
        //  Utils.sendColorMessage(j, String.valueOf(prefix) + " " + (this.plugin.myLocale()).Set_Gamemode_Creative);
        } 
        return true;
      } 
      if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
        if (!j.hasPermission("MultiOptions.Commands.Gamemode.Adventure") || !j.isOp()) {
          TextComponent msg = new TextComponent();
          //msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
        //  msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
          j.spigot().sendMessage((BaseComponent)msg);
          return true;
        } 
        j.setGameMode(GameMode.ADVENTURE);
        if (config.getString(path).equals("true")) {
         // Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Set_Gamemode_Adventure);
        } else if (config.getString(path).equals("false")) {
         // Utils.sendColorMessage(j, String.valueOf(prefix) + " " + (this.plugin.myLocale()).Set_Gamemode_Adventure);
        } 
        return true;
      } 
      if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("sp")) {
        if (!j.hasPermission("MultiOptions.Commands.Gamemode.Spectator") || !j.isOp()) {
          TextComponent msg = new TextComponent();
          //msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
         // msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
          j.spigot().sendMessage((BaseComponent)msg);
          return true;
        } 
        if (this.plugin.useLegacyversions) {
         // Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Disable_Mode_Version);
          return true;
        } 
        if (!this.plugin.useLegacyversions) {
          j.setGameMode(GameMode.SPECTATOR);
          if (config.getString(path).equals("true")) {
           // Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Set_Gamemode_Spectator);
          } else if (config.getString(path).equals("false")) {
            //Utils.sendColorMessage(j, String.valueOf(prefix) + " " + (this.plugin.myLocale()).Set_Gamemode_Spectator);
          } 
          return true;
        } 
        return true;
      } 
    } else if (args.length == 2) {
      Player p = Bukkit.getPlayer(args[1]);
      if (p == null) {
        //Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Error_Player);
        return true;
      } 
      if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
        if (!j.hasPermission("MultiOptions.Commands.Gamemode.Other.Survival") || !j.isOp()) {
          TextComponent msg = new TextComponent();
         // msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
          //msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
          j.spigot().sendMessage((BaseComponent)msg);
          return true;
        } 
        p.setGameMode(GameMode.SURVIVAL);
        if (config.getString(path).equals("true")) {
          //Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Set_Gamemode_Survival_Other.replace("<name>", p.getName()));
        } else if (config.getString(path).equals("false")) {
          //Utils.sendColorMessage(j, String.valueOf(prefix) + " " + (this.plugin.myLocale()).Set_Gamemode_Survival_Other.replace("<name>", p.getName()));
        } 
        return true;
      } 
      if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
        if (!j.hasPermission("MultiOptions.Commands.Gamemode.Other.Creative") || !j.isOp()) {
          TextComponent msg = new TextComponent();
         // msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
         // msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
          j.spigot().sendMessage((BaseComponent)msg);
          return true;
        } 
        p.setGameMode(GameMode.CREATIVE);
        if (config.getString(path).equals("true")) {
         // Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Set_Gamemode_Creative_Other.replace("<name>", p.getName()));
        } else if (config.getString(path).equals("false")) {
          //Utils.sendColorMessage(j, String.valueOf(prefix) + " " + (this.plugin.myLocale()).Set_Gamemode_Creative_Other.replace("<name>", p.getName()));
        } 
        return true;
      } 
      if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
        if (!j.hasPermission("MultiOptions.Commands.Gamemode.Other.Adventure") || !j.isOp()) {
          TextComponent msg = new TextComponent();
          //msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
          //msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
          j.spigot().sendMessage((BaseComponent)msg);
          return true;
        } 
        p.setGameMode(GameMode.ADVENTURE);
        if (config.getString(path).equals("true")) {
          //Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Set_Gamemode_Adventure_Other.replace("<name>", p.getName()));
        } else if (config.getString(path).equals("false")) {
          //Utils.sendColorMessage(j, String.valueOf(prefix) + " " + (this.plugin.myLocale()).Set_Gamemode_Adventure_Other.replace("<name>", p.getName()));
        } 
        return true;
      } 
      if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("sp")) {
        if (!j.hasPermission("MultiOptions.Commands.Gamemode.Other.Spectator") || !j.isOp()) {
          TextComponent msg = new TextComponent();
         // msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
          //msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
          j.spigot().sendMessage((BaseComponent)msg);
          return true;
        } 
        if (this.plugin.useLegacyversions) {
         // Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Disable_Mode_Version);
          return true;
        } 
        if (!this.plugin.useLegacyversions) {
          p.setGameMode(GameMode.SPECTATOR);
          if (config.getString(path).equals("true")) {
          //  Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Set_Gamemode_Spectator_Other.replace("<name>", p.getName()));
          } else if (config.getString(path).equals("false")) {
           // Utils.sendColorMessage(j, String.valueOf(prefix) + " " + (this.plugin.myLocale()).Set_Gamemode_Spectator_Other.replace("<name>", p.getName()));
          } 
          return true;
        } 
        return true;
      } 
      return true;
    } 
   // Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Error_Gamemode_Args);
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
        if (!j.hasPermission("MultiOptions.Tab.Gamemode") || !j.isOp())
          return null; 
        options.add("survival");
        options.add("creative");
        options.add("adventure");
        options.add("spectator");
        break;
      case 2:
        if (!j.hasPermission("MultiOptions.Tab.Gamemode") || !j.isOp())
          return null; 
        for (Player p : Bukkit.getOnlinePlayers())
          options.add(p.getName()); 
        break;
    } 
    return Utils.setLimitTab(options, lastArgs);
  }
}


/* Location:              C:\Users\Alumno\Downloads\MultiOptions[3.0.0-8A].jar!\jss\multioptions\cmd\GamemodeCmd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */