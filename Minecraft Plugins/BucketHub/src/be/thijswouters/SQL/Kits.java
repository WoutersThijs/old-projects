package be.thijswouters.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import be.thijswouters.Hub;

public class Kits {
	
	public static synchronized boolean playerExists(String name){
		
		try{
			PreparedStatement sql = MySQL.con.prepareStatement("SELECT * FROM Kits WHERE Player= '" 
		            + name + "'");
			
			ResultSet rs = sql.executeQuery();
		      
			if(rs.next()){
				return rs.getString("Player") != null;
			}
			
			rs.close();
			sql.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static void createPlayer(String name){
		if(!(playerExists(name))){
			Hub.getInstance().mysql.update("INSERT INTO Kits(Player, dDefault, dZombie, dSkeleton, oDefault, oMiner, oArcher)"
					+ " VALUES ('" + name + "', 'true', 'false', 'false', 'true', 'false', 'false');");
		}
	}
	
	public static String getKitStatus(String player, String kit){
		String i = "false";
		if(playerExists(player)){
			try{
				ResultSet rs = Hub.getInstance().mysql.query("SELECT " + kit + " FROM Kits WHERE Player = '"
						+ player + "'");
                if ((!rs.next()));
                i = rs.getString(kit);
			} catch (SQLException e){
				e.printStackTrace();
			}
		} else {
			createPlayer(player);
			getKitStatus(player, kit);
		}
		return i;
	}
	
	public static void setKitStatus(String player, String kit, String status){
		if(playerExists(player)){
			Hub.getInstance().mysql.update("UPDATE Kits SET " + kit + " = '" + status + "' WHERE Player= '"
                    + player + "';");
		} else {
			createPlayer(player);
			setKitStatus(player, kit, status);
		}
	}
}
