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

public class DataHandler {

	String filename =  "elections.save";
	
	public void saveData(List<Election> election)
	{
		try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
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
