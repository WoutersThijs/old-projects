package be.thijswouters.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import be.thijswouters.Utils.Chat;

public class CommandTeleport implements CommandExecutor {

	@SuppressWarnings({ "deprecation", "null" })
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;

		Player p = (Player) sender;
		if (!p.hasPermission("bucketcraft.command.teleport")) {
			Chat.noPermissions(p);
			return false;
		}
		if (args.length == 0) {
			Chat.viaSystem(p, "You didn't specify a player!");
			return false;
		}

		if (args.length == 1 && !(args.length >= 2)) {
			Player targetPlayer = Bukkit.getPlayer(args[0]);
			if (targetPlayer == null) {
				Chat.viaSystem(p, "Couldn't find the player §a" + args[0]
						+ "§7!");
				return false;
			}
			p.teleport(targetPlayer.getLocation());
			Chat.viaOther(p, "Teleport", "You've been teleported to §a"
					+ targetPlayer.getName() + "§7!");
			return true;
		}

		if (args.length == 2 && !(args.length >= 3)) {
			Player targetPlayer = Bukkit.getPlayer(args[0]);
			Player targetPlayer2 = Bukkit.getPlayer(args[1]);
			if (targetPlayer == null) {
				Chat.viaSystem(p, "Couldn't find the player §a" + args[0]
						+ "§7!");
				return false;
			}

			if (targetPlayer2 == null) {
				Chat.viaSystem(p, "Couldn't find the player §a" + args[1]
						+ "§7!");
				return false;
			}

			targetPlayer.teleport(targetPlayer2.getLocation());
			Chat.viaOther(p, "Teleport", "You've teleported §a" + args[0]
					+ " §7 to §a" + args[1] + "§7!");
			
			Chat.viaOther(targetPlayer, "Teleport", "You've been teleported to §a" + targetPlayer2.getName() + "§7!");
			return true;
		}

		if (args.length >= 3) {
			Chat.toMuchArgs(p);
			return false;
		}
		return false;
	}

}
