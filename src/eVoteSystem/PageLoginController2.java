package eVoteSystem;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PageLoginController2 {

    @FXML
    private AnchorPane Page_User_Login_2;

    @FXML
    private TextField forenameText;

    @FXML
    private TextField surnameText;

    @FXML
    private DatePicker dobPicker;

    @FXML
    private TextField postcodeText;

    @FXML
    private Button loginButton;

    @FXML
    private Button logoutButton;

    @FXML
    void handleLogoutButtonAction(ActionEvent event) {

    }

	public void initManager(SystemManager systemManager) {
		
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
		      @Override public void handle(ActionEvent event) {
		        String sessionID = "yes";
		        if (sessionID != null) {
		        	
		        	String firstName = forenameText.getText();
		        	String lastName = surnameText.getText();
		        	String postcode = postcodeText.getText();
		        	String date = dobPicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
		        	
		        	if(firstName.equalsIgnoreCase("admin") && firstName.equalsIgnoreCase(lastName))
		        		systemManager.showPageAdmin();
		        	else if(systemManager.selectedElection.validateUser(firstName, lastName, date, postcode))
		        		systemManager.showPageSelection3();
		        	else
		        		systemManager.showPageElection1();
		        	
		        	
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
