package io.github.dolvem.postmortem.domain;

import org.bukkit.inventory.ItemStack;

import lombok.Data;

@Data
public class SavedPlayerInventory {
	private ItemStack[] armorContents;
	private ItemStack[] extraContents;
	private ItemStack[] storageContents;
}
