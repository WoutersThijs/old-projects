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
		meta.setDisplayName("žeDefault");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("ž7Status ž6╗ žcNot Selected");
		lore.add("ž7Cost ž6╗ žeFree");
		lore.add("ž7Contains ž6╗");
		lore.add("ž6    - žeWooden Hoe");
		lore.add("ž7    ╗ ž6Sharpness IV");
		lore.add("ž6    - žeDemon Armor");
		lore.add("ž6    - žeDemon Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack selectedDefault(){
		ItemStack stack = new ItemStack(Material.WOOD_HOE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("žeDefault");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("ž7Status ž6╗ žaSelected");
		lore.add("ž7Cost ž6╗ žeFree");
		lore.add("ž7Contains ž6╗");
		lore.add("ž6    - žeWooden Hoe");
		lore.add("ž7    ╗ ž6Sharpness IV");
		lore.add("ž6    - žeDemon Armor");
		lore.add("ž6    - žeDemon Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack notSelectedZombie(){
		ItemStack stack = new ItemStack(Material.ROTTEN_FLESH);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("žeZombie");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("ž7Status ž6╗ žcNot Selected");
 
		lore.add("ž7Contains ž6╗");
		lore.add("ž6    - žeWooden Sword");
		lore.add("ž7    ╗ ž6Sharpness I");
		lore.add("ž6    - žeDemon Armor");
		lore.add("ž6    - žeZombie Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack selectedZombie(){
		ItemStack stack = new ItemStack(Material.ROTTEN_FLESH);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("žeZombie");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("ž7Status ž6╗ žaSelected");
 
		lore.add("ž7Contains ž6╗");
		lore.add("ž6    - žeWooden Sword");
		lore.add("ž7    ╗ ž6Sharpness I");
		lore.add("ž6    - žeDemon Armor");
		lore.add("ž6    - žeZombie Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack notSelectedSkeleton(){
		ItemStack stack = new ItemStack(Material.BONE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("žeSkeleton");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("ž7Status ž6╗ žcNot Selected");
 
		lore.add("ž7Contains ž6╗");
		lore.add("ž6    - žeWooden Hoe");
		lore.add("ž7    ╗ ž6Sharpness II");
		lore.add("ž6    - žeBow");
		lore.add("ž7    ╗ ž6Power II");
		lore.add("ž6    - žeArrow");
		lore.add("ž7    ╗ ž632");
		lore.add("ž6    - žeDemon Armor");
		lore.add("ž6    - žeSkeleton Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack selectedSkeleton(){
		ItemStack stack = new ItemStack(Material.BONE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("žeSkeleton");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("ž7Status ž6╗ žaSelected");
 
		lore.add("ž7Contains ž6╗");
		lore.add("ž6    - žeWooden Hoe");
		lore.add("ž7    ╗ ž6Sharpness II");
		lore.add("ž6    - žeBow");
		lore.add("ž7    ╗ ž6Power II");
		lore.add("ž6    - žeArrow");
		lore.add("ž7    ╗ ž632");
		lore.add("ž6    - žeDemon Armor");
		lore.add("ž6    - žeSkeleton Hat");
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
