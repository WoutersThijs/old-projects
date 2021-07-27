package be.thijswouters.Listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class EventCommand implements Listener {

	@EventHandler
	public void event3PreCommand(PlayerCommandPreprocessEvent event) {
		String message = event.getMessage();
		Player player = event.getPlayer();
		List<String> overridenCommands = new ArrayList<String>();
		overridenCommands.add("/plugins");
		overridenCommands.add("/pl");
		if (overridenCommands.contains(message)) {
			event.setCancelled(true);
			player.sendMessage("Plugins (1): §aDemons");
			return;
		}
		
		String d = event.getMessage();
		Player p2 = event.getPlayer();
		List<String> o2 = new ArrayList<String>();
		o2.add("/?");
		o2.add("/help");
		if (o2.contains(d)) {
			event.setCancelled(true);
			p2.sendMessage("§b» §6ORCS §8// §3As an &eOrc §3you have to destroy the §eEnder Core §3using the §eCore Destroyer§3."
					+ " The §eCore §3is textured as an §eEnd Stone§3."
					+ " It is located §eunderneath the big tower§3 on the §eDemons §3side.");
			
			p2.sendMessage("");
			
			p2.sendMessage("§b» §6DEMONS §8// §3As a §eDemon §3you have to protect the §eEnder Core§3."
					+ " After §e10 minutes §3of the core not been destroyed you §ewin §3the game."
					+ " For more information about it's location read the §eOrcs §3info.");
			return;
		}
	}
}
