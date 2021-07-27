package be.thijswouters.Listeners;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import be.thijswouters.DemonsCore;
import be.thijswouters.Files.Files;
import be.thijswouters.SQL.Buckets;
import be.thijswouters.SQL.MySQL;
import be.thijswouters.Schedulers.GameTimer;
import be.thijswouters.Scoreboards.GameScoreboard;
import be.thijswouters.Utils.ArrayLists;
import be.thijswouters.Utils.Chat;
import be.thijswouters.Utils.GameState;
import be.thijswouters.Utils.ParticleEffect;

public class EventBlockDestroy implements Listener{
	
	public static int health = -1;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDestroy(BlockBreakEvent e){
		Player p2 = e.getPlayer();
		
		if(ArrayLists.teamDemons.contains(p2)){
			e.setCancelled(true);
			return;
		}
		
		if(e.getBlock().getType() != Material.ENDER_STONE){
			e.setCancelled(true);
			return;
		}
		
		if(health <= -1){
			e.setCancelled(true);
			return;
		}
		
		if(health > 30){
			e.setCancelled(true);
			return;
		}
		
		if(health <= 30 && health > 1){
			Bukkit.getWorld("Demons").playSound(e.getBlock().getLocation(), Sound.ANVIL_LAND, 2F, 2F);
			e.setCancelled(true);
			health--;
			Chat.broadcast("Ender Core", "§e" + health + " §3health left.");
			p2.sendMessage("§6+1 §eBuckets");
			Buckets.addBuckets(p2.getName(), 1);
			ParticleEffect.FIREWORKS_SPARK.display(0, 0, 0, 2, 5, e.getBlock().getLocation(), 30);
			GameScoreboard.o.unregister();
			GameScoreboard.o = GameScoreboard.board.registerNewObjective("§6§lDemons ", "dummy");
			GameScoreboard.o.setDisplaySlot(DisplaySlot.SIDEBAR);

			GameScoreboard.TimerLineNumber = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
					"§e§lTimer"));
			GameScoreboard.TimerLineNumber.setScore(4);
			GameScoreboard.Time = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
					"§c" + GameTimer.time));
			GameScoreboard.Time.setScore(3);
			
			GameScoreboard.Empty = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
					"§a"));
			GameScoreboard.Empty.setScore(2);
			
			GameScoreboard.NexusLineNumer = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
					"§e§lEnder Core"));
			GameScoreboard.NexusLineNumer.setScore(1);
			GameScoreboard.Nexus = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
					"§c" + health));
			GameScoreboard.Nexus.setScore(0);
			return;
		}
		
		if(health == 1){
			if(health == 1){
				health = -1;
				GameScoreboard.o.unregister();
				GameScoreboard.o = GameScoreboard.board.registerNewObjective("§6§lDemons ", "dummy");
				GameScoreboard.o.setDisplaySlot(DisplaySlot.SIDEBAR);

				GameScoreboard.TimerLineNumber = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
						"§e§lTimer"));
				GameScoreboard.TimerLineNumber.setScore(4);
				GameScoreboard.Time = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
						"§c" + GameTimer.time));
				GameScoreboard.Time.setScore(3);
				
				GameScoreboard.Empty = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
						"§e"));
				GameScoreboard.Empty.setScore(2);
				
				GameScoreboard.NexusLineNumer = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
						"§eEnder Core"));
				GameScoreboard.NexusLineNumer.setScore(1);
				GameScoreboard.Nexus = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
						"§c" + 0));
				GameScoreboard.Nexus.setScore(0);
				e.getBlock().getDrops().clear();
				Chat.broadcast("GAME OVER", "The §aEnder Core §3has been destroyed.");
				Chat.broadcast("GAME OVER", "The §aOrcs §3have won the battle!");
				Chat.broadcast("Server", "Restarting in §e10 §3seconds.");
				GameState.setState(GameState.AFTER_GAME);
				
				for(final Player p : Bukkit.getOnlinePlayers()){
					Files.kits.set("Kits.Orcs.Default." + p.getName(), "true");
					Files.kits.set("Kits.Orcs.Miner." + p.getName(), "false");
					Files.kits.set("Kits.Orcs.Archer." + p.getName(), "false");
					Bukkit.getWorld("Demons").playSound(e.getBlock().getLocation(), Sound.EXPLODE, -2F, -2F);
					String lobbyWorldName = Files.locations.getString("Lobby.WORLD");
					int lobbyX = Files.locations.getInt("Lobby.X");
					int lobbyY = Files.locations.getInt("Lobby.Y");
					int lobbyZ = Files.locations.getInt("Lobby.Z");
					World lobbyWORLD = Bukkit.getServer().getWorld(lobbyWorldName);
					Location lobby = new Location(lobbyWORLD, lobbyX, lobbyY, lobbyZ);
					p.teleport(lobby);
					p.getInventory().clear();
					if(ArrayLists.teamDemons.contains(p)){
						p.sendMessage("§6+5 §eBuckets");
						Buckets.addBuckets(p.getName(), 5);
					}
					
					if(ArrayLists.teamOrcs.contains(p)){
						p.sendMessage("§6+30 §eBuckets");
						Buckets.addBuckets(p.getName(), 30);
					}
					
					Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(DemonsCore.getInstance(), new Runnable() {
						@Override
						public void run() {
				              ByteArrayDataOutput out = ByteStreams.newDataOutput();
				              out.writeUTF("Connect");
				              out.writeUTF("Hub"); 
				              p.sendPluginMessage(DemonsCore.getInstance(), "BungeeCord", out.toByteArray());
						}
					}, 200L);
					
					Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(DemonsCore.getInstance(), new Runnable() {
						@Override
						public void run() {
				              ByteArrayDataOutput out = ByteStreams.newDataOutput();
				              out.writeUTF("Connect");
				              out.writeUTF("Hub"); 
				              p.sendPluginMessage(DemonsCore.getInstance(), "BungeeCord", out.toByteArray());
						}
					}, 220);
					
					Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(DemonsCore.getInstance(), new Runnable() {
						@Override
						public void run() {
				              ByteArrayDataOutput out = ByteStreams.newDataOutput();
				              out.writeUTF("Connect");
				              out.writeUTF("Hub"); 
				              p.sendPluginMessage(DemonsCore.getInstance(), "BungeeCord", out.toByteArray());
						}
					}, 240L);
					
					Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(DemonsCore.getInstance(), new Runnable() {
						@Override
						public void run() {
				              ByteArrayDataOutput out = ByteStreams.newDataOutput();
				              out.writeUTF("Connect");
				              out.writeUTF("Hub"); 
				              p.sendPluginMessage(DemonsCore.getInstance(), "BungeeCord", out.toByteArray());
						}
					}, 260);
					
					Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(DemonsCore.getInstance(), new Runnable() {
						@Override
						public void run() {
				              ByteArrayDataOutput out = ByteStreams.newDataOutput();
				              out.writeUTF("Connect");
				              out.writeUTF("Hub"); 
				              p.sendPluginMessage(DemonsCore.getInstance(), "BungeeCord", out.toByteArray());
						}
					}, 200L);
					
					Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(DemonsCore.getInstance(), new Runnable() {
						@Override
						public void run() {
				              ByteArrayDataOutput out = ByteStreams.newDataOutput();
				              out.writeUTF("Connect");
				              out.writeUTF("Hub"); 
				              p.sendPluginMessage(DemonsCore.getInstance(), "BungeeCord", out.toByteArray());
						}
					}, 280);
					
					Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(DemonsCore.getInstance(), new Runnable() {
						@Override
						public void run() {
				              ByteArrayDataOutput out = ByteStreams.newDataOutput();
				              out.writeUTF("Connect");
				              out.writeUTF("Hub"); 
				              p.sendPluginMessage(DemonsCore.getInstance(), "BungeeCord", out.toByteArray());
						}
					}, 200L);
					
					Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(DemonsCore.getInstance(), new Runnable() {
						@Override
						public void run() {
				              ByteArrayDataOutput out = ByteStreams.newDataOutput();
				              out.writeUTF("Connect");
				              out.writeUTF("Hub"); 
				              p.sendPluginMessage(DemonsCore.getInstance(), "BungeeCord", out.toByteArray());
				              Bukkit.getServer().shutdown();
						}
					}, 300);
			    }
			}
		}
	}
}
