package eVoteSystem;

import java.util.List;

public class ElectionInterface {
	List<Administrator> admins;
	List<Election> elections;
	
	public Election getElection(String electionID)
	{
		for(Election item : elections)
		{
			if(item.getElectionID().equalsIgnoreCase(electionID))
					return item;
		}
		
		return null;
	}
	
	
	
}
