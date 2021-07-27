package be.thijswouters.Schedulers;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

import sun.font.EAttribute;
import be.thijswouters.DemonsCore;
import be.thijswouters.Files.Files;
import be.thijswouters.Kits.DemonsDefault;
import be.thijswouters.Kits.DemonsSkeleton;
import be.thijswouters.Kits.DemonsZombie;
import be.thijswouters.Kits.OrcsArcher;
import be.thijswouters.Kits.OrcsDefault;
import be.thijswouters.Kits.OrcsMiner;
import be.thijswouters.Listeners.EventBlockDestroy;
import be.thijswouters.Scoreboards.GameScoreboard;
import be.thijswouters.Scoreboards.LobbyScoreboard;
import be.thijswouters.Teams.Orcs;
import be.thijswouters.Utils.ArrayLists;
import be.thijswouters.Utils.Chat;
import be.thijswouters.Utils.GameState;

public class LobbyTimer {
	
	public static int time = -1;
	public static boolean started = false;
	
	@SuppressWarnings("deprecation")
	public static void start(){
		started = true;
		time = 30;
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(DemonsCore.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if(time < 0){
					return;
				}
				
				if(time > 30){
					return;
				}
				
				if(time == -1){
					time = -1;
					return;
				}

				if(time == 30){
					Chat.broadcast("Demons", "The game is §e§lstarting§7.");       
				}
				
				if(time == 20){
					Chat.broadcast("Demons", "20 seconds left.");       
				}
				
				if(time <= 30){
					time--;
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
							"§7" + Bukkit.getOnlinePlayers().size()));
					LobbyScoreboard.Players.setScore(0);
				}
				
				if(time == 10){
					Chat.broadcast("Demons", "10 seconds left.");
				}
				
				if(time <= 5 && time != -1 && time != 0){
					Chat.broadcast("Demons", time + " Seconds left.");
				}
				
				if(time == 0){
					GameState.setState(GameState.IN_GAME);
					EventBlockDestroy.health = 30;
					Chat.broadcast("Demons", "The game has been §estarted§7!");
					Chat.broadcast("Demons", "§3Spawnkilling is §eNOT §3allowed! This can result as a §eban§3!");
					GameTimer.start();
					Bukkit.getScheduler().cancelTask(time);
					for(Player p : Bukkit.getOnlinePlayers()){
						if(ArrayLists.teamDemons.contains(p)){	
					        if(Files.kits.getString("Kits.Demons.Default." + p.getName()).equalsIgnoreCase("true"))
					        	DemonsDefault.give(p);
					    
					        if(Files.kits.getString("Kits.Demons.Skeleton." + p.getName()).equalsIgnoreCase("true"))
					        	DemonsSkeleton.give(p);
					        
					        if(Files.kits.getString("Kits.Demons.Zombie." + p.getName()).equalsIgnoreCase("true"))
					        	DemonsZombie.give(p);
					        
							String demonWorldName = Files.locations.getString("Demons.WORLD");
							int demonX = Files.locations.getInt("Demons.X");
							int demonY = Files.locations.getInt("Demons.Y");
							int demonZ = Files.locations.getInt("Demons.Z");
							World demonWORLD = Bukkit.getServer().getWorld(demonWorldName);
							Location demon = new Location(demonWORLD, demonX,demonY, demonZ);
							
							p.teleport(demon);
							p.setScoreboard(GameScoreboard.board);
						}
						
						if(ArrayLists.teamOrcs.contains(p)){
					        if(Files.kits.getString("Kits.Orcs.Default." + p.getName()).equalsIgnoreCase("true"))
					        	OrcsDefault.give(p);
					    
					        if(Files.kits.getString("Kits.Orcs.Miner." + p.getName()).equalsIgnoreCase("true"))
					        	OrcsMiner.give(p);
					    
					        if(Files.kits.getString("Kits.Orcs.Archer." + p.getName()).equalsIgnoreCase("true"))
					        	OrcsArcher.give(p);
					        
							String orcsWorldName = Files.locations.getString("Orcs.WORLD");
							int orcsX = Files.locations.getInt("Orcs.X");
							int orcsY = Files.locations.getInt("Orcs.Y");
							int orcsZ = Files.locations.getInt("Orcs.Z");
							World orcsWORLD = Bukkit.getServer().getWorld(orcsWorldName);
							Location orcs = new Location(orcsWORLD, orcsX, orcsY, orcsZ);
							p.teleport(orcs);
							p.setScoreboard(GameScoreboard.board);
						}
					}
				}
			}
		}, 0L, 20L);
	}
}
