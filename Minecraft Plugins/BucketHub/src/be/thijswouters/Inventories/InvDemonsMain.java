package be.thijswouters.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import be.thijswouters.SQL.Buckets;

public class InvDemonsMain {
	
	public static void open(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "Demons");
		
		ItemStack stack = new ItemStack(Material.BOOK);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eBuckets §6» §e" + Buckets.getBuckets(p.getName()));
		stack.setItemMeta(meta);
		
		inv.setItem(21, servers());
		inv.setItem(23, shop());
		
		inv.setItem(36, site());
		inv.setItem(44, site());
		
		inv.setItem(45, back());
		inv.setItem(46, site());
		inv.setItem(49, stack);
		
		inv.setItem(52, site());
		inv.setItem(53, back());
		
		p.openInventory(inv);
	}
	
	public static ItemStack back(){
		ItemStack stack = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eBack");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack site(){
		ItemStack stack = new ItemStack(Material.FIREWORK_CHARGE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eWebsite");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack shop(){
		ItemStack stack = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eShop");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack servers(){
		ItemStack stack = new ItemStack(Material.ENDER_PORTAL_FRAME);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eServers");
		stack.setItemMeta(meta);
		return stack;
	}
}
