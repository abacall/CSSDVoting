package eVoteSystem;

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
	    private ListView<?> adminListView;

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
		        }
		      }
		    });
	}


}
