package io.github.dolvem.postmortem.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import io.github.dolvem.postmortem.PostMortemApp;
import io.github.dolvem.postmortem.domain.DeathChest;
import io.github.dolvem.postmortem.utils.InventoryUtils;

public class PlayerDeathListener implements Listener {

//	private static Logger logger = Bukkit.getLogger();

	private PostMortemApp plugin;

	public PlayerDeathListener(PostMortemApp plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {

		if (!event.getKeepInventory()) {
			Player player = event.getEntity();
			// Extracts all the needed data
			plugin.getChestManager().addChest(extractDeathChest(player));
			// Generates the chest in the death location
			generateChest(player);
			// Prevents the inventory items from dropping
			event.getDrops().clear();
		}
	}

	private DeathChest extractDeathChest(Player player) {

		DeathChest output = new DeathChest();

		output.setInventory(InventoryUtils.exportInventory(player.getInventory()));
		output.setLocation(player.getLocation());
		output.setOwnerId(player.getUniqueId());

		return output;
	}

	private void generateChest(Player player) {
		Location deathLocation = player.getLocation();
		Block chestBlock = deathLocation.getBlock();
		chestBlock.setType(Material.CHEST);
	}

}
