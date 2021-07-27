package be.thijswouters;

import be.thijswouters.Commands.CommandHelp;
import be.thijswouters.Commands.CommandMessage;
import be.thijswouters.Commands.CommandReply;
import be.thijswouters.SQL.MySQL;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class BBM extends Plugin{
	
	public static BBM instance;
	public MySQL mysql;
	
	public void onEnable(){
		instance = this;
		ConnectMySQL();
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new CommandMessage());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new CommandReply());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new CommandHelp());
	}
	
	public static BBM getInstance(){
	    return instance;
    }
	
	public void onDisable(){
		mysql.close();
	}
	
	public void ConnectMySQL() {
		mysql = new MySQL("127.0.0.1", "mcuser_66", "mcuser_66", "ea808a49b0");
	    mysql.update("CREATE TABLE IF NOT EXISTS Reply (NAME varchar(17),LAST varchar(17))");
	}
}
