package eVoteSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.sun.javafx.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SystemManager {
	  private Scene scene;

	  public ArrayList<Election> elections;
	  public Election selectedElection;
	  public ArrayList<BallotItem> selectedCandidates;

	  public SystemManager(Scene scene) {
		  elections = new ArrayList<>();
		  selectedCandidates = new ArrayList<>();
		    this.scene = scene;
		  }


	  /**
	   * Callback method invoked to notify that a user has logged out of an election.
	   * Will show the login screen.
	   */
	  public void logout() {
		  showPageElection1();
	  }

	  /**
	   * Shows Election page
	   */
	  public void showPageElection1() {
	    try {
	      FXMLLoader loader = new FXMLLoader(
	        new File("Page_Election_Selection_1.fxml").toURI().toURL()
	      );

	      scene.setRoot((Parent) loader.load());
	      PageElectionController1 controller =
	        loader.<PageElectionController1>getController();

	      	controller.initManager(this);

	    } catch (IOException ex) {
	    }
	  }

	  /**
	   * Shows Login page
	   */
	  public void showPageLogin2() {
		    try {
		      FXMLLoader loader = new FXMLLoader(
		        new File("Page_User_Login_2.fxml").toURI().toURL()
		      );
		      scene.setRoot((Parent) loader.load());
		      PageLoginController2 controller =
		        loader.<PageLoginController2>getController();

		      controller.initManager(this);

		    } catch (IOException ex) {
		    }
		  }

	  /**
	   * Shows Candidate Selection page
	   */
	  public void showPageSelection3() {
		    try {
		      FXMLLoader loader = new FXMLLoader(
		        new File("Page_Vote_Selection_3.fxml").toURI().toURL()
		      );
		      scene.setRoot((Parent) loader.load());
		      PageSelectionController3 controller =
		        loader.<PageSelectionController3>getController();

		      controller.initManager(this);

		    } catch (IOException ex) {
		    }
		  }

	  /**
	   * Shows Confirmation page
	   */
	  public void showPageConfirmation4() {
		    try {
		      FXMLLoader loader = new FXMLLoader(
		        new File("Page_Vote_Confirmation_4.fxml").toURI().toURL()
		      );
		      scene.setRoot((Parent) loader.load());
		      PageConfirmationController4 controller =
		        loader.<PageConfirmationController4 >getController();

		      controller.initManager(this);

		    } catch (IOException ex) {
		    }
		  }

	  /**
	   * Shows Completed page
	   */
	  public void showPageCompleted5() {
		    try {
		      FXMLLoader loader = new FXMLLoader(
		        new File("Page_Vote_Completed_5.fxml").toURI().toURL()
		      );
		      scene.setRoot((Parent) loader.load());
		      PageCompletedController5 controller =
		        loader.<PageCompletedController5>getController();

		      controller.initManager(this);

		    } catch (IOException ex) {
		    }
		  }

	  /**
	   * Shows Admin page
	   */
	  public void showPageAdmin() {
		    try {
		      FXMLLoader loader = new FXMLLoader(
		        new File("Page_Admin_Panel.fxml").toURI().toURL()
		      );
		      scene.setRoot((Parent) loader.load());
		      PageAdminController controller =
		        loader.<PageAdminController>getController();

		      controller.initManager(this);

		    } catch (IOException ex) {
		    }
		  }


	}
