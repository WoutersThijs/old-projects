package be.thijswouters.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.thijswouters.Schedulers.LobbyTimer;
import be.thijswouters.Utils.Chat;

public class CommandStart implements CommandExecutor{
	
	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;

		Player p = (Player) sender;
		if(!p.hasPermission("demons.start")){
			Chat.noPermissions(p);
			return false;
		}
		
		LobbyTimer.start();
		return false;
	}
}