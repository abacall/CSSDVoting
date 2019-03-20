package eVoteSystem;

import java.text.ParseException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PageElectionController1 {
	
	SystemManager systemManager;

    @FXML
    private Label currentSelectedOptions;

    @FXML
    private Label totalOptions;

    @FXML
    private ListView<String> electionsList;

    @FXML
    private Button confirmButton;

    public void initialize() {}

    /**
     * Method for handling actions in the Election page
     */
	public void initManager(SystemManager systemManager) {
		
		
		this.systemManager = systemManager;
		confirmButton.setOnAction(new EventHandler<ActionEvent>() 
		{
		      @Override public void handle(ActionEvent event) 
		      {
		    	  //Get selected election from list
		    	  String electionName = electionsList.getSelectionModel().getSelectedItem();
		    	  //Set selected election
		    	  systemManager.selectedElection = getElection(electionName);
		    	  systemManager.showPageLogin2();
		      }
		});
		
		//If there are no elections then generate sample data
		if(systemManager.elections.size() == 0)
		{
			try {
				systemManager.elections.add(DataHandler.generateSampleDataFirstPastPost());
				systemManager.elections.add(DataHandler.generateSampleDataInstantRunOff());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		electionsList.setItems(FXCollections.observableArrayList(getElectionNames()));
		
	}
	
	/**
	 * Gets election names from SystemManager
	 */
	private ArrayList<String> getElectionNames()
	{
		ArrayList<String> temp = new ArrayList<>();

		for(Election item : systemManager.elections)
		{
			temp.add(item.getName());
		}

		return temp;
	}
	
	/**
	 * Gets election based on name
	 */
	private Election getElection(String name)
	{
		for(Election item : systemManager.elections)
		{
			if (item.getName().equalsIgnoreCase(name))
				return item;
		}
		
		return null;
	}

}

