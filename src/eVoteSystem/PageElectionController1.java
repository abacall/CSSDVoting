package eVoteSystem;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	
	SystemManager systemManager;

    @FXML
    private Label currentSelectedOptions;

    @FXML
    private Label totalOptions;

    @FXML
    private ListView<Election> electionsList;

    @FXML
    private Button confirmButton;

    public void initialize() {}


	public void initManager(SystemManager systemManager) {
		
		
		this.systemManager = systemManager;
		confirmButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {
		        String sessionID = "yes";
		        if (sessionID != null) {
		        	systemManager.selectedElection = electionsList.getSelectionModel().getSelectedItem();
		        	systemManager.showPageLogin2();
		        }
		      }
		    });
		
		
		if(systemManager.elections.size() < 2)
		{
			try {
				systemManager.elections.add(DataHandler.generateSampleDataFirstPastPost());
				systemManager.elections.add(DataHandler.generateSampleDataInstantRunOff());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		electionsList.setItems(FXCollections.observableArrayList(systemManager.elections));
		
	}
	
	private ArrayList<String> getElectionNames()
	{
		ArrayList<String> temp = new ArrayList<>();

		for(Election item : systemManager.elections)
		{
			temp.add(item.getName());
		}

		return temp;
	}

}

