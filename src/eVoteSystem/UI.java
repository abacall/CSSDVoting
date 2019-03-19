package eVoteSystem;

import java.awt.List;
import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

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

		// scene.getStylesheets().add(getClass().getResource("theme.css").toExternalForm());
		// scene.getStylesheets().add(getClass().getResource("theme.css").toExternalForm());

//		URL url = this.getClass().getResource("theme.css");
//		if (url != null) {
//			String css = url.toExternalForm();
//			scene.getStylesheets().add(css);
//		}


		 SystemManager systemManager = new SystemManager(scene);

		 systemManager.showPageElection1();

		// Set the Scene to the Stage
		primaryStage.setScene(scene);

		// Display the Stage
		primaryStage.show();

		// Set the Title to the Stage
		//primaryStage.setTitle("CSSD");

		//addListItems(scene);




	}


}
