package io.github.dolvem.postmortem.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import io.github.dolvem.postmortem.commands.domain.PostMortemSubcommand;

public class PostMortemTabCompleter implements TabCompleter {


	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

		if (args.length == 1) {
			return getAvailableSubcommands(sender, args[args.length - 1]);
		}

		return null;
	}

	private List<String> getAvailableSubcommands(CommandSender sender, String lastArg) {

		List<String> output = new ArrayList<>();

		boolean senderIsAdmin = sender.isOp() || sender.hasPermission("postmortem.*");

		for (PostMortemSubcommand subcommand : PostMortemSubcommand.values()) {
			if (senderIsAdmin || subcommand.getPermissions().stream().anyMatch(sender::hasPermission)) {
				output.add(subcommand.getName());
			}
		}

		output = output.stream().filter(c -> StringUtils.startsWith(c, lastArg)).collect(Collectors.toList());

		// Send null when no completion is available
		if (output.size() == 0) {
			output = null;
		}

		return output;
	}

}
