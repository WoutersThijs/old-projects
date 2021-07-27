package be.thijswouters.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import be.thijswouters.Files.Files;
import be.thijswouters.Utils.Chat;
import be.thijswouters.Utils.GameState;

public class EventLogin implements Listener{
	
	@EventHandler
	public void login(PlayerLoginEvent e){
		Player p = e.getPlayer();
		
		if(GameState.isState(GameState.AFTER_GAME))
			e.setResult(Result.KICK_OTHER);
		e.setKickMessage("§b» §6Demons §8// §3The game is §e§lrestarting§7.");
	}
}
