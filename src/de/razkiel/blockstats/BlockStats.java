package de.razkiel.blockstats;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class BlockStats extends JavaPlugin {
	
	private final BlockStatsBlockListener blocklistener = new BlockStatsBlockListener(this);
	private final BlockStatsPlayerListener playerlistener = new BlockStatsPlayerListener(this);

@Override

	public void onDisable() {
	
		PluginDescriptionFile descriptionFile = this.getDescription();
		System.out.println(descriptionFile.getName() + " beendet!");	
	}
@Override 

	public void onEnable() {
		
		//plugin.yml
		PluginDescriptionFile descriptionFile = this.getDescription();
		String authors = "";
		
		for (int i = 0; i < descriptionFile.getAuthors().size(); i++) {
			
			authors = authors + descriptionFile.getAuthors().get(i);
			if (i < descriptionFile.getAuthors().size()-1)
				authors = authors + ", ";			
			
		}
		System.out.println(descriptionFile.getName() + " v." + descriptionFile.getVersion() + " by "  + authors + " wird geladen...");
				
		//auf welche Aktionen wird reagiert:
		PluginManager pm = this.getServer().getPluginManager();		

		pm.registerEvent(Type.BLOCK_PLACE, blocklistener, Event.Priority.Normal, this); 
		pm.registerEvent(Type.BLOCK_BREAK, blocklistener, Event.Priority.Normal, this);
		pm.registerEvent(Type.PLAYER_CHAT, playerlistener, Event.Priority.Normal, this);
		
		System.out.println(descriptionFile.getName() + " gestartet");
	}
	
	public boolean onCommand (CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		String command = cmd.getName();
		
		//if (command.equals("bp")) {
		if (true) {
			sender.sendMessage("Placed Blocks: " + blocklistener.getBlocksPlaced());		
			return true;
		} else {
			return false;
		}
	}
	
	

}