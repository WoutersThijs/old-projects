package be.thijswouters.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import be.thijswouters.DemonsCore;

public class State {
	
	public static String getState(String server){
		String last = "IN_LOBBY";
			try{
				ResultSet rs = DemonsCore.getInstance().mysql.query("SELECT STATE FROM State WHERE SERVER='" + server + "'");
                if ((!rs.next()));
                last = rs.getString("STATE");
			} catch (SQLException e){
				e.printStackTrace();
			}
		return last;
	}
	
	public static void setState(String server, String state){
			DemonsCore.getInstance().mysql.update("UPDATE State SET STATE= '" + state + "' WHERE SERVER='" + server + "';");
	}
}
