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

	public void initManager(SystemManager systemManager) {
		
		logoutButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {
		        String sessionID = "yes";
		        if (sessionID != null) {
		        	systemManager.showPageElection1();
		        }
		      }
		    });

		loginButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {
		        String sessionID = "yes";
		        if (sessionID != null) {
//		        	systemManager.showPageElection1();
		        	String username = passwordText.getText();
		        	String password = usernameText.getText();
		        	
		        	if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
		        	{
		        			ArrayList<String> voteText = new ArrayList<>(); 
		        		
		        			for(BallotItem item : systemManager.selectedElection.returnCandidates())
		        			{
		        				String name = item.getName();
		        				int count = systemManager.selectedElection.getVoteCount(item).get(0);
		        				
		        				voteText.add(name + " : " + count);
		        			}

		        			adminListView.setItems(FXCollections.observableArrayList(voteText));
		        	}
		        	
		        	
		        	
		        }
		      }
		    });
	}


}
