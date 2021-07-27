package be.thijswouters.Schedulers;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import sun.font.EAttribute;
import be.thijswouters.DemonsCore;
import be.thijswouters.Files.Files;
import be.thijswouters.Kits.DemonsDefault;
import be.thijswouters.Kits.OrcsDefault;
import be.thijswouters.Listeners.EventBlockDestroy;
import be.thijswouters.SQL.Buckets;
import be.thijswouters.SQL.MySQL;
import be.thijswouters.Scoreboards.GameScoreboard;
import be.thijswouters.Scoreboards.LobbyScoreboard;
import be.thijswouters.Utils.ArrayLists;
import be.thijswouters.Utils.Chat;
import be.thijswouters.Utils.GameState;

public class GameTimer {
	
	public static int time = -1;
	
	@SuppressWarnings("deprecation")
	public static void start(){
		time = 600;
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(DemonsCore.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if(time < 0){
					return;
				}
				
				if(time > 600){
					return;
				}
				
				if(time == -1){
					time = -1;
					return;
				}

				if(time == 12000){
					Chat.broadcast("Demons", "The game is §e§lstarting§3.");       
				}
				
				if(time == 300){
					Chat.broadcast("Demons", "5 minutes left.");       
				}
				
				if(time <= 600){
					time--;
					GameScoreboard.o.unregister();
					GameScoreboard.o = GameScoreboard.board.registerNewObjective("§6§lDemons ", "dummy");
					GameScoreboard.o.setDisplaySlot(DisplaySlot.SIDEBAR);

					GameScoreboard.TimerLineNumber = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
							"§e§lTimer"));
					GameScoreboard.TimerLineNumber.setScore(4);
					GameScoreboard.Time = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
							"§7" + GameTimer.time));
					GameScoreboard.Time.setScore(3);
					
					GameScoreboard.Empty = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
							"§a"));
					GameScoreboard.Empty.setScore(2);
					
					GameScoreboard.NexusLineNumer = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
							"§e§lEnder Core"));
					GameScoreboard.NexusLineNumer.setScore(1);
					GameScoreboard.Nexus = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
							"§7" + EventBlockDestroy.health));
					GameScoreboard.Nexus.setScore(0);
				}
				
				if(time == 120){
					Chat.broadcast("Demons", "2 minutes left.");
				}
				
				if(time == 60){
					Chat.broadcast("Demons", "1 minute left.");
				}
				
				if(time <= 10 && time != -1 && time != 0){
					Chat.broadcast("Demons", time + " seconds left.");
				}
				
				if(time == 0){
					GameState.setState(GameState.AFTER_GAME);
					Chat.broadcast("GAME OVER", "The time is over!");
					Chat.broadcast("GAME OVER", "The §c§lDemons §3have won the battle!");
					GameState.setState(GameState.AFTER_GAME);
					GameScoreboard.o.unregister();
					GameScoreboard.o = GameScoreboard.board.registerNewObjective("§6§lDemons ", "dummy");
					GameScoreboard.o.setDisplaySlot(DisplaySlot.SIDEBAR);

					GameScoreboard.TimerLineNumber = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
							"§e§lTimer"));
					GameScoreboard.TimerLineNumber.setScore(4);
					GameScoreboard.Time = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
							"§7" + GameTimer.time));
					GameScoreboard.Time.setScore(3);
					
					GameScoreboard.Empty = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
							"§a"));
					GameScoreboard.Empty.setScore(2);
					
					GameScoreboard.NexusLineNumer = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
							"§e§lEnder Core"));
					GameScoreboard.NexusLineNumer.setScore(1);
					GameScoreboard.Nexus = GameScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
							"§7" + EventBlockDestroy.health));
					GameScoreboard.Nexus.setScore(0);
					for(final Player p : Bukkit.getOnlinePlayers()){
						Files.kits.set("Kits.Orcs.Default." + p.getName(), "true");
						Files.kits.set("Kits.Orcs.Miner." + p.getName(), "false");
						Files.kits.set("Kits.Orcs.Archer." + p.getName(), "false");
						Files.kits.set("Kits.Demons.Default." + p.getName(), "true");
						Files.kits.set("Kits.Demons.Skeleton." + p.getName(), "false");
						Files.kits.set("Kits.Demons.Zombie." + p.getName(), "false");
						String lobbyWorldName = Files.locations.getString("Lobby.WORLD");
						int lobbyX = Files.locations.getInt("Lobby.X");
						int lobbyY = Files.locations.getInt("Lobby.Y");
						int lobbyZ = Files.locations.getInt("Lobby.Z");
						World lobbyWORLD = Bukkit.getServer().getWorld(lobbyWorldName);
						Location lobby = new Location(lobbyWORLD, lobbyX, lobbyY, lobbyZ);
						p.teleport(lobby);
						p.getInventory().clear();
						if(ArrayLists.teamOrcs.contains(p)){
							p.sendMessage("§6+5 §eBuckets");
							Buckets.addBuckets(p.getName(), 5);
						}
						
						if(ArrayLists.teamDemons.contains(p)){
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
		}, 0L, 20L);
	}
}
