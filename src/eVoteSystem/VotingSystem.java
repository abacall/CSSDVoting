package eVoteSystem;
import java.util.List;

/**
 * Parent class for voting systems
 */
public class VotingSystem {
	/**
	 * Returns a vote count for a given candidate 
	 */
	public List<Integer> getVotes(BallotItem cand){return null;};
	/**
	 * Casts a vote
	 */
	public boolean castVote() {return false;};
}
