package be.thijswouters.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import be.thijswouters.Inventories.InvKitSelDemons;
import be.thijswouters.Inventories.InvKitSelOrcs;
import be.thijswouters.Kits.DemonsDefault;
import be.thijswouters.Kits.OrcsDefault;

public class EventPlayerInteract implements Listener{

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getClickedBlock().getType() == Material.FIRE)
        	e.setCancelled(true);
        
        if(e.getAction().equals(Action.PHYSICAL))
        	return;
        
        if(p.getItemInHand().equals(OrcsDefault.kitSelector()))
            InvKitSelOrcs.open(p);
        
        if(p.getItemInHand().equals(DemonsDefault.kitSelector()))
            InvKitSelDemons.open(p);
    }
}
