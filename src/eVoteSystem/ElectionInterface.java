package eVoteSystem;

import java.util.ArrayList;
import java.util.Date;

public class ElectionInterface {
	private ArrayList<Election> elections;
	
	/**
	 * Returns the Election object associated with an ID
	 *
	 * @return      the Election or null if no election found
	 */
	public Election getElection(String electionID)
	{
		for(Election item : elections)
		{
			if(item.getElectionID().equalsIgnoreCase(electionID))
					return item;
		}
		
		return null;
	}
	
	public ArrayList<String> getElectionNames()
	{
		ArrayList<String> returnNames = new ArrayList<>();
		
		for(Election item : elections)
		{
			returnNames.add(item.getName());
		}
		
		return returnNames;
		
	}
	
	public void createElection(String electionID, String electionName, ArrayList<Standing> candidates, VotingSystem voteSystem, Date startTime, Date endTime)
	{
		Election newElection = new Election( electionID,  electionName, candidates,  voteSystem,  startTime,  endTime);
		elections.add(newElection);
	}
	
}
