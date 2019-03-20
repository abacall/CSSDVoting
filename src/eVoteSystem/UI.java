
package eVoteSystem;

import java.io.File;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class UI extends Application {


	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(
			        new File("Page_Election_Selection_1.fxml").toURI().toURL());
		Parent root = loader.load();

		// Create the Scene
		Scene scene = new Scene(root);

		SystemManager systemManager = new SystemManager(scene);

		systemManager.showPageElection1();

		// Set the Scene to the Stage
		primaryStage.setScene(scene);

		// Display the Stage
		primaryStage.show();


	}


}