package io.github.dolvem.postmortem.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import io.github.dolvem.postmortem.PostMortemApp;

public class PostMortemCommand implements CommandExecutor {

//	private static Logger logger = Bukkit.getLogger();
	
	private PostMortemApp plugin;

	public PostMortemCommand(PostMortemApp plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (args.length == 0) {
			sender.sendMessage("Use /postmortem help");
			return true;
		}
		
		return false;
	}

	private boolean validateSubcommand(String args) {
		
		return false;
	}
	
}
