package be.thijswouters.Listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import be.thijswouters.Files.Files;
import be.thijswouters.Inventories.InvKitSelDemons;
import be.thijswouters.Inventories.InvKitSelOrcs;
import be.thijswouters.SQL.Kits;
import be.thijswouters.Utils.Chat;

public class EventInventoryClick implements Listener{
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e){
        if(!(e.getWhoClicked() instanceof Player))
            return;
        
        Player p = (Player) e.getWhoClicked();
        if(p.getGameMode() != GameMode.CREATIVE){
        	e.setCancelled(true);
        }
        
        if(e.getCurrentItem().equals(InvKitSelDemons.selectedDefault())){
        	Files.kits.set("Kits.Demons.Default." + p.getName(), "true");
        	Files.kits.set("Kits.Demons.Skeleton." + p.getName(), "false");
        	Files.kits.set("Kits.Demons.Zombie." + p.getName(), "false");
        	Files.kits.save();
        	Chat.viaOther(p, "Kits", "Selected kit §e§lDefault§7.");
        	p.closeInventory();
        }
        
        if(e.getCurrentItem().equals(InvKitSelDemons.selectedSkeleton())){
        	Files.kits.set("Kits.Demons.Default." + p.getName(), "false");
        	Files.kits.set("Kits.Demons.Skeleton." + p.getName(), "true");
        	Files.kits.set("Kits.Demons.Zombie." + p.getName(), "false");
        	Files.kits.save();
        	Chat.viaOther(p, "Kits", "Selected kit §e§lSkeleton§7.");
        	p.closeInventory();
        }
        	
        if(e.getCurrentItem().equals(InvKitSelDemons.selectedZombie())){
        	Files.kits.set("Kits.Demons.Default." + p.getName(), "false");
        	Files.kits.set("Kits.Demons.Skeleton." + p.getName(), "false");
        	Files.kits.set("Kits.Demons.Zombie." + p.getName(), "true");
        	Files.kits.save();
        	Chat.viaOther(p, "Kits", "Selected kit §e§lZombie§7.");
        	p.closeInventory();
        }
        
        if(e.getCurrentItem().equals(InvKitSelDemons.notSelectedDefault())){
        	Files.kits.set("Kits.Demons.Default." + p.getName(), "true");
        	Files.kits.set("Kits.Demons.Skeleton." + p.getName(), "false");
        	Files.kits.set("Kits.Demons.Zombie." + p.getName(), "false");
        	Files.kits.save();
        	Chat.viaOther(p, "Kits", "Selected kit §e§lDefault§7.");
        	p.closeInventory();
        }
        	
        if(e.getCurrentItem().equals(InvKitSelDemons.notSelectedZombie())){
        	if(Kits.getKitStatus(p.getName(), "dZombie").equalsIgnoreCase("true")){
            	Files.kits.set("Kits.Demons.Default." + p.getName(), "false");
            	Files.kits.set("Kits.Demons.Skeleton." + p.getName(), "false");
            	Files.kits.set("Kits.Demons.Zombie." + p.getName(), "true");
            	Files.kits.save();
            	Chat.viaOther(p, "Kits", "Selected kit §e§lZombie§7.");
            	p.closeInventory();
        	} else {
        		Chat.viaDemons(p, "You haven't bought this kit yet!");
        	}
        }
        
        if(e.getCurrentItem().equals(InvKitSelDemons.notSelectedSkeleton())){
        	if(Kits.getKitStatus(p.getName(), "dSkeleton").equalsIgnoreCase("true")){
            	Files.kits.set("Kits.Demons.Default." + p.getName(), "false");
            	Files.kits.set("Kits.Demons.Skeleton." + p.getName(), "true");
            	Files.kits.set("Kits.Demons.Zombie." + p.getName(), "false");
            	Files.kits.save();
            	Chat.viaOther(p, "Kits", "Selected kit §e§lSkeleton§7.");
            	p.closeInventory();
        	} else {
        		Chat.viaDemons(p, "You haven't bought this kit yet!");
        	}
        }
        
        if(e.getCurrentItem().equals(InvKitSelOrcs.iconSelectedDefault())){
        	Files.kits.set("Kits.Orcs.Default." + p.getName(), "true");
        	Files.kits.set("Kits.Orcs.Miner." + p.getName(), "false");
        	Files.kits.set("Kits.Orcs.Archer." + p.getName(), "false");
        	Files.kits.save();
        	Chat.viaOther(p, "Kits", "Selected kit §e§lDefault§7.");
        	p.closeInventory();
        }
        	
        if(e.getCurrentItem().equals(InvKitSelOrcs.iconSelectedMiner())){
        	if(Kits.getKitStatus(p.getName(), "oMiner").equalsIgnoreCase("true")){
            	Files.kits.set("Kits.Orcs.Default." + p.getName(), "false");
            	Files.kits.set("Kits.Orcs.Miner." + p.getName(), "true");
            	Files.kits.set("Kits.Orcs.Archer." + p.getName(), "false");
            	Files.kits.save();
            	Chat.viaOther(p, "Kits", "Selected kit §e§lMiner§7.");
            	p.closeInventory();
        	} else {
        		Chat.viaDemons(p, "You haven't bought this kit yet!");
        	}
        }
        	
        if(e.getCurrentItem().equals(InvKitSelOrcs.iconSelectedArcher())){ 
        	if(Kits.getKitStatus(p.getName(), "oArcher").equalsIgnoreCase("true")){
            	Files.kits.set("Kits.Orcs.Default." + p.getName(), "false");
            	Files.kits.set("Kits.Orcs.Miner." + p.getName(), "false");
            	Files.kits.set("Kits.Orcs.Archer." + p.getName(), "true");
            	Files.kits.save();
            	Chat.viaOther(p, "Kits", "Selected kit §e§lArcher§7.");
            	p.closeInventory();
        	} else {
        		Chat.viaDemons(p, "You haven't bought this kit yet!");
        	}
        }
        	
        if(e.getCurrentItem().equals(InvKitSelOrcs.iconNotSelectedDefault())){
        	Files.kits.set("Kits.Orcs.Default." + p.getName(), "true");
        	Files.kits.set("Kits.Orcs.Miner." + p.getName(), "false");
        	Files.kits.set("Kits.Orcs.Archer." + p.getName(), "false");
        	Files.kits.save();
        	Chat.viaOther(p, "Kits", "Selected kit §e§lDefault§7.");
        	p.closeInventory();
        }
        	
        if(e.getCurrentItem().equals(InvKitSelOrcs.iconNotSelectedMiner())){
        	if(Kits.getKitStatus(p.getName(), "oMiner").equalsIgnoreCase("true")){
            	Files.kits.set("Kits.Orcs.Default." + p.getName(), "false");
            	Files.kits.set("Kits.Orcs.Miner." + p.getName(), "true");
            	Files.kits.set("Kits.Orcs.Archer." + p.getName(), "false");
            	Files.kits.save();
            	Chat.viaOther(p, "Kits", "Selected kit §e§lMiner§7.");
            	p.closeInventory();
        	} else {
        		Chat.viaDemons(p, "You haven't bought this kit yet!");
        	}
        }
        	
        if(e.getCurrentItem().equals(InvKitSelOrcs.iconNotSelectedArcher())){ 
        	if(Kits.getKitStatus(p.getName(), "oArcher").equalsIgnoreCase("true")){
            	Files.kits.set("Kits.Orcs.Default." + p.getName(), "false");
            	Files.kits.set("Kits.Orcs.Miner." + p.getName(), "false");
            	Files.kits.set("Kits.Orcs.Archer." + p.getName(), "true");
            	Files.kits.save();
            	Chat.viaOther(p, "Kits", "Selected kit §e§lArcher§7.");
            	p.closeInventory();
        	} else {
        		Chat.viaDemons(p, "You haven't bought this kit yet!");
        	}
        }
	}
}
