package eVoteSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class for manipulating data 
 */
public class DataHandler {

	String filename =  "elections.save";
	
	/**
	 * Saves the of list of elections 
	 */
	public void saveData(List<Election> election)
	{
		try
        {   
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
             
            out.writeObject(election); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        }
	}
	
	/**
	 * Loads the of list of elections 
	 */
	public List<Election> loadData()
	{
		List<Election> returnList = new ArrayList<>();
		
		try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            returnList = (List<Election>)in.readObject(); 
              
            in.close(); 
            file.close(); 
            
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return returnList;
	}
	
	/**
	 * Returns a populated First Past the Post election
	 */
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
		
		Voter v1 = new Voter("v1","Alex","Fox","S24EG","01-01-1997");
		Voter v2 = new Voter("v2","Aran","Bacall","S24EG","01-01-1997");
		Voter v3 = new Voter("v3","Elliot","Howard","S24EG","01-01-1997");
		
		List<Voter> voters = new ArrayList<Voter>();
		voters.add(v1);
		voters.add(v2);
		voters.add(v3);
		
		ElectoralRoll er = new ElectoralRoll(voters);
		
		Election sample = new Election(electionID, electionName, candidates, voteSystem, startTime, endTime, er);
		
		Administrator admin = new Administrator("admin","admin");
		
		sample.addAdministrator(admin);
		
		return sample;
		
	}
	
	/**
	 * Returns a populated Instant Run-Off election
	 */
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
		
		Voter v1 = new Voter("v1","Alex","Fox","S24EG","01-01-1997");
		Voter v2 = new Voter("v2","Aran","Bacall","S24EG","01-01-1997");
		Voter v3 = new Voter("v3","Elliot","Howard","S24EG","01-01-1997");
		
		List<Voter> voters = new ArrayList<Voter>();
		voters.add(v1);
		voters.add(v2);
		voters.add(v3);
		
		ElectoralRoll er = new ElectoralRoll(voters);
		
		Election sample = new Election(electionID, electionName, candidates, voteSystem, startTime, endTime, er);
		
		return sample;
		
	}
}
