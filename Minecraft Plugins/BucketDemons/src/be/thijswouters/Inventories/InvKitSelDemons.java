package be.thijswouters.Inventories;

import java.util.ArrayList;

import net.minecraft.server.v1_8_R2.NBTTagCompound;
import net.minecraft.server.v1_8_R2.NBTTagList;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R2.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import be.thijswouters.DemonsCore;
import be.thijswouters.Files.Files;

public class InvKitSelDemons {
	
	public static void open(Player p){
		Inventory inv = Bukkit.createInventory(null, 27, "Demons Kit Selector");
		if(Files.kits.getString("Kits.Demons.Default." + p.getName()).equals("true")){
			inv.setItem(12, addGlow(selectedDefault()));
			inv.setItem(13, notSelectedSkeleton());
			inv.setItem(14, notSelectedZombie());
		}
		
		if(Files.kits.getString("Kits.Demons.Skeleton." + p.getName()).equals("true")){
			inv.setItem(12, notSelectedDefault());
			inv.setItem(13, addGlow(selectedSkeleton()));
			inv.setItem(14, notSelectedZombie());
		}
		
		if(Files.kits.getString("Kits.Demons.Zombie." + p.getName()).equals("true")){
			inv.setItem(12, notSelectedDefault());
			inv.setItem(13, notSelectedSkeleton());
			inv.setItem(14, addGlow(selectedZombie()));
		}
		
		if(Files.kits.getString("Kits.Demons.Default." + p.getName()).equals("false")){
			inv.setItem(12, notSelectedDefault());
		}
		
		if(Files.kits.getString("Kits.Demons.Skeleton." + p.getName()).equals("false")){
			inv.setItem(13, notSelectedSkeleton());
		}
		
		if(Files.kits.getString("Kits.Demons.Zombie." + p.getName()).equals("false")){
			inv.setItem(14, notSelectedZombie());
		}
		p.openInventory(inv);
	}
	
	public static ItemStack notSelectedDefault(){
		ItemStack stack = new ItemStack(Material.WOOD_HOE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eDefault");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §cNot Selected");
		lore.add("§7Cost §6» §eFree");
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Hoe");
		lore.add("§7    » §6Sharpness IV");
		lore.add("§6    - §eDemon Armor");
		lore.add("§6    - §eDemon Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack selectedDefault(){
		ItemStack stack = new ItemStack(Material.WOOD_HOE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eDefault");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §aSelected");
		lore.add("§7Cost §6» §eFree");
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Hoe");
		lore.add("§7    » §6Sharpness IV");
		lore.add("§6    - §eDemon Armor");
		lore.add("§6    - §eDemon Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack notSelectedZombie(){
		ItemStack stack = new ItemStack(Material.ROTTEN_FLESH);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eZombie");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §cNot Selected");
 
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Sword");
		lore.add("§7    » §6Sharpness I");
		lore.add("§6    - §eDemon Armor");
		lore.add("§6    - §eZombie Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack selectedZombie(){
		ItemStack stack = new ItemStack(Material.ROTTEN_FLESH);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eZombie");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §aSelected");
 
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Sword");
		lore.add("§7    » §6Sharpness I");
		lore.add("§6    - §eDemon Armor");
		lore.add("§6    - §eZombie Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack notSelectedSkeleton(){
		ItemStack stack = new ItemStack(Material.BONE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eSkeleton");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §cNot Selected");
 
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Hoe");
		lore.add("§7    » §6Sharpness II");
		lore.add("§6    - §eBow");
		lore.add("§7    » §6Power II");
		lore.add("§6    - §eArrow");
		lore.add("§7    » §632");
		lore.add("§6    - §eDemon Armor");
		lore.add("§6    - §eSkeleton Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack selectedSkeleton(){
		ItemStack stack = new ItemStack(Material.BONE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eSkeleton");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §aSelected");
 
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Hoe");
		lore.add("§7    » §6Sharpness II");
		lore.add("§6    - §eBow");
		lore.add("§7    » §6Power II");
		lore.add("§6    - §eArrow");
		lore.add("§7    » §632");
		lore.add("§6    - §eDemon Armor");
		lore.add("§6    - §eSkeleton Hat");
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
