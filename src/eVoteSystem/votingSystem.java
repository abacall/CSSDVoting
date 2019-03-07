package eVoteSystem;

public interface votingSystem {
	
	public int voteCount = 0;
	
	public boolean castVote(standing cand);
	public void getVotes();
}
