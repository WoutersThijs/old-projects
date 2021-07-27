package be.thijswouters.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class aKitExample {
	
	public static void give(Player p){
		p.getInventory().clear();
	}
	
	public ItemStack pickaxe(){
		ItemStack stack = new ItemStack(Material.WOOD_PICKAXE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§9Prismarine Breaker");
		meta.spigot().setUnbreakable(true);
		stack.setItemMeta(meta);
		return stack;
	}
}
