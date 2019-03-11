package eVoteSystem;
import java.util.ArrayList;
import java.util.Date;


public class Election {

	private String electionID;
	private ElectoralRoll voters;
	private ArrayList<Standing> candidates;
	private VotingSystem voteSystem;
	private ArrayList<Administrator> administrators;
	private Voter loggedInVoter;
	public Date startTime;
	public Date endTime;
	
	public Election()
	{
		
	}
	
	/**
	 * Returns an ArrayList of the entities standing in this election. 
	 *
	 * @return      the candidates standing for election
	 */
	public ArrayList<Standing> returnCandidates()
	{
		return candidates;
	}
	
	/**
	 * Returns a string with an error message. 
	 *
	 * @return      error message
	 */
	public String returnError()
	{
		return null;
	}
	
	/**
	 * Checks that a voter both exists and has not already voted.
	 *
	 */
	public boolean validateUser(String firstName, String lastName,String DoB , String postcode)
	{
		return voters.checkVoter(firstName, lastName, DoB, postcode) != null;
	}
	
	/**
	 * Casts a vote for a standing party. 
	 * 
	 * @return 		true for success, false for failure     
	 */
	public boolean castVote(Standing candidate)
	{
		 if( voteSystem.castVote(candidate))
		 {
			 loggedInVoter = null;
			 return true;
		 } else {
			 return false;
		 }
		 
	}
	
	/**
	 * Logs a voter into the system. 
	 *
	 * @return 		true for success, false for failure   
	 */
	public boolean login(String firstName, String lastName, String DoB, String postcode)
	{
		
		Voter temp = voters.checkVoter(firstName, lastName, DoB, postcode);
		
		if(temp != null)
		{
			loggedInVoter = temp;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Logs an administrator into the system.
	 *
	 * @return 		true for success, false for failure   
	 */
	public boolean adminLogin(String username, String password)
	{
		for(Administrator current : administrators)
		{
			if(current.getUserName().equals(username))
				return current.validateUser(username, password);
			
		}
		
		return false;
	}
	
	/**
	 * Returns the number of votes cast.
	 *
	 * @return      the number of votes cast
	 */
	public int getVoteCount()
	{
		return 0;
	}
	
	/**
	 * Returns the currently logged in user.
	 *
	 * @return      voter that is logged in or null if none
	 */
	public Voter getLoggedInUser()
	{
		return loggedInVoter;
	}

	/**
	 * @return the electionID
	 */
	public String getElectionID() 
	{
		return electionID;
	}

	
}
