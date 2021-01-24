package io.github.dolvem.postmortem.messages;

import io.github.dolvem.postmortem.PostMortemApp;
import io.github.dolvem.postmortem.providers.ConfigProvider;

public class LocaleProvider {

	private PostMortemApp plugin;
	private ConfigProvider configProvider;

	private LocaleProvider() {
		configProvider = new ConfigProvider(plugin, fileName)
	}

}
