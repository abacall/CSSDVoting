package JUnitTests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import eVoteSystem.BallotItem;
import eVoteSystem.Candidate;
import eVoteSystem.FirstPastPost;
import eVoteSystem.Party;

import org.junit.Test;

public class FirstPastPostTests {

	@Test
	public void fPPCorrectConstructTest() {
		List<BallotItem> cands = new ArrayList<BallotItem>();
		Party party = new Party("Conservatives");
		Candidate cand = new Candidate("1", "John", "Smith", party);
		cands.add(cand);
		FirstPastPost fpp = new FirstPastPost(cands);
		// Test that the added candidate exists within the class
		assertTrue(fpp.getVotes(cand) != null);
		// Test first past post votes array is the correct size of 1
		assertEquals(fpp.getVotes(cand).size(), 1);
		// Test first past post vote starts at 0
		assertTrue(fpp.getVotes(cand).get(0) == 0);
	}
	
	@Test
	public void castingVoteTest() {
		List<BallotItem> cands = new ArrayList<BallotItem>();
		Party party = new Party("Conservatives");
		Candidate cand = new Candidate("1", "John", "Smith", party);
		cands.add(cand);
		FirstPastPost fpp = new FirstPastPost(cands);
		// Tests that all the castings of votes are successful
		assertEquals(fpp.castVote(cand), true);
		assertEquals(fpp.castVote(cand), true);
		assertEquals(fpp.castVote(cand), true);
		// Test that candidate has been voted for 3 times
		assertTrue(fpp.getVotes(cand).get(0) == 3);
		// Checks that functionality continues after accessing votes
		assertEquals(fpp.castVote(cand), true);
		assertTrue(fpp.getVotes(cand).get(0) == 4);
	}
}
