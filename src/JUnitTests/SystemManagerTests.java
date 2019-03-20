package JUnitTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import eVoteSystem.SystemManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import org.junit.Test;

public class SystemManagerTests {

	@Test
	public void electionTest() throws IOException {
		// Test constructor for page type, make sure no exceptions are thrown
		SystemManager sys = createSystemManager("Page_Election_Selection_1.fxml");	
		// Test function for page type, make sure no exceptions are thrown
		sys.showPageElection1();
	}
	
	@Test
	public void userLoginTest() throws IOException {
		// Test constructor for page type, make sure no exceptions are thrown
		SystemManager sys = createSystemManager("Page_User_Login_2.fxml");	
		// Test function for page type, make sure no exceptions are thrown
		sys.showPageLogin2();
	}
	
	@Test
	public void voteSelectionTest () throws IOException {
		// Test constructor for page type, make sure no exceptions are thrown
		SystemManager sys = createSystemManager("Page_Vote_Selection_3.fxml");	
		// Test function for page type, make sure no exceptions are thrown
		sys.showPageSelection3();
	}
	
	@Test
	public void voteConfirmationTest() throws IOException {
		// Test constructor for page type, make sure no exceptions are thrown
		SystemManager sys = createSystemManager("Page_Vote_Confirmation_4.fxml");	
		// Test function for page type, make sure no exceptions are thrown
		sys.showPageConfirmation4();
	}
	
	@Test
	public void completedTest() throws IOException {
		// Test constructor for page type, make sure no exceptions are thrown
		SystemManager sys = createSystemManager("Page_Vote_Completed_5.fxml");	
		// Test function for page type, make sure no exceptions are thrown
		sys.showPageCompleted5();
	}
	
	@Test
	public void adminPanelTest() throws IOException {
		// Test constructor for page type, make sure no exceptions are thrown
		SystemManager sys = createSystemManager("Page_Admin_Panel.fxml");	
		// Test function for page type, make sure no exceptions are thrown
		sys.showPageAdmin();
	}
	
	private SystemManager createSystemManager(String page) throws IOException {
		FXMLLoader loader = new FXMLLoader(
		        new File(page).toURI().toURL());
		Parent root = loader.load();

		// Create the Scene
		Scene scene = new Scene(root);

		SystemManager systemManager = new SystemManager(scene);
		
		return systemManager;
	}

}
