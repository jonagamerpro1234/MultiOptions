package jss.multioptions.utils;

import org.bukkit.entity.Player;

public class InventoryPlayerUtils {
	
	private String inventory;
	private Player player;
	
	public InventoryPlayerUtils(String inventory, Player player) {
		this.inventory = inventory;
		this.player = player;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}


}
