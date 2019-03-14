package eVoteSystem;
import java.util.List;

public interface VotingSystem {
	
	public List<Integer> getVotes(Standing cand);
}
