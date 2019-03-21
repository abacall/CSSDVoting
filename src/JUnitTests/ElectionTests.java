package JUnitTests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import eVoteSystem.BallotItem;
import eVoteSystem.Candidate;
import eVoteSystem.Database;
import eVoteSystem.Election;
import eVoteSystem.ElectoralRoll;
import eVoteSystem.FirstPastPost;
import eVoteSystem.InstantRunOff;
import eVoteSystem.Party;
import eVoteSystem.Voter;
import eVoteSystem.VotingSystem;

public class ElectionTests {
	
	
	@Test
	public void electionConstructorTest() throws ParseException {
		resetDatabase();
		Election el = createElection(0);
		// Check that details are correct
		assertEquals(el.getName(), "Sample Election First Past Post");
		assertEquals(el.getElectionID(), "sample_election_FPP");
		assertEquals(el.returnCandidates().size(), 3);
		// Check to see that validate user correctly identifies users
		assertTrue(el.validateUser("Alex","Fox","01-01-1997","S24EG"));
		assertTrue(el.validateUser("Aran","Bacall","01-01-1997","S24EG"));
		assertTrue(el.validateUser("Elliot","Howard","01-01-1997","S24EG"));
		// Check to see that a non-existing user is not validated
		assertFalse(el.validateUser("John","Smith","01-01-1997","S24EG"));
		resetDatabase();
	}
	
	@Test
	public void electionLoginTest() throws ParseException {
		resetDatabase();
		Election el = createElection(0);
		BallotItem cand1 = el.returnCandidates().get(0);
		// Make sure no user is logged in from creation
		assertEquals(el.getLoggedInUser(), null);
		// Make sure voting doesn't work when a user has not logged in
		assertFalse(el.castVote(cand1));
		// Check to see if user can log in
		assertTrue(el.login("Alex","Fox","01-01-1997","S24EG"));
		// Check to see that a voter has now been logged on
		assertTrue(el.getLoggedInUser() != null);
		// Check that casting a vote now works as a voter is logged in
		assertTrue(el.castVote(cand1));
		// Check to see that a user cannot vote if they have already voted in the election
		assertFalse(el.castVote(cand1));
		// Check to see if second user can log in
		assertTrue(el.login("Aran","Bacall","01-01-1997","S24EG"));
		// Check to see if second user can vote
		assertTrue(el.castVote(cand1));
		resetDatabase();
	}
	
	@Test
	public void electionCandidateTest() throws ParseException {
		resetDatabase();
		Election el = createElection(0);
		BallotItem cand1 = el.returnCandidates().get(0);
		BallotItem cand2 = el.returnCandidates().get(1);
		assertTrue(el.login("Alex","Fox","01-01-1997","S24EG"));
		el.castVote(cand1);
		// Check that vote has been logged
		assertTrue(el.getVoteCount(cand1).get(0) == 1);
		assertTrue(el.login("Aran","Bacall","01-01-1997","S24EG"));
		el.castVote(cand2);
		// Check that vote has been logged
		assertTrue(el.getVoteCount(cand2).get(0) == 1);
		resetDatabase();
		// Create a new election so voters can vote in another election
		el = createElection(0);
		cand1 = el.returnCandidates().get(0);
		assertTrue(el.login("Alex","Fox","01-01-1997","S24EG"));
		el.castVote(cand1);
		assertTrue(el.login("Aran","Bacall","01-01-1997","S24EG"));
		el.castVote(cand1);
		assertTrue(el.login("Elliot","Howard","01-01-1997","S24EG"));
		el.castVote(cand1);
		// Check that all three votes have been counted
		assertTrue(el.getVoteCount(cand1).get(0) == 3);
		resetDatabase();
	}
	
	@Test
	public void electionMultipleTest() throws ParseException {
		resetDatabase();
		// Check that an election of a different voting type can be created
		Election el = createElection(1);
		BallotItem cand1 = el.returnCandidates().get(0);
		BallotItem cand2 = el.returnCandidates().get(1);
		BallotItem cand3 = el.returnCandidates().get(2);
		ArrayList<BallotItem> cands = new ArrayList<BallotItem>();
		cands.add(cand1);
		cands.add(cand2);
		cands.add(cand3);
		// Check that voter can vote in instant run off elections without issue
		assertTrue(el.login("Alex","Fox","01-01-1997","S24EG"));
		assertTrue(el.castVote(cands));
		resetDatabase();
	}
	
	// Function used to create an election class
	private Election createElection(int electionType) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String startDateStr = "01-01-2019";
		String endDateStr = "01-04-2019";
			
			
		String electionID = "sample_election_FPP";
		String electionName = "Sample Election First Past Post";
		ArrayList<BallotItem> candidates = new ArrayList<>();
			
		candidates.add(new Candidate("cand1","Steven","Post",new Party("Labour")));
		candidates.add(new Candidate("cand2","Nigel","Field",new Party("Conservative")));
		candidates.add(new Candidate("cand3","David","Fence",new Party("Green")));
			
		
		VotingSystem voteSystem = new FirstPastPost(candidates);
		VotingSystem voteSystem2 = new InstantRunOff(candidates, 5);
		Date startTime = dateFormat.parse(startDateStr);
		Date endTime = dateFormat.parse(endDateStr);
			
		ElectoralRoll er = new ElectoralRoll();
			
		Election sample;
		
		if (electionType == 0) {
			sample = new Election(electionID, electionName, candidates, voteSystem, startTime, endTime, er);
		} else {
			sample = new Election(electionID, electionName, candidates, voteSystem2, startTime, endTime, er);
		}
		return sample;
	}
	
	private void resetDatabase() {
		Database db = new Database();
		db.setVoterVoted("Aran", "Bacall","01-01-1997","S24EG", false);
		db.setVoterVoted("Alex","Fox","01-01-1997","S24EG", false);
		db.setVoterVoted("Elliot","Howard","01-01-1997","S24EG", false);
	}

}
