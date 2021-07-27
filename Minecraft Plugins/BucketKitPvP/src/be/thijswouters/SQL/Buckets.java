package be.thijswouters.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.thijswouters.KitPvP;

public class Buckets {

	public static synchronized boolean playerExists(String name){
		
		try{
			PreparedStatement sql = MySQL.con.prepareStatement("SELECT * FROM Buckets WHERE NAME= '" 
		            + name + "'");
			
			ResultSet rs = sql.executeQuery();
		      
			if(rs.next()){
				return rs.getString("name") != null;
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
			KitPvP.getInstance().mysql.update("INSERT INTO Buckets(NAME, BUCKETS) VALUES ('" + name + "', '0');");
		}
	}
	
	public static Integer getBuckets(String name){
		Integer i = 0;
		if(playerExists(name)){
			try{
				ResultSet rs = KitPvP.getInstance().mysql.query("SELECT * FROM Buckets WHERE NAME = '"
						+ name + "'");
                if ((!rs.next()));
                i = rs.getInt("BUCKETS");
			} catch (SQLException e){
				e.printStackTrace();
			}
		} else {
			createPlayer(name);
			getBuckets(name);
		}
		return i;
	}
	
	public static void setBuckets(String name, Integer i){
		if(playerExists(name)){
			KitPvP.getInstance().mysql.update("UPDATE Buckets SET BUCKETS= '" + i + "' WHERE NAME= '"
                    + name + "';");
		} else {
			createPlayer(name);
			setBuckets(name, i);
		}
	}
	
	public static void addBuckets(String name, Integer i) {
        if (playerExists(name)) {
            setBuckets(
                    name,
                    Integer.valueOf(getBuckets(name).intValue()
                            + i.intValue()));
        } else {
            createPlayer(name);
            addBuckets(name, i);
        }
    }
	
	public static void removeBuckets(String name, Integer i) {
        if (playerExists(name)) {
            setBuckets(
                    name,
                    Integer.valueOf(getBuckets(name).intValue()
                            - i.intValue()));
        } else {
            createPlayer(name);
            removeBuckets(name, i);
        }
    }
}
