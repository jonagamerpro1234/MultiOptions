package old.jss.multioptions.cmd;

import jss.multioptions.MultiOptions;
import jss.multioptions.utils.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
@SuppressWarnings("unused")
public class FlyCmd implements CommandExecutor {
  private MultiOptions plugin;
  
  private CommandSender c = (CommandSender)Bukkit.getConsoleSender();
  
  public FlyCmd(MultiOptions plugin) {
    this.plugin = plugin;
    plugin.getCommand("MFly").setExecutor(this);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player)) {
      //Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " " + (this.plugin.myLocale()).Error_Console);
      return false;
    } 
    Player j = (Player)sender;
    if (args.length == 0) {
      if (!j.hasPermission("MultiOptions.Commands.Fly") || !j.isOp()) {
        TextComponent msg = new TextComponent();
       // msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
       // msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
        j.spigot().sendMessage((BaseComponent)msg);
        return true;
      } 
      if (j.getAllowFlight()) {
        j.setAllowFlight(false);
        j.setFlying(false);
       // Utils.sendColorMessage(j, String.valueOf((this.plugin.myLocale()).Fly_Prefix) + " " + (this.plugin.myLocale()).Fly_Off);
      } else {
        j.setAllowFlight(true);
        //Utils.sendColorMessage(j, String.valueOf((this.plugin.myLocale()).Fly_Prefix) + " " + (this.plugin.myLocale()).Fly_On);
        return true;
      } 
      return true;
    } 
    if (args.length >= 1) {
      Player s = Bukkit.getPlayer(args[0]);
      if (!j.hasPermission("MultiOptions.Commands.Fly.Other") || !j.isOp()) {
        TextComponent msg = new TextComponent();
       // msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
       // msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.YELLOW).create()));
        j.spigot().sendMessage((BaseComponent)msg);
        return true;
      } 
      if (s == null) {
      //  Utils.sendColorMessage(j, String.valueOf((this.plugin.myLocale()).Fly_Prefix) + " " + (this.plugin.myLocale()).Error_Player);
        return true;
      } 
      if (s.getAllowFlight()) {
        s.setAllowFlight(false);
        s.setFlying(false);
       // Utils.sendColorMessage(j, String.valueOf((this.plugin.myLocale()).Fly_Prefix) + " " + (this.plugin.myLocale()).Fly_Off_other.replace("<name>", s.getName()));
        return true;
      } 
      s.setAllowFlight(true);
     // Utils.sendColorMessage(j, String.valueOf((this.plugin.myLocale()).Fly_Prefix) + " " + (this.plugin.myLocale()).Fly_On_other.replace("<name>", s.getName()));
      return true;
    } 
    return true;
  }
}