package be.thijswouters.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import be.thijswouters.DemonsCore;
import be.thijswouters.Files.Files;
import be.thijswouters.Schedulers.GameTimer;
import be.thijswouters.Schedulers.LobbyTimer;
import be.thijswouters.Scoreboards.LobbyScoreboard;
import be.thijswouters.Teams.Demons;
import be.thijswouters.Teams.Orcs;
import be.thijswouters.Utils.ArrayLists;
import be.thijswouters.Utils.GameState;

public class EventPlayerQuit implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		final Player p = e.getPlayer();
		p.getActivePotionEffects().clear();
	    p.setWalkSpeed(0.2F);
		Files.kits.set("Kits.Orcs.Default." + p.getName(), "true");
		Files.kits.set("Kits.Orcs.Miner." + p.getName(), "false");
		Files.kits.set("Kits.Orcs.Archer." + p.getName(), "false");
		Files.kits.set("Kits.Demons.Default." + p.getName(), "true");
		Files.kits.set("Kits.Demons.Skeleton." + p.getName(), "false");
		Files.kits.set("Kits.Demons.Zombie." + p.getName(), "false");
		LobbyScoreboard.o.unregister();
		LobbyScoreboard.o = LobbyScoreboard.board.registerNewObjective("§6§lDemons ", "dummy");
		LobbyScoreboard.o.setDisplaySlot(DisplaySlot.SIDEBAR);

		LobbyScoreboard.TimerLineNumber = LobbyScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
				"§e§lTimer"));
		LobbyScoreboard.TimerLineNumber.setScore(4);
		LobbyScoreboard.Time = LobbyScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
				"§7" + LobbyTimer.time));
		LobbyScoreboard.Time.setScore(3);
		
		LobbyScoreboard.Empty = LobbyScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
				"§a"));
		LobbyScoreboard.Empty.setScore(2);
		
		LobbyScoreboard.PlayersLineNumber = LobbyScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
				"§e§lPlayers"));
		LobbyScoreboard.PlayersLineNumber.setScore(1);
		LobbyScoreboard.Players = LobbyScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
				"§7" + (Bukkit.getOnlinePlayers().size()-1) ));
		LobbyScoreboard.Players.setScore(0);
		if(ArrayLists.teamDemons.contains(p)){
			e.setQuitMessage("§b» §6Demons §8// §c" + p.getName() + " §3has left the game. §6(§e" + (ArrayLists.teamDemons.size() - 1 + ArrayLists.teamOrcs.size()) + "/16§6)");
		
		} else if(ArrayLists.teamOrcs.contains(p)){
			e.setQuitMessage("§b» §6Demons §8// §c" + p.getName() + " §3has left the game. §6(§e" + (ArrayLists.teamOrcs.size() - 1 + ArrayLists.teamDemons.size()) + "/16§6)");
		
		} else {
			e.setQuitMessage("§b» §6Demons §8// §7" + p.getName() + " §3has left the game.");
			return;
		}
			
		if((ArrayLists.teamDemons.size() + ArrayLists.teamOrcs.size()) -1 < 2){
			LobbyTimer.time = -1;
			GameTimer.time = -1;
			
			if(!GameState.isState(GameState.IN_LOBBY) && !GameState.isState(GameState.AFTER_GAME)){
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
		
		LobbyScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
				"§7" + (Bukkit.getOnlinePlayers().size()-1)));
		
		if(ArrayLists.teamDemons.contains(p)){
			Demons.removePlayer(p);
		}
		
		if(ArrayLists.teamOrcs.contains(p)){
			Orcs.removePlayer(p);
		}
	}
}
