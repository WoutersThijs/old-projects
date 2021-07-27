package be.thijswouters.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.thijswouters.Files.Files;
import be.thijswouters.Kits.DemonsDefault;
import be.thijswouters.Kits.DemonsSkeleton;
import be.thijswouters.Kits.DemonsZombie;
import be.thijswouters.Kits.OrcsArcher;
import be.thijswouters.Kits.OrcsDefault;
import be.thijswouters.Kits.OrcsMiner;
import be.thijswouters.SQL.State;
import be.thijswouters.Teams.Demons;
import be.thijswouters.Teams.Orcs;
import be.thijswouters.Utils.ArrayLists;
import be.thijswouters.Utils.Chat;
import be.thijswouters.Utils.GameState;

public class CommandSwapTeam implements CommandExecutor{
	
	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!(sender instanceof Player))
			return false;

		Player p = (Player) sender;
		if(!p.hasPermission("d:gemons.swapteam")){
			Chat.noPermissions(p);
			return false;
		}
		p.sendMessage(State.getState("One"));
		if(ArrayLists.teamDemons.contains(p)){
			Demons.removePlayer(p);
			Orcs.addPlayer(p);
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
			Files.kits.set("Kits.Orcs.Default." + p.getName(), "true");
			p.getInventory().setItem(8, OrcsDefault.kitSelector());
			if(GameState.isState(GameState.IN_GAME)){
			    if(Files.kits.getString("Kits.Orcs.Default." + p.getName()).equalsIgnoreCase("true"))
			    	OrcsDefault.give(p);
			    if(Files.kits.getString("Kits.Orcs.Miner." + p.getName()).equalsIgnoreCase("true"))
			    	OrcsMiner.give(p);
			    if(Files.kits.getString("Kits.Orcs.Archer." + p.getName()).equalsIgnoreCase("true"))
				    OrcsArcher.give(p);
			}
			return true;
		}
		
		if(ArrayLists.teamOrcs.contains(p)){
			Orcs.removePlayer(p);
			Demons.addPlayer(p);
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
			Files.kits.set("Kits.Demons.Default." + p.getName(), "true");
			p.getInventory().setItem(8, DemonsDefault.kitSelector());
			if(GameState.isState(GameState.IN_GAME)){
		    	if(Files.kits.getString("Kits.Demons.Default." + p.getName()).equalsIgnoreCase("true"))
				    DemonsDefault.give(p);
			    if(Files.kits.getString("Kits.Demons.Zombie." + p.getName()).equalsIgnoreCase("true"))
				    DemonsZombie.give(p);
			    if(Files.kits.getString("Kits.Demons.Skeleton." + p.getName()).equalsIgnoreCase("true"))
				    DemonsSkeleton.give(p);
			}
			return true;
		}
		return false;
	}
}