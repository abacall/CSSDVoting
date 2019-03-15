package eVoteSystem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Election {

	private String electionID;
	private String electionName;
	private ElectoralRoll voters;
	private ArrayList<Standing> candidates;
	private VotingSystem voteSystem;
	private ArrayList<Administrator> administrators;
	private Voter loggedInVoter;
	public Date startTime;
	public Date endTime;
	public String errorMessage;
	

	/**
	 * Constructor for Election 
	 *
	 */
	public Election(String electionID, String electionName, ArrayList<Standing> candidates, VotingSystem voteSystem, Date startTime, Date endTime)
	{
		this.electionName = electionName;
		this.electionID = electionID;
		this.candidates = candidates;
		this.voteSystem = voteSystem; 
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/**
	 * Returns the name of the election. 
	 *
	 * @return      the name of the election
	 */
	public String getName()
	{return electionName;}
	
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
	 * Returns a string with an error message. To be called after a function 
	 * returns false/null in order to provide additional information. 
	 *
	 * @return      string with error message
	 */
	public String returnError()
	{
		return errorMessage;
	}
	
	/**
	 * Checks that a voter both exists and has not already voted.
	 *
	 *@return		true if user can be validated, false if not
	 */
	public boolean validateUser(String firstName, String lastName,String DoB , String postcode)
	{
		if(voters.checkVoter(firstName, lastName, DoB, postcode) != null)
		{
			return true;
		} else {
			errorMessage = "Failed to validate user.";
			return false;
		}
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
			 errorMessage = "Failed to cast vote.";
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
		errorMessage = "Failed to validate administrator.";
		return false;
	}
	
	/**
	 * Returns the number of votes cast.
	 * @return 
	 *
	 * @return      the number of votes cast
	 */
	public List<Integer> getVoteCount(Standing cand)
	{
		return voteSystem.getVotes(cand);
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
