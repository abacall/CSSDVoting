package eVoteSystem;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstantRunOff  extends VotingSystem {
	
	private Map<BallotItem, List<Integer>> voteCount;
	
	/**
	 * Constructor. Initiates the voting storage HashMap and adds all the current candidates to it.
	 * The list of preferences for 5 preferences should look like: 0 0 0 0 0
	 * where the left most side indicates top preference and the value on the right most side
	 * indicates lowest preference. The values are incremented as people select that candidate for
	 * that specific preference. 
	 */
	public InstantRunOff(List<BallotItem> candidates, Integer noOfPreferences) {
		// Initiates the storage (map) for the candidates and their votes
		voteCount = new HashMap<BallotItem, List<Integer>>();
		// Adds all candidates to the map
		for (int i = 0; i < candidates.size(); i++) {
			List<Integer> prefList = initPreferenceList(noOfPreferences);
			voteCount.put(candidates.get(i), prefList);
		}
	}
	
	/**
	 * Casts a new vote into the system, adding it to the HashMap.
	 *
	 * @return      whether or not casting the vote was successful.
	 */
	public boolean castVote(BallotItem cand, List<Integer> votes) {
		List<Integer> tempList = voteCount.get(cand);
		// If a invalid preference list has been given, return failure
		if (tempList.size() == votes.size()) {
			// Adds the preferences given to the function with the existing values.
			for (int i = 0; i < votes.size(); i++) {
				tempList.set(i, tempList.get(i) + votes.get(i));
			}
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns a list containing the preference votes for a given candidate.
	 *
	 * @return      list of integers containing preferences for candidate.
	 */
	@Override
	public List<Integer> getVotes(BallotItem cand) {
		// Checks that the candidate exists within the HashMap
		// Returns an empty list if not
		if (voteCount.containsKey(cand)) {
			return voteCount.get(cand);
		} else {
			return new ArrayList<Integer>();
		}
	}
	
	/**
	 * Inititates a new list of preferences for when the HashMap is being first created in the constructor.
	 *
	 * @return      list of integers, set to a specified size, where every integer is 0.
	 */
	private List<Integer> initPreferenceList(Integer noOfPreferences) {
		List<Integer> newList = new ArrayList<Integer>();
		for (int i = 0; i < noOfPreferences; i++) {
			newList.add(0);
		}
		return newList;
	}
}
