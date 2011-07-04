package de.razkiel.blockstats;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

public class BlockStatsPlayerListener extends PlayerListener {
	
	public static BlockStats plugin;
	
	public BlockStatsPlayerListener( BlockStats instance) {
		plugin = instance;
	}

	public void onPlayerCommand(PlayerChatEvent event) {
		
		System.out.println("Zort");
		String[] split = event.getMessage().split(" ");
		
		if (split[0].equalsIgnoreCase("/bp"))  {
			System.out.println("Foo");
		} else {
			System.out.println("Bar");
		}
	}
}
