package eVoteSystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PageAdminController {

    @FXML
    private Label electionNameLabel;

    @FXML
    private ListView<?> adminListView;

    @FXML
    private Label totalVotesLabel;

    @FXML
    private Button adminLogoutButton;


	public void initManager(SystemManager systemManager) {
		adminLogoutButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {
		        String sessionID = "yes";
		        if (sessionID != null) {
		        	systemManager.showPageElection1();
		        }
		      }
		    });
	}
}
