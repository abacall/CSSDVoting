package eVoteSystem;

public class candidate {
	
	private String candidateId;
	private String firstName;
	private String lastName;
	private party candidateParty;
	
	public candidate(String cId, String fN, String lN, party cParty) {
		candidateId = cId;
		firstName = fN;
		lastName = lN;
		candidateParty = cParty;
	}
	
	public String getCandId() {
		return candidateId;
	}
	
	public String getCandFirstName() {
		return firstName;
	}
	
	public String getCandLastName() {
		return lastName;
	}
	
	public party getCandParty() {
		return candidateParty;
	}
}
