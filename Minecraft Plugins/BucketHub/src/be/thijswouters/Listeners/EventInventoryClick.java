package be.thijswouters.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import be.thijswouters.Hub;
import be.thijswouters.Inventories.InvDemonsMain;
import be.thijswouters.Inventories.InvDemonsServers;
import be.thijswouters.Inventories.InvDemonsShop;
import be.thijswouters.Inventories.InvSelectorMain;
import be.thijswouters.SQL.Buckets;
import be.thijswouters.SQL.Kits;
import be.thijswouters.Utils.Chat;

public class EventInventoryClick implements Listener{
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if(!(e.getWhoClicked() instanceof Player))
			return;
		
		Player p = (Player) e.getWhoClicked();
		
		if(p.getGameMode() != GameMode.CREATIVE)
			e.setCancelled(true);
		
		if(e.getCurrentItem().equals(InvDemonsMain.servers())){
			p.closeInventory();
			InvDemonsServers.open(p);
		}
		
		if(e.getCurrentItem().equals(InvSelectorMain.demons())){
			p.closeInventory();
			InvDemonsMain.open(p);
		}
		
		if(e.getCurrentItem().equals(InvDemonsMain.site()))
			p.closeInventory();
		
		if(e.getCurrentItem().equals(InvDemonsMain.back())){
			p.closeInventory();
	        InvSelectorMain.open(p);
		}
		
		if(e.getCurrentItem().equals(InvDemonsServers.site()))
			p.closeInventory();
		
		if(e.getCurrentItem().equals(InvDemonsServers.back())){
			p.closeInventory();
		    InvDemonsMain.open(p);
		}
		
		if(e.getCurrentItem().equals(InvDemonsMain.shop())){
			if(!Kits.playerExists(p.getName())){
			    Kits.createPlayer(p.getName());
		    }
			p.closeInventory();
	        InvDemonsShop.open(p);
		}
		
		if(e.getCurrentItem().equals(InvDemonsShop.LockedDemonsZombie())){
			if(Buckets.getBuckets(p.getName()) >= 2500){
				Buckets.removeBuckets(p.getName(), 2500);
				Kits.setKitStatus(p.getName(), "dZombie", "true");
				p.closeInventory();
				Chat.viaOther(p, "Shop", "You've bought kit §eZombie§3.");
			} else {
				Chat.viaOther(p, "Shop", "You don't have enough buckets to buy this!");
			}
		}
		
		if(e.getCurrentItem().equals(InvDemonsShop.LockedDemonsSkeleton())){
			if(Buckets.getBuckets(p.getName()) >= 3000){
				Buckets.removeBuckets(p.getName(), 3000);
				Kits.setKitStatus(p.getName(), "dSkeleton", "true");
				p.closeInventory();
				Chat.viaOther(p, "Shop", "You've bought kit §eSkeleton§3.");
			} else {
				Chat.viaOther(p, "Shop", "You don't have enough buckets to buy this!");
			}
		}
		
		if(e.getCurrentItem().equals(InvDemonsShop.LockedOrcsMiner())){
			if(Buckets.getBuckets(p.getName()) >= 2500){
				Buckets.removeBuckets(p.getName(), 2500);
				Kits.setKitStatus(p.getName(), "oMiner", "true");
				p.closeInventory();
				Chat.viaOther(p, "Shop", "You've bought kit §eMiner§3.");
			} else {
				Chat.viaOther(p, "Shop", "You don't have enough buckets to buy this!");
			}
		}
		
		if(e.getCurrentItem().equals(InvDemonsShop.LockedOrcsArcher())){
			if(Buckets.getBuckets(p.getName()) >= 3000){
				Buckets.removeBuckets(p.getName(), 3000);
				Kits.setKitStatus(p.getName(), "oArcher", "true");
				p.closeInventory();
				Chat.viaOther(p, "Shop", "You've bought kit §eArcher§3.");
			} else {
				Chat.viaOther(p, "Shop", "You don't have enough buckets to buy this!");
			}
		}
		
		if(e.getCurrentItem().equals(InvDemonsServers.G1())){
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("DemonsGame1"); 
            p.sendPluginMessage(Hub.getInstance(), "BungeeCord", out.toByteArray());
		}
		
		if(e.getCurrentItem().equals(InvDemonsServers.G2())){
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("DemonsGame2"); 
            p.sendPluginMessage(Hub.getInstance(), "BungeeCord", out.toByteArray());
		}
		
		if(e.getCurrentItem().equals(InvSelectorMain.creative())){
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("Creative"); 
            p.sendPluginMessage(Hub.getInstance(), "BungeeCord", out.toByteArray());
		}
		
		if(e.getCurrentItem().equals(InvSelectorMain.survival())){
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("Survival"); 
            p.sendPluginMessage(Hub.getInstance(), "BungeeCord", out.toByteArray());
		}
		
		if(e.getCurrentItem().equals(InvSelectorMain.factions())){
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("Factions"); 
            p.sendPluginMessage(Hub.getInstance(), "BungeeCord", out.toByteArray());
		}
		
		if(e.getCurrentItem().equals(InvSelectorMain.kitpvp())){
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF("KitPvP"); 
            p.sendPluginMessage(Hub.getInstance(), "BungeeCord", out.toByteArray());
		}
		
		if(e.getCurrentItem().equals(InvSelectorMain.site()))
	    	Chat.viaOther(p, "Website", "http://bucket-craft.net/");
		
		if(e.getCurrentItem().equals(InvSelectorMain.spawn())){
	    	Location loc = new Location(Bukkit.getWorld("Bug"), 245.500, 169.00000, -70.500);
	    	p.teleport(loc);
		}
		
		if(e.getCurrentItem().equals(InvDemonsMain.back())){
			p.closeInventory();
			InvSelectorMain.open(p);
		}
	}
}
