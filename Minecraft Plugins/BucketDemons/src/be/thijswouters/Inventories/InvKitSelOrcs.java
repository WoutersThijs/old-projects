package be.thijswouters.Inventories;

import java.util.ArrayList;

import net.minecraft.server.v1_8_R2.NBTTagCompound;
import net.minecraft.server.v1_8_R2.NBTTagList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R2.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import be.thijswouters.Files.Files;

public class InvKitSelOrcs {
	
	public static void open(Player p){
		Inventory inv = Bukkit.createInventory(null, 27, "Orcs Kit Selector");
		if(Files.kits.getString("Kits.Orcs.Default." + p.getName()).equals("true")){
			inv.setItem(12, addGlow(iconSelectedDefault()));
			inv.setItem(13, iconNotSelectedMiner());
			inv.setItem(14, iconNotSelectedArcher());
		}
		
		if(Files.kits.getString("Kits.Orcs.Miner." + p.getName()).equals("true")){
			inv.setItem(12, iconSelectedDefault());
			inv.setItem(13, addGlow(iconSelectedMiner()));
			inv.setItem(14, iconNotSelectedArcher());
		}
		
		if(Files.kits.getString("Kits.Orcs.Archer." + p.getName()).equals("true")){
			inv.setItem(12, iconSelectedDefault());
			inv.setItem(13, iconNotSelectedMiner());
			inv.setItem(14, addGlow(iconSelectedArcher()));
		}
		
		if(Files.kits.getString("Kits.Orcs.Default." + p.getName()).equals("false")){
			inv.setItem(12, iconNotSelectedDefault());
		}
		
		if(Files.kits.getString("Kits.Orcs.Miner." + p.getName()).equals("false")){
			inv.setItem(13, iconNotSelectedMiner());
		}
		
		if(Files.kits.getString("Kits.Orcs.Archer." + p.getName()).equals("false")){
			inv.setItem(14, iconNotSelectedArcher());
		}
		p.openInventory(inv);
	}
	
	public static ItemStack iconNotSelectedDefault(){
		ItemStack stack = new ItemStack(Material.WOOD_SWORD);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eDefault");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §cNot Selected");
		lore.add("§7Cost §6» §eFree");
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Sword");
		lore.add("§6    - §eWooden Pickaxe");
		lore.add("§6    - §eOrc Armor");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack iconSelectedDefault(){
		ItemStack stack = new ItemStack(Material.WOOD_SWORD);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eDefault");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §aSelected");
		lore.add("§7Cost §6» §eFree");
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Sword");
		lore.add("§6    - §eWooden Pickaxe");
		lore.add("§6    - §eOrc Armor");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack iconNotSelectedMiner(){
		ItemStack stack = new ItemStack(Material.STONE_PICKAXE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eMiner");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §cNot Selected");

		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Axe");
		lore.add("§6    - §eStone Pickaxe");
		lore.add("§6    - §eOrc Armor");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack iconSelectedMiner(){
		ItemStack stack = new ItemStack(Material.STONE_PICKAXE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eMiner");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §aSelected");

		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Axe");
		lore.add("§6    - §eStone Pickaxe");
		lore.add("§6    - §eOrc Armor");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}

	public static ItemStack iconNotSelectedArcher(){
		ItemStack stack = new ItemStack(Material.ARROW);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eArcher");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §cNot Selected");

		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Axe");
		lore.add("§6    - §eWooden Pickaxe");
		lore.add("§6    - §eBow");
		lore.add("§7    » §6Power II");
		lore.add("§6    - §eArrow");
		lore.add("§7    » §632");
		lore.add("§6    - §eOrc Armor");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack iconSelectedArcher(){
		ItemStack stack = new ItemStack(Material.ARROW);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eArcher");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §aSelected");

		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Axe");
		lore.add("§6    - §eWooden Pickaxe");
		lore.add("§6    - §eBow");
		lore.add("§7    » §6Power II");
		lore.add("§6    - §eArrow");
		lore.add("§7    » §632");
		lore.add("§6    - §eOrc Armor");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack addGlow(ItemStack item){
		net.minecraft.server.v1_8_R2.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
		NBTTagCompound nbt = nmsItem.getTag() == null ? new NBTTagCompound() : nmsItem.getTag();
		NBTTagList ench = new NBTTagList();
		nbt.set("ench", ench);
		nmsItem.setTag(nbt);
		return CraftItemStack.asBukkitCopy(nmsItem);
		
	}
}
