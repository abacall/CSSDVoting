package eVoteSystem;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class InstantRunOff {
	
	private Map<Candidate, List<Voter>> voteCount;
	
	public InstantRunOff() {
		voteCount = new HashMap<Candidate, List<Voter>>();
	}
	
	public boolean castVote(Candidate cand, List<Voter> votes) {
		voteCount.put(cand, votes);
		return true;
	}
}
