package be.thijswouters.Kits;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DemonsZombie {
	
	public static void give(Player p){
		p.getActivePotionEffects().clear();
		p.getInventory().clear();
		p.getInventory().setItem(0, scepter());
		p.getInventory().setItem(8, kitSelector());
		p.getInventory().setHelmet(hat());
		p.getInventory().setChestplate(chest());
		p.getInventory().setLeggings(leggings());
		p.getInventory().setBoots(boots());
	}
	
	public static ItemStack scepter(){
		ItemStack stack = new ItemStack(Material.WOOD_SWORD);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§c§lBroken Sword");
		meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		meta.spigot().setUnbreakable(true);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack kitSelector(){
		ItemStack stack = new ItemStack(Material.EMERALD);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§c§lKit Selector");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack hat(){
		ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta meta = (SkullMeta) stack.getItemMeta();
		meta.setOwner("MHF_Zombie");
		meta.setDisplayName("§c§lDemon Hat");
		meta.spigot().setUnbreakable(true);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack chest(){
		ItemStack stack = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta meta = (LeatherArmorMeta) stack.getItemMeta();
		meta.setColor(Color.BLACK);
		meta.setDisplayName("§c§lDemon Chestplate");
		meta.spigot().setUnbreakable(true);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack leggings(){
		ItemStack stack = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta meta = (LeatherArmorMeta) stack.getItemMeta();
		meta.setColor(Color.BLACK);
		meta.setDisplayName("§c§lDemon Pants");
		meta.spigot().setUnbreakable(true);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack boots(){
		ItemStack stack = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta meta = (LeatherArmorMeta) stack.getItemMeta();
		meta.setColor(Color.BLACK);
		meta.setDisplayName("§c§lDemon Boots");
		meta.spigot().setUnbreakable(true);
		stack.setItemMeta(meta);
		return stack;
	}
}
