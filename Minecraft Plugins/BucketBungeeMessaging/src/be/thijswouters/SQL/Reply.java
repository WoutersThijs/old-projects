package be.thijswouters.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.thijswouters.BBM;

public class Reply {

	public static synchronized boolean playerExists(String name){
		
		try{
			PreparedStatement sql = MySQL.con.prepareStatement("SELECT * FROM Reply WHERE NAME= '" 
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
			BBM.getInstance().mysql.update("INSERT INTO Reply(NAME, LAST) VALUES ('" + name + "', 'ThreshBandicoot');");
		}
	}
	
	public static String getLast(String name){
		String last = "ThreshBandicoot";
		if(playerExists(name)){
			try{
				ResultSet rs = BBM.getInstance().mysql.query("SELECT * FROM Reply WHERE NAME = '"
						+ name + "'");
                if ((!rs.next()));
                last = rs.getString("LAST");
			} catch (SQLException e){
				e.printStackTrace();
			}
		} else {
			createPlayer(name);
			getLast(name);
		}
		return last;
	}
	
	public static void setLast(String name, String target){
		if(playerExists(name)){
			BBM.getInstance().mysql.update("UPDATE Reply SET LAST= '" + target + "' WHERE NAME= '"
                    + name + "';");
		} else {
			createPlayer(name);
			setLast(name, target);
		}
	}
}
