package com.pulselive.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


class LeagueTableTest {

	@Test
	void addMatchToLeagueTest() 
	{		
		List<Match> match = Arrays.asList(new Match("Arsenal", "Norwich", 3, 2));
		LeagueTable table = new LeagueTable(match);
		LeagueTableEntry actualEntry_Arsenal = table.getTableEntry("Arsenal");
		assertAll("Arsenal have won one game by 4:1 ",
				() -> assertEquals(1, actualEntry_Arsenal.getWon(), "game won"),
				() -> assertEquals(0, actualEntry_Arsenal.getDrawn(), "game drawn"),
				() -> assertEquals(0, actualEntry_Arsenal.getLost(), "game lost"),
				() -> assertEquals(3, actualEntry_Arsenal.getGoalsFor(), "goal for"),
				() -> assertEquals(2, actualEntry_Arsenal.getGoalsAgainst(), "goal against"),
				() -> assertEquals(1, actualEntry_Arsenal.getGoalDifference(), "goal diff"),
				() -> assertEquals(3, actualEntry_Arsenal.getPoints(), "points"),
				() -> assertEquals(1, actualEntry_Arsenal.getPlayed(), "played"));
	}
	
	@Test
	void getTableEntriesTestSortByPoint() 
	{		
		List<Match> match = Arrays.asList(new Match("Arsenal", "Norwich", 3, 2));
		LeagueTable table = new LeagueTable(match);
		List<LeagueTableEntry> sortedLeague = table.getTableEntries();
		assertAll("Arsenal has most points",
				() -> assertEquals("Arsenal", sortedLeague.get(0).getTeamName(), "Top team"),
				() -> assertEquals("Norwich", sortedLeague.get(1).getTeamName(), "Second team"));
	}

	
	@Test
	void getTableEntriesTestSortByGoalDiff() 
	{
		List<Match> match = Arrays.asList(new Match("Arsenal", "Norwich", 3, 2),
				new Match("Liverpool", "Reading", 2, 0));
		LeagueTable table = new LeagueTable(match);
		List<LeagueTableEntry> sortedLeague = table.getTableEntries();
		assertAll("Liverpool is above Arsenal with goal diff",
				() -> assertEquals("Liverpool", sortedLeague.get(0).getTeamName(), "Top team"),
				() -> assertEquals("Arsenal", sortedLeague.get(1).getTeamName(), "Second team"));
	}
	@Test
	void getTableEntriesTestSortByGoalFor() 
	{		
		List<Match> match = Arrays.asList(new Match("Arsenal", "Norwich", 3, 2),
				new Match("Liverpool", "Reading", 6, 5));
		LeagueTable table = new LeagueTable(match);
		List<LeagueTableEntry> sortedLeague = table.getTableEntries();
		assertAll("Liverpool is above Arsenal with goal for",
				() -> assertEquals("Liverpool", sortedLeague.get(0).getTeamName(), "Top team"),
				() -> assertEquals("Arsenal", sortedLeague.get(1).getTeamName(), "Second team"));
	}

	@Test
	void getTableEntriesTestSortByName() 
	{		
		List<Match> match = Arrays.asList(new Match("Arsenal", "Norwich", 3, 2), new Match("Zulu FC", "Reading", 3, 2));
		LeagueTable table = new LeagueTable(match);
		List<LeagueTableEntry> sortedLeague = table.getTableEntries();
		assertAll("Arsenal is above Zulu FC with name",
				() -> assertEquals("Arsenal", sortedLeague.get(0).getTeamName(), "Top team"),
				() -> assertEquals("Zulu FC", sortedLeague.get(1).getTeamName(), "Second team"));
	}
}
