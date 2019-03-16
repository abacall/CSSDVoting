package eVoteSystem;

public class Party extends BallotItem {
	
	private String partyName;
	
	public Party(String partyName) {
		this.partyName = partyName;
	}
	
	public String getPartyName() {
		return partyName;
	}
}
