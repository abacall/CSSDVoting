package eVoteSystem;

/**
 * Parent class for eneties standing in an election
 */
public class BallotItem {
	
	private String logo;
	
	/**
	 * Sets the file location of the logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	/**
	 * Returns the file location of the logo
	 */
	public String getLogo() {
		return logo;
	}
	
	/**
	 * Returns the name of the item.
	 */
	public String getName() {return "";}
}
