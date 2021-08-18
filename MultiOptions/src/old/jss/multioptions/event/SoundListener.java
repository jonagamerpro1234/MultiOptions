package old.jss.multioptions.event;

import org.bukkit.event.Listener;

public class SoundListener implements Listener {
/*  private MultiOptions plugin;
  
  private CommandSender c = (CommandSender)Bukkit.getConsoleSender();
  
  public SoundListener(MultiOptions plugin) {
    this.plugin = plugin;
    EventUtils.getManagerEvents().registerEvents(this, (Plugin)plugin);
  }
  
  @EventHandler
  public void sendSoundJoin(PlayerJoinEvent e) {
    Player j = e.getPlayer();
    FileConfiguration config = this.plugin.getConfig();
    String path = "Sounds.Enabled";
    String slipsound = config.getString("Sounds.Join.Sound");
    String useperm = config.getString("Sounds.Join.Use-Permission");
    String perm = config.getString("Sounds.Join.Permission");
    String sap = config.getString("Sounds.Send-All-Players");
    String je = config.getString("Sounds.Join.Enabled");
    String[] split = slipsound.split(";");
    try {
      if (config.getString(path).equals("true") && 
        je.equals("true"))
        if (useperm.equals("true")) {
          if (!j.hasPermission(perm) || !j.isOp()) {
            Sound sound = Sound.valueOf(split[0]);
            int vol = Integer.valueOf(split[1]).intValue();
            float pitch = Float.valueOf(split[2]).floatValue();
            if (sap.equals("true")) {
              for (Player p : Bukkit.getOnlinePlayers()) {
                Location l = p.getLocation();
                p.playSound(l, sound, vol, pitch);
              } 
            } else if (sap.equals("false")) {
              Location l = j.getLocation();
              j.playSound(l, sound, vol, pitch);
            } 
          } 
        } else if (useperm.equals("false")) {
          Sound sound = Sound.valueOf(split[0]);
          int vol = Integer.valueOf(split[1]).intValue();
          float pitch = Float.valueOf(split[2]).floatValue();
          if (sap.equals("true")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
              Location l = p.getLocation();
              p.playSound(l, sound, vol, pitch);
            } 
          } else if (sap.equals("false")) {
            Location l = j.getLocation();
            j.playSound(l, sound, vol, pitch);
          } 
        }  
    } catch (IllegalArgumentException ex) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &b Sounds.Enabled &9== &eNull &d?");
    } catch (NullPointerException ex) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &b Sounds.Enabled &9== &eNull &d?");
      if (split[0] == null)
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &b Sounds.Enabled &9== &eNull 0 &d?"); 
      if (split[1] == null)
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &b Sounds.Enabled &9== &eNull 1 &d?"); 
      if (split[2] == null)
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &b Sounds.Enabled &9== &eNull 2 &d?"); 
      if (split[0] == null || split[1] == null || split[2] == null)
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &b Sounds.Enabled &9== &eNull all &d?"); 
    } 
  }
  
  @EventHandler
  public void sendSoundQuit(PlayerQuitEvent e) {
    Player j = e.getPlayer();
    FileConfiguration config = this.plugin.getConfig();
    String path = "Sounds.Enabled";
    String slipsound = config.getString("Sounds.Quit.Sound");
    String useperm = config.getString("Sounds.Quit.Use-Permission");
    String perm = config.getString("Sounds.Quit.Permission");
    String sap = config.getString("Sounds.Send-All-Players");
    String qe = config.getString("Sounds.Quit.Enabled");
    String[] split = slipsound.split(";");
    try {
      if (qe.equals("true") && 
        config.getString(path).equals("true"))
        if (useperm.equals("true")) {
          if (!j.hasPermission(perm) || !j.isOp()) {
            Sound sound = Sound.valueOf(split[0]);
            int vol = Integer.valueOf(split[1]).intValue();
            float pitch = Float.valueOf(split[2]).floatValue();
            if (sap.equals("true")) {
              for (Player p : Bukkit.getOnlinePlayers()) {
                Location l = p.getLocation();
                p.playSound(l, sound, vol, pitch);
              } 
            } else if (sap.equals("false")) {
              Location l = j.getLocation();
              j.playSound(l, sound, vol, pitch);
            } 
          } 
        } else if (useperm.equals("false")) {
          Sound sound = Sound.valueOf(split[0]);
          int vol = Integer.valueOf(split[1]).intValue();
          float pitch = Float.valueOf(split[2]).floatValue();
          if (sap.equals("true")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
              Location l = p.getLocation();
              p.playSound(l, sound, vol, pitch);
            } 
          } else if (sap.equals("false")) {
            Location l = j.getLocation();
            j.playSound(l, sound, vol, pitch);
          } 
        }  
    } catch (IllegalArgumentException ex) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &b Sounds.Enabled &9== &eNull &d?");
    } catch (NullPointerException ex) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &b Sounds.Enabled &9== &eNull &d?");
      if (split[0] == null)
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &b Sounds.Enabled &9== &eNull 0 &d?"); 
      if (split[1] == null)
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &b Sounds.Enabled &9== &eNull 1 &d?"); 
      if (split[2] == null)
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &b Sounds.Enabled &9== &eNull 2 &d?"); 
      if (split[0] == null || split[1] == null || split[2] == null)
        Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + "&cError: &b Sounds.Enabled &9== &eNull all &d?"); 
    } 
  }*/
}