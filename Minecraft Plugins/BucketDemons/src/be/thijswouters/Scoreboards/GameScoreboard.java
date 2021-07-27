package be.thijswouters.Scoreboards;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import be.thijswouters.Schedulers.LobbyTimer;

public class GameScoreboard {
	
	public static Scoreboard board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();;
	public static Objective o;
	public static Score TimerLineNumber;
	public static Score Time;
	public static Score NexusLineNumer;
	public static Score Nexus;
	public static Score Empty;
	
	@SuppressWarnings("deprecation")
	public static void setupScoreboard(){

		o = board.registerNewObjective("§6§lDemons ", "dummy");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);

		TimerLineNumber = o.getScore(Bukkit.getServer().getOfflinePlayer(
				"§e§lTimer"));
		TimerLineNumber.setScore(4);
		Time = o.getScore(Bukkit.getServer().getOfflinePlayer(
				"§7" + LobbyTimer.time));
		Time.setScore(3);
		
		Empty = o.getScore(Bukkit.getServer().getOfflinePlayer(
				"§a"));
		Empty.setScore(2);
		
		NexusLineNumer = o.getScore(Bukkit.getServer().getOfflinePlayer(
				"§e§lEnder Core"));
		NexusLineNumer.setScore(1);
		Nexus = o.getScore(Bukkit.getServer().getOfflinePlayer(
				"§7" + 30));
		Nexus.setScore(0);
	}
}
