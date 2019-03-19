package eVoteSystem;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

    @FXML
    void handleLoginButtonAction(ActionEvent event) throws IOException {
    	FXMLLoader loader = null;
		try {
			loader = new FXMLLoader(new File("Page_User_Login_2.fxml").toURI().toURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Parent root = loader.load();
		Stage stage = (Stage) confirmButton.getScene().getWindow();
		// Create the Scene
		Scene scene = new Scene(root);
		stage.setScene(scene);
    }

    @FXML
    void handleLogoutButtonAction(ActionEvent event) {

    }

	public void initManager(SystemManager systemManager) {
		
		this.systemManager = systemManager;
		
		confirmButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {
		        String sessionID = "yes";
		        if (sessionID != null) {
		        	
		        	String candidateName = ballotList.getSelectionModel().getSelectedItem();
		        	systemManager.selectedCandidates.add(getCandidate(candidateName)); 
		        	
		        	systemManager.showPageConfirmation4();
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
		
		ballotList.setItems(FXCollections.observableArrayList(getCandidateNames()));
		
	}
	
	private ArrayList<String> getCandidateNames()
	{
		ArrayList<String> temp = new ArrayList<>();

		for(BallotItem item : systemManager.selectedElection.returnCandidates())
		{
			temp.add(item.getName());
		}

		return temp;
	}
	
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
