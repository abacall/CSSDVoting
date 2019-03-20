package eVoteSystem;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PageAdminController {

	  	@FXML
	    private Label electionNameLabel;

	    @FXML
	    private ListView<String> adminListView;

	    @FXML
	    private Label totalVotesLabel;

	    @FXML
	    private Button logoutButton;

	    @FXML
	    private TextField passwordText;

	    @FXML
	    private TextField usernameText;

	    @FXML
	    private Button loginButton;

	    /**
	     * Class for handling actions in the Admin Panel
	     */
	    public void initManager(SystemManager systemManager) 
	    {
	    	//Handles click for the "LogOut" button
	    	logoutButton.setOnAction(new EventHandler<ActionEvent>() 
	    	{
	    		@Override public void handle(ActionEvent event) 
	    		{
	    			systemManager.showPageElection1();
	    		}
		    });
	    	
	    	//Handles click for the "Login" button
	    	loginButton.setOnAction(new EventHandler<ActionEvent>() 
	    	{
	    		@Override public void handle(ActionEvent event) 
	    		{
		        	//Get text from username and password fields
		        	String username = passwordText.getText();
		        	String password = usernameText.getText();
		        	
		        	//Checks admin credentials 
		        	if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
		        	{
		        			ArrayList<String> voteText = new ArrayList<>(); 
		        			
		        			//Collects the votes from each candidate
		        			for(BallotItem item : systemManager.selectedElection.returnCandidates())
		        			{
		        				String name = item.getName();
		        				int count = systemManager.selectedElection.getVoteCount(item).get(0);
		        				
		        				voteText.add(name + " : " + count);
		        			}

		        			adminListView.setItems(FXCollections.observableArrayList(voteText));
		        	}
		        }
		    });
	    }


}
