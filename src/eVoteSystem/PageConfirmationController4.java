package eVoteSystem;

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
    private ListView<?> selectedVotesList;

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
		confirmButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {
		        String sessionID = "yes";
		        if (sessionID != null) {
		        	systemManager.showPageCompleted5();
		        }
		      }
		    });
		logoutButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {
		        String sessionID = "yes";
		        if (sessionID != null) {
		        	systemManager.showPageElection1();
		        }
		      }
		    });
	}
}
