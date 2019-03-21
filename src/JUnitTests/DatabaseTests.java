package JUnitTests;

import static org.junit.Assert.*;

import eVoteSystem.Database;

import org.junit.Test;

public class DatabaseTests {
	
	@Test
	public void databaseVoterTests() {
		resetDatabase();
		Database db = new Database();
		// Check to see if the database can return a voter
		assertTrue(db.getVoter("Aran", "Bacall","01-01-1997","S24EG") != null);
		// Check to see that the database can set a voter to have voted
		assertTrue(db.setVoterVoted("Aran", "Bacall","01-01-1997","S24EG", true));
		// Check to make sure that the user has now voted
		assertTrue(db.getVoterVoted("Aran", "Bacall","01-01-1997","S24EG"));
		// Check to make sure that the getVoter function still functions on a voter who's voted
		assertTrue(db.getVoter("Aran", "Bacall","01-01-1997","S24EG") != null);
		// Check to make sure another voter can successfully vote
		assertTrue(db.setVoterVoted("Alex","Fox","01-01-1997","S24EG", true));
		assertTrue(db.getVoterVoted("Alex","Fox","01-01-1997","S24EG"));
		// Check to make sure querying for a non-existent voter returns null
		assertTrue(db.getVoter("John", "Smith","01-01-1997","S24EG") == null);
		resetDatabase();
	}
	
	private void resetDatabase() {
		Database db = new Database();
		db.setVoterVoted("Aran", "Bacall","01-01-1997","S24EG", false);
		db.setVoterVoted("Alex","Fox","01-01-1997","S24EG", false);
		db.setVoterVoted("Elliot","Howard","01-01-1997","S24EG", false);
	}

}
