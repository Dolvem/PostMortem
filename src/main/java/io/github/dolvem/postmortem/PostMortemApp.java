package io.github.dolvem.postmortem;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.dolvem.postmortem.commands.PostMortemCommand;
import io.github.dolvem.postmortem.commands.PostMortemTabCompleter;
import io.github.dolvem.postmortem.listeners.PlayerDeathListener;
import io.github.dolvem.postmortem.listeners.PlayerInteractListener;
import io.github.dolvem.postmortem.messages.MessageProvider;
import io.github.dolvem.postmortem.repository.ChestManager;
import lombok.Getter;

@Getter
public class PostMortemApp extends JavaPlugin {

	private ChestManager chestManager = null;
	private MessageProvider messageProvider = null;

	@Override
	public void onEnable() {

		// Configuration
		saveDefaultConfig();

		// Managers
		chestManager = new ChestManager();
		messageProvider = new MessageProvider(this);

		// Listeners
		PluginManager pluginManager = getServer().getPluginManager();
		pluginManager.registerEvents(new PlayerDeathListener(this), this);
		pluginManager.registerEvents(new PlayerInteractListener(this), this);

		// Commands
		getCommand("postmortem").setExecutor(new PostMortemCommand(this));
		getCommand("postmortem").setTabCompleter(new PostMortemTabCompleter());

		// TODO Implement update checker with console log
	}

	@Override
	public void onDisable() {

		if (chestManager != null) {
			chestManager.closeManager();
		}
	}

}
