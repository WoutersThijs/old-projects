package be.thijswouters.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Team;

import be.thijswouters.Files.Files;
import be.thijswouters.Kits.DemonsDefault;
import be.thijswouters.Kits.OrcsDefault;
import be.thijswouters.Schedulers.LobbyTimer;
import be.thijswouters.Scoreboards.GameScoreboard;
import be.thijswouters.Scoreboards.LobbyScoreboard;
import be.thijswouters.Teams.Demons;
import be.thijswouters.Teams.Orcs;
import be.thijswouters.Utils.ArrayLists;
import be.thijswouters.Utils.Chat;
import be.thijswouters.Utils.GameState;

public class EventPlayerJoin implements Listener {
	
	
	/*public static Location lobby = new Location(Bukkit.getWorld(
			FileLocations.getLocations().getString("Lobby.WORLD")),
			FileLocations.getLocations().getDouble("Lobby.X"),
			FileLocations.getLocations().getDouble("Lobby.Y"),
			FileLocations.getLocations().getDouble("Lobby.Z")); */
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		Files.kits.set("Kits.Orcs.Default." + p.getName(), "true");
		Files.kits.set("Kits.Orcs.Miner." + p.getName(), "false");
		Files.kits.set("Kits.Orcs.Archer." + p.getName(), "false");
		Files.kits.set("Kits.Demons.Default." + p.getName(), "true");
		Files.kits.set("Kits.Demons.Skeleton." + p.getName(), "false");
		Files.kits.set("Kits.Demons.Zombie." + p.getName(), "false");
		Files.kits.save();
		
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
				"§7" + Bukkit.getOnlinePlayers().size() ));
		LobbyScoreboard.Players.setScore(0);
		
		p.getActivePotionEffects().clear();
	    p.setWalkSpeed(0.2F);
		p.setHealth(20);
		p.setFoodLevel(20);
		p.getInventory().clear();
		if(GameState.isState(GameState.IN_GAME)){
			String specWorldName = Files.locations.getString("Spectator.WORLD");
			int specX = Files.locations.getInt("Spectator.X");
			int specY = Files.locations.getInt("Spectator.Y");
			int specZ = Files.locations.getInt("Spectator.Z");
			World specWORLD = Bukkit.getServer().getWorld(specWorldName);
			Location spec = new Location(specWORLD, specX, specY, specZ);
			if(GameState.isState(GameState.IN_GAME)){
				p.teleport(spec);
				e.setJoinMessage("§b» §6Demons §8// §7" + p.getName() + " §3has joined the game as a §espectator§3.");
				p.setScoreboard(GameScoreboard.board);
				Chat.viaOther(p, "Spectator", "The game is already started. You are now spectating.");
				p.setPlayerListName("§7" + p.getName());
				if(p.getGameMode() != GameMode.SPECTATOR)
					p.setGameMode(GameMode.SPECTATOR);
				return;
			}
		}
		p.setScoreboard(LobbyScoreboard.board);
		String lobbyWorldName = Files.locations.getString("Lobby.WORLD");
		int lobbyX = Files.locations.getInt("Lobby.X");
		int lobbyY = Files.locations.getInt("Lobby.Y");
		int lobbyZ = Files.locations.getInt("Lobby.Z");
		World lobbyWORLD = Bukkit.getServer().getWorld(lobbyWorldName);
		Location lobby = new Location(lobbyWORLD, lobbyX, lobbyY, lobbyZ);
		
		p.getInventory().setArmorContents(null);
		
		p.teleport(lobby);
		if(Bukkit.getOnlinePlayers().size() == 4){
			LobbyTimer.start();
		}
		
		if(p.getGameMode() != GameMode.SURVIVAL)
			p.setGameMode(GameMode.SURVIVAL);
		
		LobbyScoreboard.o.getScore(Bukkit.getServer().getOfflinePlayer(
				"§7" + Bukkit.getOnlinePlayers().size()));
		
		if(ArrayLists.teamOrcs.size() == 0){
			e.setJoinMessage("§b» §6Demons §8// §a" + p.getName() + " §3has joined the game. §6(§e" + Bukkit.getOnlinePlayers().size() + "/16§6)");
			Orcs.addPlayer(p);
			p.getInventory().setItem(8, OrcsDefault.kitSelector());
			return;
		}
		
		if(ArrayLists.teamDemons.size() < ArrayLists.teamOrcs.size()){
			e.setJoinMessage("§b» §6Demons §8// §c" + p.getName() + " §3has joined the game. §6(§e" + Bukkit.getOnlinePlayers().size() + "/16§6)");
			p.getInventory().setItem(8, DemonsDefault.kitSelector());
			Demons.addPlayer(p);
			return;
		}
		
		if(ArrayLists.teamDemons.size() == ArrayLists.teamOrcs.size()){
			Orcs.addPlayer(p);
			e.setJoinMessage("§b» §6Demons §8// §a" + p.getName() + " §3has joined the game. §6(§e" + Bukkit.getOnlinePlayers().size() + "/16§6)");
			p.getInventory().setItem(8, OrcsDefault.kitSelector());
			return;
		}
		
		if(ArrayLists.teamOrcs.size() < ArrayLists.teamDemons.size()){
			Orcs.addPlayer(p);
			e.setJoinMessage("§b» §6Demons §8// §a" + p.getName() + " §3has joined the game. §6(§e" + Bukkit.getOnlinePlayers().size() + "/16§6)");
			p.getInventory().setItem(8, OrcsDefault.kitSelector());
			return;
		}
	}

}
