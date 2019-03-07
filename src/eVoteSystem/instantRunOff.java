package eVoteSystem;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class instantRunOff {
	
	private Map<candidate, List<voter>> voteCount;
	
	public instantRunOff() {
		voteCount = new HashMap<candidate, List<voter>>();
	}
	
	public boolean castVote(candidate cand, List<voter> votes) {
		voteCount.put(cand, votes);
		return true;
	}
}
