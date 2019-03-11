package eVoteSystem;

import java.util.List;

public class ElectionInterface {
	List<Administrator> admins;
	List<Election> elections;
	
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
	
	
	
}
