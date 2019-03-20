package eVoteSystem;

/**
 * Child class for a candidate 
 */
public class Candidate extends BallotItem {
	
	private String candidateId;
	private String firstName;
	private String lastName;
	private Party candidateParty;
	
	/**
	 * Constructor for Candidate
	 * 
	 * @param cId 		Candidate ID
	 * @param fN 		Candidates First Name
	 * @param lN 		Candidates Last Name
	 * @param cParty	Party the candidate belongs to
	 * 
	 */
	public Candidate(String cId, String fN, String lN, Party cParty) {
		candidateId = cId;
		firstName = fN;
		lastName = lN;
		candidateParty = cParty;
	}
	
	/**
	 * Getter for candidateID
	 */
	public String getCandId() {
		return candidateId;
	}
	
	/**
	 * Getter for firstName
	 */
	public String getCandFirstName() {
		return firstName;
	}
	
	/**
	 * Getter for lastName
	 */
	public String getCandLastName() {
		return lastName;
	}
	
	/**
	 * Getter for candidateParty
	 */
	public Party getCandParty() {
		return candidateParty;
	}
	
	/**
	 * Gets the candidates first and last name seperated by a space.
	 */
	public String getName()
	{
		return firstName + " " + lastName;
	}
}
