package io.github.dolvem.postmortem.domain;

import java.util.UUID;

import org.bukkit.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeathChest {
	private int id;
	private UUID ownerId;
	private SavedPlayerInventory inventory;
	private Location location;
}
