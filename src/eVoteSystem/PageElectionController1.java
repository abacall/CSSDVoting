package eVoteSystem;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.Window;

public class PageElectionController1 {

    @FXML
    private Label currentSelectedOptions;

    @FXML
    private Label totalOptions;

    @FXML
    private ListView<?> electionsList;

    @FXML
    private Button confirmButton;

    public void initialize() {}


	public void initManager(SystemManager systemManager) {
		confirmButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {
		        String sessionID = "yes";
		        if (sessionID != null) {
		        	systemManager.showPageLogin2();
		        }
		      }
		    });
	}

}

