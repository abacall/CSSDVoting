package eVoteSystem;

import java.util.List;
import java.util.Map;

public class ElectoralRoll {

	private List<Voter> voters;
	
	/**
	 * Voters are passed through the constructor to initiate the voter list
	 */
	public ElectoralRoll(List<Voter> allVoters) {
		voters = allVoters;
	}
	
	/**
	 * Checks if a voter exists given details about the voter.
	 *
	 * @return      true if the user exists and false otherwise, based upon provided voter information.
	 */
	public boolean voterExists(String firstName, String lastName, String doB, String postcode) {
		if (getVoter(firstName, lastName, doB, postcode) != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if a voter has voted in the current election.
	 *
	 * @return      true if the user has voted and false otherwise, using provided voter information to identify the voter.
	 */
	public boolean voterHasVoted(String firstName, String lastName, String doB, String postcode) {
		Voter voter = getVoter(firstName, lastName, doB, postcode);
		if (voter != null) {
			return voter.checkVoted();
		}
		return false;
	}
	
	/**
	 * Returns a voter given details about said voter.
	 *
	 * @return      voter if the information provided can be verified as existing, else returns null
	 */
	public Voter getVoter(String firstName, String lastName, String doB, String postcode) 
	{
		//Checks passed in details against all registered voters
		for (int i = 0; i < voters.size(); i++) 
		{
			Map<String, String> voterDetails = voters.get(i).getVoterDetails();
			if (voterDetails.get("FirstName").equalsIgnoreCase(firstName) &&
				voterDetails.get("LastName").equalsIgnoreCase(lastName)&&
				voterDetails.get("PostCode").equalsIgnoreCase(postcode) &&
				voterDetails.get("DateOfBirth").equalsIgnoreCase(doB)) {
				return voters.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Checks whether a voter exists and has not yet voted.
	 *
	 * @return      true if the voter exists and hasn't yet voted, false otherwise
	 */
	public Voter checkVoter(String fN, String lN, String doB, String pC) {
		if (voterExists(fN, lN, doB, pC) && !voterHasVoted(fN, lN, doB, pC)) {
			return getVoter(fN, lN, doB, pC);
		}
		return null;
	}
}
