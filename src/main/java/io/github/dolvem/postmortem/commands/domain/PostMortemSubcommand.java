package io.github.dolvem.postmortem.commands.domain;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostMortemSubcommand {
	/** Lists the active chests. */
	LIST("list", Arrays.asList("postmortem.list", "postmortem.list.other")),
	/** Removes an active chest. */
	REMOVE("remove", Arrays.asList("postmortem.remove", "postmortem.remove.other")),
	/** Removes all the active chests. */
	REMOVE_ALL("removeall", Arrays.asList("postmortem.remove.all", "postmortem.remove.all.other")),
	/** Removes all the active chests. */
	REGENERATE("regenerate", Arrays.asList("postmortem.regenerate"));

	/** Name requested to use the sub-command */
	private String name;
	/** Related permissions */
	private List<String> permissions;
}
