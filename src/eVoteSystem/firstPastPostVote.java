package eVoteSystem;
import java.util.List;
import java.util.ArrayList;

public class firstPastPostVote implements votingSystem{
	
	private List<voter> voteCount;
	
	public firstPastPostVote() {
		voteCount = new ArrayList<voter>();
	}
	

	@Override
	public boolean castVote(standing cand) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getVotes() {
		// TODO Auto-generated method stub
		
	}
}
