package old.jss.multioptions.cmd;

import old.jss.multioptions.MultiOptions;
import old.jss.multioptions.custom.LobbyManager;
import jss.multioptions.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.scanner.ScannerException;
@SuppressWarnings("unused")
public class LobbyCmd implements CommandExecutor {
  private MultiOptions plugin;
  
  private CommandSender c = (CommandSender)Bukkit.getConsoleSender();
  
  public LobbyCmd(MultiOptions plugin) {
    this.plugin = plugin;
    plugin.getCommand("Lobby").setExecutor(this);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player j = (Player)sender;
   //LobbyManager lm = new LobbyManager();
    FileConfiguration worlds = this.plugin.getWorldConfig();
    if (args.length == 0) {
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
          return true; 
        Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixPlayer()) + " ") ;
        return true;
      } 
      return true;
    } 
    if (args.length >= 1)
      try {
        //if (lm.getLobbyList().contains(args[0])) {
         // lm.sendToLobby(j, args[0]);
        //} else {
          if (!j.hasPermission("MultiOptions.Lobby.Notify.Error") || !j.isOp())
            return true; 
          //Utils.sendColorMessage(j, String.valueOf(Utils.getPrefixPlayer()) + " " + (this.plugin.myLocale()).Error_Lobby_Args.replace("<args_error>", args[0]));
          return true;
        
      } catch (NullPointerException ex) {
        //Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + (this.plugin.myLocale()).Error_Lobby_Args.replace("<args_error>", args[0]));
      } catch (ScannerException ex2) {
        //Utils.sendColorMessage(this.c, String.valueOf(Utils.getPrefixMO()) + " " + (this.plugin.myLocale()).Error_Lobby_Args.replace("<args_error>", args[0]));
      }  
    return true;
  }
}


/* Location:              C:\Users\Alumno\Downloads\MultiOptions[3.0.0-8A].jar!\jss\multioptions\cmd\LobbyCmd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */