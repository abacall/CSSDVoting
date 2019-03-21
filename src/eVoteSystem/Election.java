package eVoteSystem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class Election implements Serializable{

	private String electionID;
	private String electionName;
	private ElectoralRoll voters;
	private ArrayList<BallotItem> candidates;
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
	public Election(String electionID, String electionName, ArrayList<BallotItem> candidates, VotingSystem voteSystem, Date startTime, Date endTime, ElectoralRoll voters)
	{
		this.electionName = electionName;
		this.electionID = electionID;
		this.candidates = candidates;
		this.voteSystem = voteSystem; 
		this.startTime = startTime;
		this.endTime = endTime;
		this.voters = voters;
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
	public ArrayList<BallotItem> returnCandidates()
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
	public boolean validateUser(String firstName, String lastName, String DoB , String postcode)
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
	 * Casts a vote for a standing party in first past post system 
	 * 
	 * @return 		true for success, false for failure     
	 */
	public boolean castVote(BallotItem candidate)
	{
		//Creates a temporary VotingSystem for manipulation
		FirstPastPost temp = (FirstPastPost) voteSystem;
		
		Map<String, String> voterDetails = loggedInVoter.getVoterDetails();
		//Validate user again before casting vote
		loggedInVoter = voters.checkVoter(voterDetails.get("FirstName"), voterDetails.get("LastName"),  voterDetails.get("DateOfBirth"), voterDetails.get("PostCode"));
		
		
		//Checks that a user is logged in and hasn't voted
		if (loggedInVoter != null) {
			
			boolean validVote = temp.castVote(candidate);
			
			if(validVote)
			{
				//Sets temp VotingSystem back
				voteSystem = temp;
				//Flags that the logged in user has voted
				loggedInVoter.setVoted(true);
				//Flags that the logged in user has voted
				voters.setVoterHasVoted(loggedInVoter, true);
				//Logs user out
				loggedInVoter = null;
				return true;
			}
			
			return false;
		} else if (loggedInVoter == null) {
			//Sets error message if user is not logged in
			errorMessage = "Invalid user";
			return false;
		} else  {
			 //Set error message if casting the vote fails
			 errorMessage = "Failed to cast vote.";
			 return false;
		 }
		 
	}
	
	/**
	 * Casts a vote for a standing party in instant run off
	 * 
	 * @return 		true for success, false for failure     
	 */
	public boolean castVote(ArrayList<BallotItem> candidates)
	{
		InstantRunOff temp = (InstantRunOff) voteSystem;
		
		Map<String, String> voterDetails = loggedInVoter.getVoterDetails();
		//Validate user again before casting vote
		loggedInVoter = voters.checkVoter(voterDetails.get("FirstName"), voterDetails.get("LastName"), voterDetails.get("PostCode"), voterDetails.get("DateOfBirth"));
		
		if (loggedInVoter != null) {
			errorMessage = "Voter has already voted.";
			return false;
		} else if (loggedInVoter == null) {
			errorMessage = "A voter has yet to log in";
			return false;
		} 
		
		 for(int i = 0; i < candidates.size(); i++)
		 {
			 if (!temp.castVote(candidates.get(i), i))
				 return false;
			 
		 }
		
		 voteSystem = temp;
		 loggedInVoter.setVoted(true);
		//Flags that the logged in user has voted
		voters.setVoterHasVoted(loggedInVoter, true);
		loggedInVoter = null;
		 
		 return true;
	}
	
	/**
	 * Logs a voter into the system. 
	 *
	 * @return 		true for success, false for failure   
	 */
	public boolean login(String firstName, String lastName, String DoB, String postcode)
	{
		//Validate if user is eligible to vote
		if (validateUser(firstName, lastName, DoB, postcode))
		{
			Voter temp = voters.checkVoter(firstName, lastName, DoB, postcode);
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
		//Checks each administrator and attempts log in
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
	public List<Integer> getVoteCount(BallotItem cand)
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
