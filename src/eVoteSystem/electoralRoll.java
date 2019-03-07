package eVoteSystem;

import java.util.List;

public class electoralRoll {

	private List<voter> voters;
	
	public electoralRoll(List<voter> allVoters) {
		voters = allVoters;
	}
	
	public boolean voterExists(String voterId) {
		for (int i = 0; i < voters.size(); i++) {
			if (voters.get(i).getVoterDetails().get(voterId) != null) {
				return true;
			}
		}
		return false;
	}
	
	public boolean voterHasVoted(String voterId) {
		for (int i = 0; i < voters.size(); i++) {
			if (voters.get(i).getVoterDetails().get(voterId) != null) {
				return voters.get(i).checkVoted();
			}
		}
		return false;
	}
	
	public boolean checkVoter(String voterId) {
		return true;
	}
}
