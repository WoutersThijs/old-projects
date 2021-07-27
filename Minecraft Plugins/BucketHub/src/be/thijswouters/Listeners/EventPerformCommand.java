package be.thijswouters.Listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class EventPerformCommand implements Listener {

	@EventHandler
	public void event3PreCommand(PlayerCommandPreprocessEvent event) {
		String message = event.getMessage();
		Player player = event.getPlayer();
		List<String> overridenCommands = new ArrayList<String>();
		overridenCommands.add("/plugins");
		overridenCommands.add("/pl");
		if (overridenCommands.contains(message)) {
			event.setCancelled(true);
			player.sendMessage("Plugins (1): §aBucketHub");
			return;
		}
	}
}
