package eVoteSystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataHandler {

	public void saveData()
	{}
	
	public void loadData()
	{}
	
	public static Election generateSampleDataFirstPastPost() throws ParseException
	{
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
		Date startTime = dateFormat.parse(startDateStr);
		Date endTime = dateFormat.parse(endDateStr);
		
		
		Election sample = new Election(electionID, electionName, candidates, voteSystem, startTime, endTime);
		
		return sample;
		
	}
	
	public static Election generateSampleDataInstantRunOff() throws ParseException
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String startDateStr = "01-01-2019";
		String endDateStr = "01-04-2019";
		
		
		String electionID = "sample_election_IRO";
		String electionName = "Sample Election Instant Run Off";
		ArrayList<BallotItem> candidates = new ArrayList<>();
		
		candidates.add(new Candidate("cand1","Steven","Post",new Party("Labour")));
		candidates.add(new Candidate("cand2","Nigel","Field",new Party("Conservative")));
		candidates.add(new Candidate("cand3","David","Fence",new Party("Green")));
		
		
		VotingSystem voteSystem = new InstantRunOff(candidates, 2);
		Date startTime = dateFormat.parse(startDateStr);
		Date endTime = dateFormat.parse(endDateStr);
		
		
		Election sample = new Election(electionID, electionName, candidates, voteSystem, startTime, endTime);
		
		return sample;
		
	}
}
