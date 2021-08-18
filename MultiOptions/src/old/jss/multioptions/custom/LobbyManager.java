package old.jss.multioptions.custom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import old.jss.multioptions.MultiOptions;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class LobbyManager {
  private MultiOptions plugin;
  
  Random random = new Random();
  
  List<String> list = new ArrayList<>();
  
  public LobbyManager(MultiOptions plugin) {
    this.plugin = plugin;
  }
  
  public Set<String> getLobbyList() {
    FileConfiguration worldc = this.plugin.getWorldConfig();
    Set<String> list = worldc.getConfigurationSection("Multi-Lobby").getKeys(false);
    if (list.size() == 0)
      return null; 
    return list;
  }
  
  public int isLobby() {
    try {
      this.plugin.getWorldConfig().getConfigurationSection("Lobby").getKeys(false);
    } catch (NullPointerException ex) {
      return 0;
    } 
    return this.plugin.getWorldConfig().getConfigurationSection("Lobby").getKeys(false).size();
  }
  
  public void setMainLobby(Location location) {
    String lobby = String.valueOf(location.getWorld().getName()) + "," + location.getX() + "," + (location.getY() + 0.2D) + "," + location.getZ() + "," + location.getYaw() + "," + location.getPitch();
    this.plugin.getWorldConfig().set("Lobby.Default", lobby);
    this.plugin.saveWorldConfig();
  }
  
  public String getIndex(int index) {
    return getLobbyArrayList().get(index);
  }
  
  public void setMultiLobby(Location location, String args) {
    String lobby = String.valueOf(location.getWorld().getName()) + "," + location.getX() + "," + (location.getY() + 0.2D) + "," + location.getZ() + "," + location.getYaw() + "," + location.getPitch();
    this.plugin.getWorldConfig().set("Multi-Lobby." + args, lobby);
    this.plugin.saveWorldConfig();
  }
  
  public String getRandomLobby(Player p) {
    ArrayList<String> lobbies = new ArrayList<>();
    for (String name : getLobbyList())
      lobbies.add(name); 
    Collections.shuffle(lobbies, this.random);
    return lobbies.get(0);
  }
  
  public void removeLobby(String args) {
    this.plugin.getWorldConfig().set("Multi-Lobby." + args, null);
    this.plugin.saveWorldConfig();
  }
  
  public void removeLobby() {
    this.plugin.getWorldConfig().set("Lobby.Default", null);
    this.plugin.saveWorldConfig();
  }
  
  public ArrayList<String> getLobbyArrayList() {
    ArrayList<String> lobby = new ArrayList<>();
    for (String name : getLobbyList())
      lobby.add(name); 
    return lobby;
  }
  
  public Location getLocationLobby() {
    String[] location = this.plugin.getWorldConfig().getString("Lobby.Default").split(",");
    World world = Bukkit.getWorld(location[0]);
    Double x = Double.valueOf(Double.parseDouble(location[1]));
    Double y = Double.valueOf(Double.parseDouble(location[2]));
    Double z = Double.valueOf(Double.parseDouble(location[3]));
    float yaw = Float.parseFloat(location[4]);
    float pitch = Float.parseFloat(location[5]);
    return new Location(world, x.doubleValue(), y.doubleValue(), z.doubleValue(), yaw, pitch);
  }
  
  public Location getLocationMultiLobby(String args) {
    String[] location = this.plugin.getWorldConfig().getString("Multi-Lobby." + args).split(",");
    World world = Bukkit.getWorld(location[0]);
    Double x = Double.valueOf(Double.parseDouble(location[1]));
    Double y = Double.valueOf(Double.parseDouble(location[2]));
    Double z = Double.valueOf(Double.parseDouble(location[3]));
    float yaw = Float.parseFloat(location[4]);
    float pitch = Float.parseFloat(location[5]);
    return new Location(world, x.doubleValue(), y.doubleValue(), z.doubleValue(), yaw, pitch);
  }
  
  public void sendToLobby(Player player, String args) {
    player.teleport(getLocationMultiLobby(args));
  }
  
  public void sendToLobby(Player player) {
    player.teleport(getLocationLobby());
  }
}