package io.github.dolvem.postmortem.listeners;

import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import io.github.dolvem.postmortem.PostMortemApp;
import io.github.dolvem.postmortem.domain.DeathChest;
import io.github.dolvem.postmortem.repository.ChestManager;
import io.github.dolvem.postmortem.utils.InventoryUtils;
import io.github.dolvem.postmortem.utils.LocationUtils;

public class PlayerInteractListener implements Listener {

//	private static Logger logger = Bukkit.getLogger();

	private PostMortemApp plugin;

	public PlayerInteractListener(PostMortemApp plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {

		Block clickedBlock = event.getClickedBlock();
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK && clickedBlock.getType() == Material.CHEST) {
			Player player = event.getPlayer();
			UUID playerUniqueId = player.getUniqueId();

			ChestManager chestManager = plugin.getChestManager();
			// Checks for active DeathChests
			if (!chestManager.hasChestsOnCache(playerUniqueId)) {
				return;
			}

			List<DeathChest> chestList = chestManager.getChests(playerUniqueId);
			Location chestLocation = clickedBlock.getLocation();
			DeathChest chest = null;
			for (DeathChest chestItem : chestList) {
				if (LocationUtils.compareBlocks(chestItem.getLocation(), chestLocation)) {
					chest = chestItem;
					break;
				}
			}

			// This chest is not a DeathChest
			if (chest == null) {
				return;
			}

			InventoryUtils.importInventory(player.getInventory(), chest.getInventory());

			// FIXME Set into a sync task
			clickedBlock.setType(Material.AIR);

			// Removes the chest from the cache
			chestManager.removeChest(chest);
		}
	}
}
