package old.jss.multioptions.cmd;

import java.util.List;
import jss.multioptions.MultiOptions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
@SuppressWarnings("unused")
public class Vanish implements CommandExecutor, TabCompleter {
  private MultiOptions plugin;
  
  public Vanish(MultiOptions plugin) {
    this.plugin = plugin;
    plugin.getCommand("Vanish").setExecutor(this);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player j = (Player)sender;
    if (args.length != 1)
      if (args.length >= 2) {
        Player p = Bukkit.getPlayer(args[1].toString());
        if (p == null)
          return true; 
      }  
    return true;
  }
  
  public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
    return null;
  }
}