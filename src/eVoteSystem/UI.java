package eVoteSystem;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

public class UI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(new File("Page_Election_Selection_1.fxml").toURI().toURL());
		Parent root = loader.load();

		// Create the Scene
		Scene scene = new Scene(root);

		// scene.getStylesheets().add(getClass().getResource("theme.css").toExternalForm());
		// scene.getStylesheets().add(getClass().getResource("theme.css").toExternalForm());

		URL url = this.getClass().getResource("theme.css");
		if (url != null) {
			String css = url.toExternalForm();
			scene.getStylesheets().add(css);
		}

		// Set the Scene to the Stage
		primaryStage.setScene(scene);
		// Skin with with the CSS
		// Set the Title to the Stage
		primaryStage.setTitle("CSSD");

		addSampleListItems(scene);
		// Display the Stage
		primaryStage.show();

	}

	public void addSampleListItems(Scene scene) {
		ObservableList<String> items = FXCollections.observableArrayList("A", "B", "C", "D");
		@SuppressWarnings("unchecked")
		ListView<String> list = (ListView<String>) scene.lookup("#listView");
		list.setItems(items);
	}

}
