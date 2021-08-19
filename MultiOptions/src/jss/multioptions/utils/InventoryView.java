package jss.multioptions.utils;

import org.bukkit.entity.Player;

public class InventoryView {
	
	private String inventory;
	private Player player;
	
	public InventoryView(String inventory, Player player) {
		this.inventory = inventory;
		this.player = player;
	}

	public String getInventory() {
		return inventory;
	}

	public Player getPlayer() {
		return player;
	}
	
}
