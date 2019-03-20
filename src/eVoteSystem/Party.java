package eVoteSystem;

/**
 * Child class for a political party
 */
public class Party extends BallotItem {
	
	private String partyName;
	
	/**
	 * Constructor for party
	 * 
	 * @param partyName		Political Party Name
	 */
	public Party(String partyName) {
		this.partyName = partyName;
	}
	
	/**
	 * Get party name
	 */
	public String getName() {return partyName;}
}
