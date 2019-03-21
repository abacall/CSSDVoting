package JUnitTests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import eVoteSystem.Database;
import eVoteSystem.ElectoralRoll;
import eVoteSystem.Voter;

import org.junit.Test;

public class ElectoralRollTests {
	
	@Test
	public void electoralRollConstructTest() {
		resetDatabase();
		List<Voter> voters = new ArrayList<Voter>();
		ElectoralRoll eR = new ElectoralRoll();
		// Check that added voters exist within the electoral roll
		assertTrue(eR.voterExists("Alex","Fox","01-01-1997","S24EG"));
		assertTrue(eR.voterExists("Aran","Bacall","01-01-1997","S24EG"));
		// Check that added voters have not yet voted
		assertFalse(eR.voterHasVoted("Alex","Fox","01-01-1997","S24EG"));
		assertFalse(eR.voterHasVoted("Aran","Bacall","01-01-1997","S24EG"));
		// Check that the checkVoter functions responds correctly, voter exists and hasn't voted
		assertTrue(eR.checkVoter("Alex","Fox","01-01-1997","S24EG") != null);
		assertTrue(eR.checkVoter("Aran","Bacall","01-01-1997","S24EG") != null);
		resetDatabase();
	}
	
	@Test
	public void checkVotedTest() {
		resetDatabase();
		ElectoralRoll eR = new ElectoralRoll();
		Voter voter1 = eR.getVoter("Alex","Fox","01-01-1997","S24EG");
		Voter voter2 = eR.getVoter("Aran","Bacall","01-01-1997","S24EG");
		eR.setVoterHasVoted(voter1, true);
		// Check that voter1 has voted
		assertTrue(eR.voterHasVoted("Alex","Fox","01-01-1997","S24EG"));
		// Check that voter1 is not eligible to vote using checkVoter
		assertTrue(eR.checkVoter("Alex","Fox","01-01-1997","S24EG") == null);
		// Check that voter2 is eligible to vote
		assertTrue(eR.checkVoter("Aran","Bacall","01-01-1997","S24EG") != null);
		// Check that voting has no impact on whether or not a voter exists
		assertTrue(eR.voterExists("Alex","Fox","01-01-1997","S24EG"));
		// Check that voter1 is now not eligible to vote
		assertTrue(eR.checkVoter("Alex","Fox","01-01-1997","S24EG") == null);
		eR.setVoterHasVoted(voter1, false);
		resetDatabase();
	}
		
	private void resetDatabase() {
		Database db = new Database();
		db.setVoterVoted("Aran", "Bacall","01-01-1997","S24EG", false);
		db.setVoterVoted("Alex","Fox","01-01-1997","S24EG", false);
		db.setVoterVoted("Elliot","Howard","01-01-1997","S24EG", false);
	}

}
