package com.pulselive.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class LeagueTable
{

	private HashMap<String, LeagueTableEntry> leagueTable; //hashmap to store league table entry of all teams as value, team name as key

	/**
	 * Instantiates a new league table with List of matches
	 *
	 * @param matches list of matches
	 */
	public LeagueTable(final List<Match> matches) 
	{
		leagueTable = new HashMap<String, LeagueTableEntry>();
		for (Match match : matches) 
		{
			addMatchToLeague(match);
		}
	}
	
	/**
	 * Return the league table entry of one team
	 *
	 * @param teamName team name
	 * 
	 * @return league table entry of one team
	 */
	public LeagueTableEntry getTableEntry(String teamName) 
	{
		return leagueTable.get(teamName);
	}
	
	
	/**
	 * Process one match record and update the league table
	 *
	 * @param match single match result
	 */
    private void addMatchToLeague (Match match) 
    {
    	String homeTeamName = match.getHomeTeam(); //extract keys for hashmap later
    	String awayTeamName = match.getAwayTeam();
    	
    	LeagueTableEntry homeTableEntry = leagueTable.get(homeTeamName);
    	LeagueTableEntry awayTableEntry = leagueTable.get(awayTeamName);    	
    	
		if (homeTableEntry == null) //table entry not found, so need to initialise for first match 
		{
			homeTableEntry = new LeagueTableEntry(homeTeamName, 0, 0, 0, 0, 0, 0, 0, 0);    				   				
    	}
		if (awayTableEntry == null)
		{
			awayTableEntry = new LeagueTableEntry(awayTeamName, 0, 0, 0, 0, 0, 0, 0, 0);
    	}
		
		if (match.getHomeScore() > match.getAwayScore()) //home win, update points and WDL record
		{
			homeTableEntry.setWon(homeTableEntry.getWon() + 1);
			awayTableEntry.setLost(awayTableEntry.getLost() + 1);
			homeTableEntry.setPoints(homeTableEntry.getPoints() + 3);			
		} 
		else if (match.getHomeScore() < match.getAwayScore() ) //away win
		{
			homeTableEntry.setLost(homeTableEntry.getLost() + 1);
			awayTableEntry.setWon(awayTableEntry.getWon() + 1);			
			awayTableEntry.setPoints(awayTableEntry.getPoints() + 3);			
		} 
		else //draw
		{
			homeTableEntry.setDrawn(homeTableEntry.getDrawn() + 1);
			awayTableEntry.setDrawn(awayTableEntry.getDrawn() + 1);
			homeTableEntry.setPoints(homeTableEntry.getPoints() + 1);
			awayTableEntry.setPoints(awayTableEntry.getPoints() + 1);
		}
		
		
		homeTableEntry.setPlayed(homeTableEntry.getPlayed() + 1);
		awayTableEntry.setPlayed(awayTableEntry.getPlayed() + 1);		
		
		//update goal records
		homeTableEntry.setGoalsFor(homeTableEntry.getGoalsFor() + match.getHomeScore());
		awayTableEntry.setGoalsFor(awayTableEntry.getGoalsFor() + match.getAwayScore());
		
		homeTableEntry.setGoalsAgainst(homeTableEntry.getGoalsAgainst() + match.getAwayScore());
		awayTableEntry.setGoalsAgainst(awayTableEntry.getGoalsAgainst() + match.getHomeScore());
		
		homeTableEntry.setGoalDifference(homeTableEntry.getGoalDifference() + match.getHomeScore() - match.getAwayScore());
		awayTableEntry.setGoalDifference(awayTableEntry.getGoalDifference() + match.getAwayScore() - match.getHomeScore());
		
		//league table entry update complete, overwrite the previous value
    	leagueTable.put(homeTeamName, homeTableEntry);
    	leagueTable.put(awayTeamName, awayTableEntry);    
    }
    
    

	/**
	 * Get the ordered list of league table entries for this league table.
	 *
	 * @return league table entries sorted by points desc, goal difference desc, goal for desc, team name asc
	 */
	public List<LeagueTableEntry> getTableEntries() 
	{
		List<LeagueTableEntry> leagueTableArrayList = new ArrayList<>(leagueTable.values());
		
		leagueTableArrayList.sort(Comparator.comparing(LeagueTableEntry::getPoints).reversed()
				.thenComparing(LeagueTableEntry::getGoalDifference, Comparator.reverseOrder())
				.thenComparing(LeagueTableEntry::getGoalsFor, Comparator.reverseOrder())
				.thenComparing(LeagueTableEntry::getTeamName));
			    
		return leagueTableArrayList;
	}
}
