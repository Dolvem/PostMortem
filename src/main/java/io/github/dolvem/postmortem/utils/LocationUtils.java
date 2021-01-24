package io.github.dolvem.postmortem.utils;

import org.bukkit.Location;

public final class LocationUtils {

	private LocationUtils() {
		super();
	}

	public static boolean compareBlocks(Location locA, Location locB) {

		return locA.getBlockX() == locB.getBlockX() && locA.getBlockY() == locB.getBlockY()
				&& locA.getBlockZ() == locB.getBlockZ();
	}

}
