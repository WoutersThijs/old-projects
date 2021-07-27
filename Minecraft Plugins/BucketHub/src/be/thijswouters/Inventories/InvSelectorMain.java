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

public class InvSelectorMain {
	
	public static void open(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "Server Selector");
		
		ItemStack stack = new ItemStack(Material.BOOK);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eBuckets §6» §e" + Buckets.getBuckets(p.getName()));
		stack.setItemMeta(meta);
		
		inv.setItem(13, creative());
		
		inv.setItem(21, kitpvp());
		inv.setItem(22, demons());
		inv.setItem(23, factions());
		
		inv.setItem(31, survival());
		
		inv.setItem(36, site());
		inv.setItem(44, site());
		
		inv.setItem(45, spawn());
		inv.setItem(46, site());
		inv.setItem(49, stack);
		
		inv.setItem(52, site());
		inv.setItem(53, spawn());
		
		p.openInventory(inv);
	}
	
	public static ItemStack survival(){
		ItemStack stack = new ItemStack(Material.WORKBENCH);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eSurvival");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack creative(){
		ItemStack stack = new ItemStack(Material.LEAVES, 1, (short) 3);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eCreative");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack factions(){
		ItemStack stack = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eFactions");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack demons(){
		ItemStack stack = new ItemStack(Material.ENDER_PORTAL_FRAME);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eDemons");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack kitpvp(){
		ItemStack stack = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eKitPvP");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack spawn(){
		ItemStack stack = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eSpawn");
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
}
