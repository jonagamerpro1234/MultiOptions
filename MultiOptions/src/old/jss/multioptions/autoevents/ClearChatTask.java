package old.jss.multioptions.autoevents;

import jss.multioptions.MultiOptions;
import jss.multioptions.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class ClearChatTask  {
  private MultiOptions plugin;
  
  public int TaskID;
  
  private CommandSender c = (CommandSender)Bukkit.getConsoleSender();
  
  public ClearChatTask(MultiOptions plugin) {
    this.plugin = plugin;
  }
  
  public void runClearChat() {
    final FileConfiguration config = this.plugin.getConfig();
    final BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
    final int tick = config.getInt("ClearChat.Ticks");
    final String path = "ClearChat.Enabled";
    try {
      this.TaskID = scheduler.scheduleSyncRepeatingTask((Plugin)this.plugin, new Runnable() {
            public void run() {
              try {
                if (config.getString(path).equals("true")) {
                  ClearChatTask.this.getAction();
                } else if (config.getString(path).equals("false")) {
                  scheduler.cancelTask(TaskID);
                } 
              } catch (NullPointerException ex) {
                if (tick == -1 || !config.contains("ClearChat")) {
                  Utils.sendColorMessage(ClearChatTask.this.c, String.valueOf(Utils.getPrefix()) + " " + "&cError: &bClearChat.Ticks &8== &enull &d?");
                  scheduler.cancelTask(TaskID);
                } 
              } 
            }
          }, 600L, tick);
    } catch (NullPointerException ex) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " " + "&cError: &bClearChat.Enabled &8== &enull &d?");
    } 
  }
  
  public void getAction() {
    FileConfiguration config = this.plugin.getConfig();
    String path = "Settings.Use-Default-Prefix";
    String msg = "";//(this.plugin.myLocale()).Clear_Chat_Auto;
    String prefix = config.getString("Settings.Prefix");
    for (int i = 0; i < 100; i++)
      Bukkit.broadcastMessage(" "); 
    try {
      if (config.getString("Config.Debug.Enabled").equals("true"))
        Utils.sendColorMessage("&b test messages =========== " + msg); 
    } catch (NullPointerException nullPointerException) {}
    try {
      if (config.getString(path).equals("true")) {
        Utils.sendColorMessage(String.valueOf(Utils.getPrefixPlayer()) + " " + msg);
      } else if (config.getString(path).equals("false")) {
        Utils.sendColorMessage(String.valueOf(prefix) + " " + msg);
      } 
    } catch (NullPointerException ex) {
      Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefix()) + " " + "&cError: &bSettings.Enabled &8== &enull &d? &9|| &bSettings.Prefix &8== &enull &d?");
    } 
  }
}


/* Location:              C:\Users\Alumno\Downloads\MultiOptions[3.0.0-8A].jar!\jss\multioptions\autoevents\ClearChatTask.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */