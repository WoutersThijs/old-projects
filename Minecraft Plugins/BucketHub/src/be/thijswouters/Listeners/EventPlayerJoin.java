package be.thijswouters.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import be.thijswouters.Hub;
import be.thijswouters.Utils.Effects;
import be.thijswouters.Utils.ParticleEffect;

public class EventPlayerJoin implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		e.setJoinMessage("");
    	Location loc = new Location(Bukkit.getWorld("Bug"), 245.500, 169.00000, -70.500);
    	p.teleport(loc);
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.getInventory().setItem(0, vote());
		p.getInventory().setItem(1, store());
		p.getInventory().setItem(4, selector());
		p.getInventory().setItem(7, vanity());
		p.getInventory().setItem(8, gadget());
		if(p.hasPermission("particle.join")){
			Effects.joinEffect(p);
		}
	}
	
	public static ItemStack vanity(){
		ItemStack stack = new ItemStack(Material.DIAMOND);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§e§lVanity §r§e(Coming Soon)");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack vote(){
		ItemStack stack = new ItemStack(Material.PAPER);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§e§lVote");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack store(){
		ItemStack stack = new ItemStack(Material.EMERALD);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§e§lStore");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack selector(){
		ItemStack stack = new ItemStack(Material.COMPASS);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§e§lServer Selector");
		stack.setItemMeta(meta);
		return stack;
	}
	
    public static ItemStack gadget(){
        ItemStack stack = new ItemStack(Material.INK_SACK, 1, (short) 8);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName("§7Reserved For Gadgets");
        stack.setItemMeta(meta);
        return stack;
    }
}
