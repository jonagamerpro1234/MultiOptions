package jss.multioptions.commands;

import jss.multioptions.MultiOptions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FeedCmd implements CommandExecutor {
  private MultiOptions plugin;
  
  public FeedCmd(MultiOptions plugin) {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof org.bukkit.entity.Player))
      return false; 
    return true;
  }
}


/* Location:              C:\Users\Alumno\Downloads\MultiOptions[3.0.0-8A].jar!\jss\multioptions\cmd\FeedCmd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */