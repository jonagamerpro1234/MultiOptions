package jss.multioptions.utils;

import java.util.List;

import org.bukkit.inventory.ItemStack;

public class ItemUtils {
	
	private ItemStack item;
	private String name;
	private List<Integer> slots;
	private List<String> lore;
	private String openInventory;
	private List<String> cmd;
	
	public ItemUtils(ItemStack item, String name, List<Integer> slots, List<String> lore, String openInventory, List<String> cmd) {
		this.item = item;
		this.name = name;
		this.slots = slots;
		this.lore = lore;
		this.openInventory = openInventory;
		this.cmd = cmd;
	}

	public ItemStack getItem() {
		return item;
	}

	public void setItem(ItemStack item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getSlots() {
		return slots;
	}

	public void setSlots(List<Integer> slots) {
		this.slots = slots;
	}

	public List<String> getLore() {
		return lore;
	}

	public void setLore(List<String> lore) {
		this.lore = lore;
	}

	public String getOpenInventory() {
		return openInventory;
	}

	public void setOpenInventory(String openInventory) {
		this.openInventory = openInventory;
	}

	public List<String> getCmd() {
		return cmd;
	}

	public void setCmd(List<String> cmd) {
		this.cmd = cmd;
	}
	
	
}
