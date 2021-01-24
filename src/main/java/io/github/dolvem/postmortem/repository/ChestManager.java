package io.github.dolvem.postmortem.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import io.github.dolvem.postmortem.domain.DeathChest;

public class ChestManager {

	private List<DeathChest> chestCache = new ArrayList<>();

	public void addChest(DeathChest chest) {

		// TODO Persist and generate chestId
		// Adds the chest to the cache
		chestCache.add(chest);
	}

	public void removeChest(DeathChest chest) {

		// TODO Logic removal of the chest on the repository 
		// Removes the chest from the cache
		chestCache.remove(chest);
	}

	public boolean hasChestsOnCache(UUID playerUniqueId) {

		return chestCache.stream().anyMatch(c -> c.getOwnerId().equals(playerUniqueId));
	}

	public List<DeathChest> getChests(UUID playerUniqueId) {

		return chestCache.stream().filter(c -> c.getOwnerId().equals(playerUniqueId)).collect(Collectors.toList());
	}

	public void closeManager() {
		// TODO
	}

}
