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

    /**
     * Class for handling actions in the Completed Page
     */
	public void initManager(SystemManager systemManager) 
	{
		//Handle click for "Log Out" button
		logoutButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		      @Override public void handle(ActionEvent event) 
		      {
		    	  systemManager.selectedElection = null;
		    	  systemManager.showPageElection1();
		      }
		    });
	}
}
