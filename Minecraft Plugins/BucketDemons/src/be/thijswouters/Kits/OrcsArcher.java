package be.thijswouters.Kits;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class OrcsArcher {
	
	public static void give(Player p){
		p.getInventory().clear();
		p.getActivePotionEffects().clear();
		p.getInventory().setItem(0, axe());
		p.getInventory().setItem(1, bow());
		p.getInventory().setItem(2, pickaxe());
		p.getInventory().setItem(7, arrow());
		p.getInventory().setItem(8, kitSelector());
		p.getInventory().setChestplate(chest());
		p.getInventory().setLeggings(leggings());
		p.getInventory().setBoots(boots());
	}
	
	public static ItemStack pickaxe(){
		ItemStack stack = new ItemStack(Material.WOOD_PICKAXE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§a§lCore Destroyer");
		meta.spigot().setUnbreakable(true);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack arrow(){
		ItemStack stack = new ItemStack(Material.ARROW, 32);
		ItemMeta meta = stack.getItemMeta();
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack axe(){
		ItemStack stack = new ItemStack(Material.WOOD_AXE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§a§lWooden Battleaxe");
		meta.spigot().setUnbreakable(true);
		meta.spigot().setUnbreakable(true);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack bow(){
		ItemStack stack = new ItemStack(Material.BOW);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§a§lWooden Bow");
		meta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
		meta.spigot().setUnbreakable(true);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack kitSelector(){
		ItemStack stack = new ItemStack(Material.EMERALD);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§a§lKit Selector");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack chest(){
		ItemStack stack = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta meta = (LeatherArmorMeta) stack.getItemMeta();
		meta.setColor(Color.GREEN);
		meta.setDisplayName("§a§lOrc Chestplate");
		meta.spigot().setUnbreakable(true);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack leggings(){
		ItemStack stack = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta meta = (LeatherArmorMeta) stack.getItemMeta();
		meta.setColor(Color.GREEN);
		meta.setDisplayName("§a§lOrc Pants");
		meta.spigot().setUnbreakable(true);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack boots(){
		ItemStack stack = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta meta = (LeatherArmorMeta) stack.getItemMeta();
		meta.setColor(Color.GREEN);
		meta.setDisplayName("§a§lOrc Boots");
		meta.spigot().setUnbreakable(true);
		stack.setItemMeta(meta);
		return stack;
	}
}
