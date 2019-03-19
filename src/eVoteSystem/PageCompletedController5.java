package eVoteSystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class PageCompletedController5 {

    @FXML
    private AnchorPane Page_Vote_Completed_5;

    @FXML
    private Button logoutButton;

    @FXML
    private Label currentElectionLabel;

    @FXML
    private Label currrentUserLabel;

	public void initManager(SystemManager systemManager) {
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
