package jss.multioptions.utils;

import java.util.ArrayList;

public class InventoryUtils {
	
	private String inventoryName;
	private String title;
	private int slots;
	private ArrayList<ItemUtils> items;
	
	public InventoryUtils(String inventoryName, String title, int slots, ArrayList<ItemUtils> items) {
		this.inventoryName = inventoryName;
		this.title = title;
		this.slots = slots;
		this.items = items;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSlots() {
		return slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public ArrayList<ItemUtils> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemUtils> items) {
		this.items = items;
	}
	
}
