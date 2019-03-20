package eVoteSystem;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class PageSelectionController3 {

	SystemManager systemManager;
	
    @FXML
    private AnchorPane Page_Vote_Selection_3;

    @FXML
    private Label currrentUserLabel;

    @FXML
    private Label currentElectionLabel;

    @FXML
    private Label totalOptions1;

    @FXML
    private Label currentSelectedOptions;

    @FXML
    private Label totalOptions2;

    @FXML
    private ListView<String> ballotList;

    @FXML
    private Button confirmButton;

    @FXML
    private Button logoutButton;


    /**
     * Method for handling actions in the Candidate Selection page
     */
	public void initManager(SystemManager systemManager) {
		
		this.systemManager = systemManager;
		
		//Handle "Confirm" button click
		confirmButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {
		    	  //Set selected candidates from list
		    	  String candidateName = ballotList.getSelectionModel().getSelectedItem();
		    	  systemManager.selectedCandidates.add(getCandidate(candidateName)); 
		    	  systemManager.showPageConfirmation4();
		      }
		    });
		
		//Handle "Log Out" button click
		logoutButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {

		        	systemManager.selectedElection = null;
		        	systemManager.showPageElection1();
		        
		      }
		    });
		
		ballotList.setItems(FXCollections.observableArrayList(getCandidateNames()));
		
	}
	
	/**
	 * Get candidate names from selected election
	 */
	private ArrayList<String> getCandidateNames()
	{
		ArrayList<String> temp = new ArrayList<>();

		for(BallotItem item : systemManager.selectedElection.returnCandidates())
		{
			temp.add(item.getName());
		}

		return temp;
	}
	
	/**
	 * Get candidate based on name
	 */
	private BallotItem getCandidate(String name)
	{
		for(BallotItem item : systemManager.selectedElection.returnCandidates())
		{
			if (item.getName().equalsIgnoreCase(name))
				return item;
		}
		
		return null;
	}

}
