package old.jss.multioptions.event;

import jss.multioptions.MultiOptions;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
@SuppressWarnings("unused")
public class ProtectionLobbyListener implements Listener {
  private MultiOptions plugin;
  
  private CommandSender c = (CommandSender)Bukkit.getConsoleSender();
  
  public ProtectionLobbyListener(MultiOptions plugin) {
    this.plugin = plugin;
    //EventUtils.getManagerEvents().registerEvents(this, (Plugin)plugin);
  }
  
  @EventHandler(priority = EventPriority.NORMAL)
  public void respawnLobby(PlayerRespawnEvent e) {
   // FileConfiguration worlds = this.plugin.getWorldConfig();
    FileConfiguration config = this.plugin.getConfig();
    Player j = e.getPlayer();
   /* try {
      String path = "Settings.Respawn-Lobby";
      if (config.getString(path).equals("true"))
        if (worlds.contains("Lobby.Default.X")) {
          double x = Double.valueOf(worlds.getString("Lobby.Default.X")).doubleValue();
          double y = Double.valueOf(worlds.getString("Lobby.Default.Y")).doubleValue();
          double z = Double.valueOf(worlds.getString("Lobby.Default.Z")).doubleValue();
          float pitch = Float.valueOf(worlds.getString("Lobby.Default.Pitch")).floatValue();
          float yaw = Float.valueOf(worlds.getString("Lobby.Default.Yaw")).floatValue();
          World mundo = this.plugin.getServer().getWorld(worlds.getString("Lobby.Default.Name"));
          Location l = new Location(mundo, x, y, z, yaw, pitch);
          e.setRespawnLocation(l);
        } else {
          if (j.hasPermission("MultiOptions.Lobby.Notify.Error"))
            j.isOp(); 
          Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixMOPlayer()) + " " + (this.plugin.myLocale()).Error_Lobby_Main);
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + (this.plugin.myLocale()).Error_Lobby_Main);
        }  
    } catch (NullPointerException ex) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &aconfig.yml &9| &bSettings.Respawn-Lobby &9= &enull &d?");
    }*/ 
  }
  
  @EventHandler
  public void ProtectBuildLobby(BlockPlaceEvent e) {
   // FileConfiguration worlds = this.plugin.getWorldConfig();
    FileConfiguration config = this.plugin.getConfig();
    Player j = e.getPlayer();
    /*try {
      String hide = config.getString("Settings.Hiden-Protect-Msg-Lobby");
      String path = "Lobby.Protect";
      String name = j.getWorld().getName();
      String world = worlds.getString("Lobby.Default.Name");
      if (worlds.getString(path).equals("true"))
        if (world.contains(name)) {
          if (!j.hasPermission("MultiOptions.Protect.Lobby") || !j.isOp()) {
            TextComponent msg = new TextComponent();
            msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.AQUA).create()));
            if (hide.equals("false"))
              j.spigot().sendMessage((BaseComponent)msg); 
            e.setCancelled(true);
          } 
        } else {
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &aworlds.yml &9| &bLobby.Default.Name &9= &enull &d?");
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&aTip: &9first create the lobby so that this error does not appear anymore");
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&aCmd: &b/Mo &elobby &dsetdefaultlobby &9< true | false >");
        }  
    } catch (NullPointerException ex) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &aworlds.yml &9| &bLobby.Protect &9= &enull &d?");
    } */
  }
  
  @EventHandler
  public void ProtectBreakLobby(BlockBreakEvent e) {
    /*FileConfiguration worlds = this.plugin.getWorldConfig();
    FileConfiguration config = this.plugin.getConfig();
    Player j = e.getPlayer();
    try {
      String hide = config.getString("Settings.Hiden-Protect-Msg-Lobby");
      String path = "Lobby.Protect";
      String name = j.getWorld().getName();
      String world = worlds.getString("Lobby.Default.Name");
      if (worlds.getString(path).equals("true"))
        if (world.contains(name)) {
          if (!j.hasPermission("MultiOptions.Protect.Lobby") || !j.isOp()) {
            TextComponent msg = new TextComponent();
            msg.setText(Utils.color((this.plugin.myLocale()).No_Permisssion));
            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder((this.plugin.myLocale()).No_Permisssion_Label)).color(ChatColor.AQUA).create()));
            if (hide.equals("false"))
              j.spigot().sendMessage((BaseComponent)msg); 
            e.setCancelled(true);
          } 
        } else {
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &aworlds.yml &9| &bLobby.Default.Name &9= &enull &d?");
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&aTip: &9first create the lobby so that this error does not appear anymore");
          Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&aCmd: &b/Mo &elobby &dsetdefaultlobby &9< true | false >");
        }  
    } catch (NullPointerException ex) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &aworlds.yml &9| &bLobby.Protect &9= &enull &d?");
    } */
  }
}