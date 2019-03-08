package eVoteSystem;

public interface VotingSystem {
	
	public int voteCount = 0;
	
	public boolean castVote(Standing cand);
	public void getVotes();
}
