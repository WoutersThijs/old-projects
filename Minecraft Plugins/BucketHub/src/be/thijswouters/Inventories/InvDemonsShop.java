package be.thijswouters.Inventories;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.v1_8_R2.NBTTagCompound;
import net.minecraft.server.v1_8_R2.NBTTagList;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.craftbukkit.v1_8_R2.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import be.thijswouters.SQL.Buckets;
import be.thijswouters.SQL.Kits;

public class InvDemonsShop {
	
	public static void open(Player p){
		Inventory inv = Bukkit.createInventory(null, 54, "Demons - Shop");
		
		Kits.setKitStatus(p.getName(), "dDefault", "true");
		Kits.setKitStatus(p.getName(), "oDefault", "true");
		
		ItemStack stack = new ItemStack(Material.BOOK);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eBuckets §6» §e" + Buckets.getBuckets(p.getName()));
		stack.setItemMeta(meta);
		
		inv.setItem(0, demonsIcon());
		inv.setItem(8, demonsIcon());
		inv.setItem(18, orcsIcon());
		inv.setItem(26, orcsIcon());
		if(Kits.getKitStatus(p.getName(), "dDefault").equalsIgnoreCase("true")){
			inv.setItem(3, addGlow(UnlockedDemonsDefault()));
		} else {
			inv.setItem(3, LockedDemonsDefault());
		}
		
		if(Kits.getKitStatus(p.getName(), "dZombie").equalsIgnoreCase("true")){
			inv.setItem(4, addGlow(UnlockedDemonsZombie()));
		} else {
			inv.setItem(4, LockedDemonsZombie());
		}
		
		if(Kits.getKitStatus(p.getName(), "dSkeleton").equalsIgnoreCase("true")){
			inv.setItem(5, addGlow(UnlockedDemonsSkeleton()));
		} else {
			inv.setItem(5, LockedDemonsSkeleton());
		}
		
		if(Kits.getKitStatus(p.getName(), "oDefault").equalsIgnoreCase("true")){
			inv.setItem(21, addGlow(UnlockedOrcsDefault()));
		} else {
			inv.setItem(21, LockedOrcsDefault());
		}
		
		if(Kits.getKitStatus(p.getName(), "oMiner").equalsIgnoreCase("true")){
			inv.setItem(22, addGlow(UnlockedOrcsMiner()));
		} else {
			inv.setItem(22, LockedOrcsMiner());
		}
		
		if(Kits.getKitStatus(p.getName(), "oArcher").equalsIgnoreCase("true")){
			inv.setItem(23, addGlow(UnlockedOrcsArcher()));
		} else {
			inv.setItem(23, LockedOrcsArcher());
		}
		
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
	
	public static ItemStack LockedDemonsDefault(){
		ItemStack stack = new ItemStack(Material.WOOD_HOE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eDefault");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §cLocked");
		lore.add("§7Cost §6» §eFree");
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Hoe");
		lore.add("§7    » §6Sharpness III");
		lore.add("§6    - §eDemon Armor");
		lore.add("§6    - §eDemon Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack UnlockedDemonsDefault(){
		ItemStack stack = new ItemStack(Material.WOOD_HOE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eDefault");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §aUnlocked");
		lore.add("§7Cost §6» §eFree");
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Hoe");
		lore.add("§7    » §6Sharpness III");
		lore.add("§6    - §eDemon Armor");
		lore.add("§6    - §eDemon Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack LockedDemonsZombie(){
		ItemStack stack = new ItemStack(Material.ROTTEN_FLESH);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eZombie");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §cLocked");
		lore.add("§7Cost §6» §e2.500");
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Sword");
		lore.add("§7    » §6Sharpness I");
		lore.add("§6    - §eDemon Armor");
		lore.add("§6    - §eZombie Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack UnlockedDemonsZombie(){
		ItemStack stack = new ItemStack(Material.ROTTEN_FLESH);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eZombie");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §aUnlocked");
		lore.add("§7Cost §6» §e2.500");
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Sword");
		lore.add("§7    » §6Sharpness I");
		lore.add("§6    - §eDemon Armor");
		lore.add("§6    - §eZombie Hat");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack LockedDemonsSkeleton(){
		ItemStack stack = new ItemStack(Material.BONE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eSkeleton");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §cLocked");
		lore.add("§7Cost §6» §e3.000");
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
	
	public static ItemStack UnlockedDemonsSkeleton(){
		ItemStack stack = new ItemStack(Material.BONE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eSkeleton");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §aUnlocked");
		lore.add("§7Cost §6» §e3.000");
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
	
	public static ItemStack LockedOrcsDefault(){
		ItemStack stack = new ItemStack(Material.WOOD_SWORD);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eDefault");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §cLocked");
		lore.add("§7Cost §6» §eFree");
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Sword");
		lore.add("§6    - §eWooden Pickaxe");
		lore.add("§6    - §eOrc Armor");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack UnlockedOrcsDefault(){
		ItemStack stack = new ItemStack(Material.WOOD_SWORD);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eDefault");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §aUnlocked");
		lore.add("§7Cost §6» §eFree");
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Sword");
		lore.add("§6    - §eWooden Pickaxe");
		lore.add("§6    - §eOrc Armor");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack LockedOrcsMiner(){
		ItemStack stack = new ItemStack(Material.STONE_PICKAXE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eMiner");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §cLocked");
		lore.add("§7Cost §6» §e2.500");
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Axe");
		lore.add("§6    - §eStone Pickaxe");
		lore.add("§6    - §eOrc Armor");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack UnlockedOrcsMiner(){
		ItemStack stack = new ItemStack(Material.STONE_PICKAXE);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eMiner");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §aUnlocked");
		lore.add("§7Cost §6» §e2.500");
		lore.add("§7Contains §6»");
		lore.add("§6    - §eWooden Axe");
		lore.add("§6    - §eStone Pickaxe");
		lore.add("§6    - §eOrc Armor");
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}

	public static ItemStack LockedOrcsArcher(){
		ItemStack stack = new ItemStack(Material.ARROW);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eArcher");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §cLocked");
		lore.add("§7Cost §6» §e3.000");
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
	
	public static ItemStack UnlockedOrcsArcher(){
		ItemStack stack = new ItemStack(Material.ARROW);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("§eArcher");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Status §6» §aUnlocked");
		lore.add("§7Cost §6» §e3.000");
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
	
	public static ItemStack orcsIcon(){
		ItemStack stack = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta meta = (LeatherArmorMeta) stack.getItemMeta();
		meta.setColor(Color.GREEN);
		meta.setDisplayName("§eOrc Kits");
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack demonsIcon(){
		ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta meta = (SkullMeta) stack.getItemMeta();
		meta.setOwner("Clear");
		meta.setDisplayName("§eDemon Kits");
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
