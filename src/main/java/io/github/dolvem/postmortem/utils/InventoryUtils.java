package io.github.dolvem.postmortem.utils;

import org.bukkit.inventory.PlayerInventory;

import io.github.dolvem.postmortem.domain.SavedPlayerInventory;

public final class InventoryUtils {

	private InventoryUtils() {
		super();
	}

	public static void importInventory(PlayerInventory playerInventory, SavedPlayerInventory savedPlayerInventory) {

		playerInventory.setArmorContents(savedPlayerInventory.getArmorContents());
		playerInventory.setExtraContents(savedPlayerInventory.getExtraContents());
		playerInventory.setStorageContents(savedPlayerInventory.getStorageContents());
	}

	public static SavedPlayerInventory exportInventory(PlayerInventory playerInventory) {

		SavedPlayerInventory output = new SavedPlayerInventory();
		output.setArmorContents(playerInventory.getArmorContents());
		output.setExtraContents(playerInventory.getExtraContents());
		output.setStorageContents(playerInventory.getStorageContents());
		
		return output;
	}
}
