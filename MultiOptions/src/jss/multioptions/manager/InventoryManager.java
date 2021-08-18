package jss.multioptions.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import jss.multioptions.MultiOptions;
import jss.multioptions.utils.InventoryPlayerUtils;
import jss.multioptions.utils.InventoryUtils;
import jss.multioptions.utils.ItemUtils;
import jss.multioptions.utils.Utils;

public class InventoryManager {
	
	private ArrayList<InventoryUtils> inventoryUtils = new ArrayList<>();
	private ArrayList<InventoryPlayerUtils> playerUtils = new ArrayList<>();
	public InventoryManager(MultiOptions plugin) {
	}

	public ArrayList<InventoryUtils> getInventorysUtils() {
		return inventoryUtils;
	}

	public InventoryUtils getInventoryUtils(String name) {
		Iterator<InventoryUtils> iterator = inventoryUtils.iterator();
		while(iterator.hasNext()) {
			InventoryUtils i  = (InventoryUtils)iterator.next();
			if(i.getInventoryName().equals(name)) {
				return i;
			}
		}
		return null;
	}
	
	public void setInventoryUtils(ArrayList<InventoryUtils> inventoryUtils) {
		this.inventoryUtils = inventoryUtils;
	}

	public InventoryPlayerUtils getPlayerUtils(Player player) {
		Iterator<InventoryPlayerUtils> iterator = playerUtils.iterator();
		while(iterator.hasNext()) {
			InventoryPlayerUtils p = (InventoryPlayerUtils)iterator.next();
			if(player.getName().equals(p.getPlayer().getName())) {
				return p;
			}
		}
		return null;
	}

	public void setPlayerUtils(Player player, String inventory) {
		this.playerUtils.add(new InventoryPlayerUtils(inventory, player));
	}
	
	public boolean removePlayerUtils(String name) {
		for(int i = 0; i < playerUtils.size(); i++) {
			if(((InventoryPlayerUtils)this.playerUtils.get(i)).getPlayer().getName().equals(name)) {
				this.playerUtils.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void createInventory(Player player, String inventory) {
		InventoryUtils invu= this.getInventoryUtils(inventory);
		Bukkit.createInventory(null, invu.getSlots(), Utils.hexcolor(invu.getTitle()));
		Iterator<ItemUtils> itu = invu.getItems().iterator();
		
		while(itu.hasNext()) {
			ItemUtils itemU = (ItemUtils)itu.next();
			List<Integer> slots = itemU.getSlots();
			Iterator<Integer> islot = slots.iterator();
			
			while(islot.hasNext()) {
				islot.next();
				itemU.getItem();
				
			}
		}
	}
		
}
