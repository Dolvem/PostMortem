package io.github.dolvem.postmortem.messages;

import io.github.dolvem.postmortem.PostMortemApp;

public class MessageProvider {

	private PostMortemApp plugin;

	public MessageProvider(PostMortemApp plugin) {
		this.plugin = plugin;
	}

	// getLogger().info(MessageFormat.format("Locale: {0}",
	// getConfig().getString("locale")));

}
