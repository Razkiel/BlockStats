package de.razkiel.blockstats;


import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;


public class BlockStatsBlockListener extends BlockListener {
	
	public static BlockStats plugin;
	private int blocksplaced = 0;
	private int blocksbroke= 0;
	private int blocksaltered = 0;
		
	public BlockStatsBlockListener(BlockStats instance) {
		plugin = instance;
	}
	public void onBlockPlace (BlockPlaceEvent event) {
		
		blocksaltered++;
		blocksplaced++;
		
		
	}
	public void onBlockBreak (BlockBreakEvent event) {
		
		blocksbroke++;
		blocksaltered++;
		
		
	}

	public int getBlocksPlaced() {
		
		return blocksplaced;
	}
	
	public int getblocksbroke() {
		
		return blocksbroke;
	}
	
	public int getblocksaltered() {
		
		return blocksaltered;
	}
	
}
