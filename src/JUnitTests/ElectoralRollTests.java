package JUnitTests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import eVoteSystem.ElectoralRoll;
import eVoteSystem.Voter;

import org.junit.Test;

public class ElectoralRollTests {

	@Test
	public void electoralRollConstructTest() {
		List<Voter> voters = new ArrayList<Voter>();
		Voter voter1 = new Voter("1", "John", "Smith", "xx xxx", "01/01/1999");
		Voter voter2 = new Voter("2", "Jack", "Johnson", "xx xxx", "01/01/1999");
		voters.add(voter1);
		voters.add(voter2);
		ElectoralRoll eR = new ElectoralRoll(voters);
		// Check that added voters exist within the electoral roll
		assertTrue(eR.voterExists("John", "Smith", "01/01/1999", "xx xxx"));
		assertTrue(eR.voterExists("Jack", "Johnson", "01/01/1999", "xx xxx"));
		// Check that added voters have not yet voted
		assertFalse(eR.voterHasVoted("John", "Smith", "01/01/1999", "xx xxx"));
		assertFalse(eR.voterHasVoted("Jack", "Johnson", "01/01/1999", "xx xxx"));
		// Check that the checkVoter functions responds correctly, voter exists and hasn't voted
		assertTrue(eR.checkVoter("John", "Smith", "01/01/1999", "xx xxx") != null);
		assertTrue(eR.checkVoter("Jack", "Johnson", "01/01/1999", "xx xxx") != null);
		// Check that the getVoter function responds with the correct voter object
		assertEquals(eR.getVoter("John", "Smith", "01/01/1999", "xx xxx"), voter1);
		assertEquals(eR.getVoter("Jack", "Johnson", "01/01/1999", "xx xxx"), voter2);
	}
	
	@Test
	public void checkVotedTest() {
		List<Voter> voters = new ArrayList<Voter>();
		Voter voter1 = new Voter("1", "John", "Smith", "xx xxx", "01/01/1999");
		voter1.setVoted(true);
		Voter voter2 = new Voter("2", "Jack", "Johnson", "xx xxx", "01/01/1999");
		voters.add(voter1);
		voters.add(voter2);
		ElectoralRoll eR = new ElectoralRoll(voters);
		// Check that voter1 has voted
		assertTrue(eR.voterHasVoted("John", "Smith", "01/01/1999", "xx xxx"));
		// Check that voter1 is not eligible to vote using checkVoter
		assertTrue(eR.checkVoter("John", "Smith", "01/01/1999", "xx xxx") == null);
		// Check that voter2 is eligible to vote
		assertTrue(eR.checkVoter("Jack", "Johnson", "01/01/1999", "xx xxx") != null);
		// Check that voting has no impact on whether or not a voter exists
		assertTrue(eR.voterExists("John", "Smith", "01/01/1999", "xx xxx"));
		Voter voterReturn = eR.checkVoter("Jack", "Johnson", "01/01/1999", "xx xxx");
		// Check to see if the voter returned is the same as the one passed to the class
		assertEquals(voter2, voterReturn);
	}

}
