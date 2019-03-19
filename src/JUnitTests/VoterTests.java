package JUnitTests;

import static org.junit.Assert.*;

import java.util.Map;
import eVoteSystem.Voter;
import org.junit.Test;

public class VoterTests {
	
	// Low level voter affirmations 
	
	@Test
	public void voterGetters() {
		Voter voter = new Voter("1", "John", "Smith", "xx xxx", "01/01/1999");
		Map<String, String> voterDetails = voter.getVoterDetails();
		// Check that all the information has been set for the voter correctly
		assertEquals(voterDetails.get("VoterId"), "1");
		assertEquals(voterDetails.get("FirstName"), "John");
		assertEquals(voterDetails.get("LastName"), "Smith");
		assertEquals(voterDetails.get("PostCode"), "xx xxx");
		assertEquals(voterDetails.get("DateOfBirth"), "01/01/1999");
	}

	@Test
	public void voterVotes() {
		Voter voter = new Voter("1", "John", "Smith", "xx xxx", "01/01/1999");
		// Check that voter defaults to not yet voted
		assertFalse(voter.checkVoted());
		voter.setVoted(true);
		// Check that voter voted status has been updated to true
		assertTrue(voter.checkVoted());
	}
}
