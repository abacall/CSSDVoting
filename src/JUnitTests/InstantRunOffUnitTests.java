package JUnitTests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import eVoteSystem.BallotItem;
import eVoteSystem.Candidate;
import eVoteSystem.InstantRunOff;
import eVoteSystem.Party;

import org.junit.Test;

public class InstantRunOffUnitTests {

	@Test
	public void iROCorrectConstructTest() {
		List<BallotItem> cands = new ArrayList<BallotItem>();
		Party party = new Party("Conservatives");
		Candidate cand = new Candidate("1", "John", "Smith", party);
		cands.add(cand);
		int noOfPref = 5;
		InstantRunOff iro = new InstantRunOff(cands, noOfPref);
		// Test instant run off number of preferences was set correctly
		assertTrue(iro.getNumPreferences() == noOfPref);
		// Test instant run off candidate exists in the class
		assertTrue(iro.getVotes(cand) != null);
		// Test instant run off candidate preference array is the correct size
		assertEquals(iro.getVotes(cand).size(), noOfPref);
		// Test that preference votes all initiate at 0
		for (int i = 0; i < noOfPref; i++) {
			assertTrue(iro.getVotes(cand).get(i) == 0);
		}
	}
	
	@Test
	public void castingVoteTest() {
		List<BallotItem> cands = new ArrayList<BallotItem>();
		Party party = new Party("Conservatives");
		Candidate cand = new Candidate("1", "John", "Smith", party);
		cands.add(cand);
		int noOfPref = 5;
		InstantRunOff iro = new InstantRunOff(cands, noOfPref);
		// Tests that all the castings of votes are successful
		assertEquals(iro.castVote(cand, 0), true);
		assertEquals(iro.castVote(cand, 0), true);
		assertEquals(iro.castVote(cand, 1), true);
		// Test that the top preference contains two votes
		assertTrue(iro.getVotes(cand).get(0) == 2);
		// Test that the second preference contains one vote
		assertTrue(iro.getVotes(cand).get(1) == 1);
		// Checks that functionality continues after accessing votes
		assertEquals(iro.castVote(cand, 1), true);
		assertTrue(iro.getVotes(cand).get(1) == 2);
		// Checks that it is not possible to increment preference beyond preference index
		assertEquals(iro.castVote(cand, 10), false);
		// Checks that functionality continues after false casting
		assertTrue(iro.getVotes(cand).get(1) == 2);
	}

}
