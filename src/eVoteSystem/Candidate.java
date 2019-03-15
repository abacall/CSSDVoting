package eVoteSystem;

public class Candidate {
	
	private String candidateId;
	private String firstName;
	private String lastName;
	private Party candidateParty;
	
	public Candidate(String cId, String fN, String lN, Party cParty) {
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
	
	public Party getCandParty() {
		return candidateParty;
	}
}
