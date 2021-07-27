package be.thijswouters.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.thijswouters.Schedulers.LobbyTimer;
import be.thijswouters.Utils.Chat;

public class CommandSkipTimer implements CommandExecutor{
	
	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;

		Player p = (Player) sender;
		if(!p.hasPermission("demons.skiptimer")){
			Chat.noPermissions(p);
			return false;
		}
		
		if(LobbyTimer.started == true){
			LobbyTimer.time = 3;
			Chat.broadcast("Demons" ,"The timer has been §e§lskipped§7.");
			return true;
		}
		
		LobbyTimer.start();
		LobbyTimer.time = 3;
		Chat.broadcast("Demons" ,"The timer has been §e§lskipped§7.");
		return false;
	}
}