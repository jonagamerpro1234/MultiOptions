package old.jss.multioptions.custom;

import java.util.UUID;
import org.bukkit.entity.Player;

public class PlayerManager {
  Player player;
  
  String name;
  
  UUID uuid;
  
  public PlayerManager(Player player, String name, UUID uuid) {
    this.player = player;
    this.name = name;
    this.uuid = uuid;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public UUID getUuid() {
    return this.uuid;
  }
  
  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
  
  public Player getPlayer() {
    return this.player;
  }
}


/* Location:              C:\Users\Alumno\Downloads\MultiOptions[3.0.0-8A].jar!\jss\multioptions\custom\PlayerManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */