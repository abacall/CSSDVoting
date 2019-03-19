package eVoteSystem;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class PageConfirmationController4 {

    @FXML
    private AnchorPane Page_Vote_Confirmation_4;

    @FXML
    private ListView<BallotItem> selectedVotesList;

    @FXML
    private Button confirmButton;

    @FXML
    private Button logoutButton;

    @FXML
    void handleConfirmButtonAction(ActionEvent event) {

    }

    @FXML
    void handleLogoutButtonAction(ActionEvent event) {

    }

	public void initManager(SystemManager systemManager) {
		
		selectedVotesList.setItems(FXCollections.observableArrayList(systemManager.selectedCandidates));
		
		confirmButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {
		        String sessionID = "yes";
		        if (sessionID != null) {
		        	
		        	for(BallotItem item : systemManager.selectedCandidates)
		        		systemManager.selectedElection.castVote(item);
		        	
		        	systemManager.selectedElection = null;
		        	systemManager.selectedCandidates.clear();
		        	
		        	systemManager.showPageCompleted5();
		        }
		      }
		    });
		logoutButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {
		        String sessionID = "yes";
		        if (sessionID != null) {
		        	systemManager.selectedElection = null;
		        	systemManager.showPageElection1();
		        }
		      }
		    });
	}
}
