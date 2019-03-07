package eVoteSystem;
import java.util.ArrayList;
import java.util.Date;


public class election {

	private String electionID;
	private electoralRoll voters;
	private ArrayList<standing> candidates;
	private votingSystem voteSystem;
	private ArrayList<administrator> administrators;
	public Date startTime;
	public Date endTime;
	
	public election()
	{
		
	}
	
	public ArrayList<standing> returnCandidates()
	{}
	
	public String returnError()
	{}
	
	public boolean validateUser()
	{}
	
	public boolean castVote()
	{}
	
	public void login()
	{}
	
	public void adminLogin()
	{}
	
	public int getVoteCount()
	{}
	
}
