package eVoteSystem;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class FirstPastPost extends VotingSystem {
	
	private Map<BallotItem, List<Integer>> voteCount;
	
	/**
	 * Constructor. Inititates the voting storage HashMap and adds all the current candidates to it.
	 * Each candidate should have a list assigned to them, this list will only store one value, a 0
	 * to indicate they have not received any votes yet.
	 */
	public FirstPastPost(List<BallotItem> candidates) {
		// Inititiates the storage (map) for the candidates and their votes
		voteCount = new HashMap<BallotItem, List<Integer>>();
		// Adds all candidates to the map
		for (int i = 0; i < candidates.size(); i++) {
			List<Integer> voteList = new ArrayList<Integer>();
			voteList.set(0, 0);
			voteCount.put(candidates.get(i), voteList);
		}
	}
	
	/**
	 * Casts a new vote into the system, adding it to the HashMap.
	 *
	 * @return      whether or not casting the vote was successful.
	 */
	public boolean castVote(BallotItem cand) {
		Integer currentVotes = voteCount.get(cand).get(0);
		List<Integer> tempArray = new ArrayList<Integer>();
		tempArray.set(0, (currentVotes+1));
		voteCount.put(cand, tempArray);
		return true;
	}

	/**
	 * Returns a list containing the votes for a given candidate.
	 *
	 * @return      list of integers containing one value, the vote count for the given candidate.
	 */
	public List<Integer> getVotes(BallotItem cand) {
		// Checks that the candidate exists within the HashMap
		// Returns an empty list if not
		if (voteCount.containsKey(cand)) {
			return voteCount.get(cand);
		} else {
			return new ArrayList<Integer>();
		}
	}
}
