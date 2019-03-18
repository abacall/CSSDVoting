package eVoteSystem;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class InstantRunOff  extends VotingSystem {
	
	private HashMap<BallotItem, List<Integer>> voteCount;
	private int numOfPreferences;
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
		
		numOfPreferences = noOfPreferences;
	}
	
	public int getNumPreferences(){return numOfPreferences;}
	
	/**
	 * Cast a preference vote. Increases
	 * the number of a targeted preference by 1.
	 *
	 * @return      whether or not the casting of the vote was successful.
	 */
	public boolean castVote(BallotItem cand, Integer prefIndex) {
		
		List<Integer> tempList = getVotes(cand);
		
		if((tempList != null) && (prefIndex <= numOfPreferences))
		{
			int incrementedValue = tempList.get(prefIndex) + 1;
			tempList.set(prefIndex, incrementedValue);
			return true;
		}
		
		return false;
		
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
			return null;
		}
	}
	
	/**
	 * Initiates a new list of preferences for when the HashMap is being first created in the constructor.
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
