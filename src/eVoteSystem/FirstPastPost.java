package eVoteSystem;
import java.util.List;
import java.util.ArrayList;

public class FirstPastPost implements VotingSystem{
	
	private List<Voter> voteCount;
	
	public FirstPastPost() {
		voteCount = new ArrayList<Voter>();
	}
	

	@Override
	public boolean castVote(Standing cand) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getVotes() {
		// TODO Auto-generated method stub
		
	}
}
