package eVoteSystem;

import java.util.List;

public class electoralRoll {

	private List<voter> voters;
	
	// Voters are passed through the constructor to create this class
	public electoralRoll(List<voter> allVoters) {
		voters = allVoters;
	}
	
	// Checks if a voter exists, given a voterId, returning true if yes
	public boolean voterExists(String voterId) {
		for (int i = 0; i < voters.size(); i++) {
			if (voters.get(i).getVoterDetails().get(voterId) != null) {
				return true;
			}
		}
		return false;
	}
	
	// Checks if a user has voted, given a voterId, returning true if yes
	public boolean voterHasVoted(String voterId) {
		for (int i = 0; i < voters.size(); i++) {
			if (voters.get(i).getVoterDetails().get(voterId) != null) {
				return voters.get(i).checkVoted();
			}
		}
		return false;
	}
	
	// Checks if the user exists but hasn't yet voted, given a voterId, returns true if yes
	public boolean checkVoter(String firstName, String lastName, String doB, String postcode) {
		return false;
	}
}
