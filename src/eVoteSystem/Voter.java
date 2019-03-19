package eVoteSystem;
import java.util.HashMap;
import java.util.Map;

public class Voter {
	
	private String voterId;
	private String firstName;
	private String lastName;
	private String postCode;
	private String dateOfBirth;
	private boolean hasVoted;
	
	// Constructor for the class, all voter information is passed through as parameters
	public Voter(String vI, String fN, String lN, String pC, String dOB) {
		voterId = vI;
		firstName = fN;
		lastName = lN;
		postCode = pC;
		dateOfBirth = dOB;
		hasVoted = false;
	}
	
	// Returns a map containing the details of the voter
	// Map is used for ease of access, no need to do a getter for each detail
	public Map<String, String> getVoterDetails() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("VoterId", voterId);
		map.put("FirstName", firstName);
		map.put("LastName", lastName);
		map.put("PostCode", postCode);
		map.put("DateOfBirth", dateOfBirth);
		return map;
	}
	
	public void setVoted(boolean voted) {
		hasVoted = voted;
	}
	
	// Returns if the user has voted yet or not
	public boolean checkVoted() {
		return hasVoted;
	}
	
}
