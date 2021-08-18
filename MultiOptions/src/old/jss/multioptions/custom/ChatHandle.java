package old.jss.multioptions.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jss.multioptions.MultiOptions;
import org.bukkit.configuration.file.FileConfiguration;

public class ChatHandle {
  private MultiOptions plugin;
  
  List<String> list_path = new ArrayList<>();
  
  private String path = "ChatFormat.Groups";
  
  public ChatHandle(MultiOptions plugin) {
    this.plugin = plugin;
  }
  
  public Set<String> getChatFormatList() {
    FileConfiguration config = this.plugin.getConfig();
    Set<String> chat = config.getConfigurationSection(this.path).getKeys(false);
    if (chat.size() != 0)
      return null; 
    return chat;
  }
  
  public int isChatFormat() {
    try {
      this.plugin.getConfig().getConfigurationSection(this.path).getKeys(false);
    } catch (NullPointerException ex) {
      return 0;
    } 
    return this.plugin.getConfig().getConfigurationSection(this.path).getKeys(false).size();
  }
  
  public String getChatFormatGroup(String arg) {
    FileConfiguration config = this.plugin.getConfig();
    for (String key : config.getConfigurationSection(this.path).getKeys(false)) {
      if (arg.contains(key) && 
        arg.equals(key)) {
        String chat = config.getString(String.valueOf(this.path) + "." + key + ".Format");
        return chat;
      } 
    } 
    return null;
  }
}