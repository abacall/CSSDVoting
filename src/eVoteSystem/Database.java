package eVoteSystem;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.BasicDBList;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;

public class Database {
	
	private MongoClient mongo;
	private MongoDatabase db;
	
	/**
	 * Creates a client and connects to the database server, switches to the correct database
	 */
	public Database() {
		mongo = new MongoClient( "localhost" , 27017 );	
		db = mongo.getDatabase("votingSystem");
	}
	
	/**
	 * Query's the database for a voter, given the voters details
	 * 
	 * @return 		voter queried when successful, null if the voter doesn't exist   
	 */
	public Voter getVoter(String firstName, String lastName, String doB, String postcode) {
		MongoCollection<Document> collection = db.getCollection("voters");
		
		Document myDoc = null;
		// Iterates through all documents in collection to find voter
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
		    while (cursor.hasNext()) {
		    	Document doc = cursor.next();
		    	if (doc.get("FirstName").toString().equals(firstName) && doc.get("LastName").toString().equals(lastName) 
		    			&& doc.get("DateOfBirth").toString().equals(doB) && doc.get("PostCode").toString().equals(postcode)) {
		    		myDoc = doc;
		    	}
		    }
		} finally {
		    cursor.close();
		}
		
		if (myDoc == null) {
			return null;
		}
		
		// Creates a voter object based on database store
		Voter voter = new Voter(myDoc.get("VoterId").toString(), myDoc.get("FirstName").toString(), myDoc.get("LastName").toString(), 
				myDoc.get("PostCode").toString(), myDoc.get("DateOfBirth").toString());
		
		// Sets voters voted status from database store
		voter.setVoted(myDoc.getBoolean("HasVoted"));
		
		return voter;
	}
	
	/**
	 * Sets a given voter's voted status to voted, can also set to not-voted but this functionality should only be used in testing
	 * 
	 * @return 		true for success, false for failure     
	 */
	public Boolean setVoterVoted(String firstName, String lastName, String doB, String postcode, boolean voted) {
		MongoCollection<Document> collection = db.getCollection("voters");
		
		Document myDoc = null;
		// Iterates through all documents in collection to find voter
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
		    while (cursor.hasNext()) {
		    	Document doc = cursor.next();
		    	if (doc.get("FirstName").toString().equals(firstName) && doc.get("LastName").toString().equals(lastName) 
		    			&& doc.get("DateOfBirth").toString().equals(doB) && doc.get("PostCode").toString().equals(postcode)) {
		    		myDoc = doc;
		    	}
		    }
		} finally {
		    cursor.close();
		}
		
		if (myDoc == null) {
			return false;
		}
		
		// Updates the voter in the database with new voted status
		collection.updateOne(myDoc, new Document("$set", new Document("HasVoted", voted)));
		return true;
	}
	
	/**
	 * Gets a given voter's voted status
	 * 
	 * @return 		whether or not the given voter has voted   
	 */
	public boolean getVoterVoted(String firstName, String lastName, String doB, String postcode) {
		MongoCollection<Document> collection = db.getCollection("voters");
		
		Document myDoc = null;
		// Iterates through all documents in collection to find voter
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
		    while (cursor.hasNext()) {
		    	Document doc = cursor.next();
		    	if (doc.get("FirstName").toString().equals(firstName) && doc.get("LastName").toString().equals(lastName) 
		    			&& doc.get("DateOfBirth").toString().equals(doB) && doc.get("PostCode").toString().equals(postcode)) {
		    		myDoc = doc;
		    	}
		    }
		} finally {
		    cursor.close();
		}
		
		if (myDoc == null) {
			return false;
		}
		
		return myDoc.getBoolean("HasVoted");
	}
	
	
}
