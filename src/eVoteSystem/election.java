package eVoteSystem;
import java.util.ArrayList;
import java.util.Date;


public class election {

	private String electionID;
	private electoralRoll voters;
	private ArrayList<standing> candidates;
	private votingSystem voteSystem;
	private ArrayList<administrator> administrators;
	public Date startTime;
	public Date endTime;
	
	public election()
	{
		
	}
	
	/**
	 * Returns an ArrayList of the entities standing in this election. 
	 *
	 * @return      the candidates standing for election
	 */
	public ArrayList<standing> returnCandidates()
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
	public boolean validateUser(String voterID)
	{
		return voters.checkVoter(voterID);
	}
	
	/**
	 * Casts a vote for a standing party. 
	 *      
	 */
	public boolean castVote()
	{
		return false;
	}
	
	/**
	 * Logs a voter into the system. 
	 *
	 */
	public boolean login(String firstName, String lastName, String DoB, String postcode)
	{
		
		return voters.checkVoter(firstName, lastName, DoB, postcode);
	}
	
	/**
	 * Logs an administrator into the system.
	 *
	 */
	public void adminLogin(String username, String password)
	{
		for(administrator current : administrators)
		{
			if(current.getUserName().equals(username))
				current.validateUser(username, password);
			
		}
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
	
}
