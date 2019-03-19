package JUnitTests;

import static org.junit.Assert.*;
import eVoteSystem.Candidate;
import eVoteSystem.Party;

import org.junit.Test;

// Low level tests
public class BallotItemTests {

	@Test
	public void logoGettersTest() {
		Party party = new Party("Conservatives");
		Candidate cand = new Candidate("1", "John", "Smith", party);
		party.setLogo("C:/images/conservativesLogo.png");
		cand.setLogo("C:/images/johnSmithPic.png");
		// Test party logo was set correctly
	    assertTrue(party.getLogo() == "C:/images/conservativesLogo.png");
	    // Test candidate logo was set correctly
	    assertTrue(cand.getLogo() == "C:/images/johnSmithPic.png");    
	}
	
	@Test
	public void partyGettersTest() {
		Party party = new Party("Conservatives");
		// Test party name was set correctly
		assertTrue(party.getPartyName() == "Conservatives");
	}
	
	@Test
	public void candidateGettersTest() {
		Party party = new Party("Conservatives");
		Candidate cand = new Candidate("1", "John", "Smith", party);
		// Test candidate name was set correctly
		assertTrue(cand.getCandFirstName() == "John");
		assertTrue(cand.getCandLastName() == "Smith");
		// Test candidate id and party was set correctly
		assertTrue(cand.getCandId() == "1");
		assertTrue(cand.getCandParty() == party);
	}

}
