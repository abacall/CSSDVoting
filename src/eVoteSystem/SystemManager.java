package eVoteSystem;

import java.io.File;
import java.io.IOException;

import com.sun.javafx.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SystemManager {
	  private Scene scene;


	  public SystemManager(Scene scene) {
		    this.scene = scene;
		  }


	  /**
	   * Callback method invoked to notify that a user has logged out of an election.
	   * Will show the login screen.
	   */
	  public void logout() {
		  showPageElection1();
	  }

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


	}
