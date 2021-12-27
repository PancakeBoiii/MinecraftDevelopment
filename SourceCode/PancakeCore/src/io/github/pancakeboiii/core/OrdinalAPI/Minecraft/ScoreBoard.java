package io.github.pancakeboiii.core.OrdinalAPI.Minecraft;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;


public class ScoreBoard {
	static ScoreboardManager manager = Bukkit.getScoreboardManager();
	static Scoreboard board = manager.getNewScoreboard();
	@EventHandler
	public static void CreateTeam(String name) {
		@SuppressWarnings("unused")
		Team team = board.registerNewTeam(name);
	  }
	public static void Objective(String name, String criteria) {
		@SuppressWarnings({ "deprecation", "unused" })
		org.bukkit.scoreboard.Objective objective = board.registerNewObjective(name, criteria);
	  }
	
}

////Adding players
//team.addPlayer(player);
//
////Removing players
//team.removePlayer(player);
//
////Adding prefixes (shows up in player list before the player's name, supports ChatColors)
//team.setPrefix("prefix");
//
////Adding suffixes (shows up in player list after the player's name, supports ChatColors)
//team.setSuffix("suffix");
//
////Setting the display name
//team.setDisplayName("display name");
//
////Making invisible players on the same team have a transparent body
//team.setCanSeeFriendlyInvisibles(true);
//
////Making it so players can't hurt others on the same team
//team.setAllowFriendlyFire(false)