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

public class UI extends Application {

	static ArrayList<Election> elections;

	public static void main(String[] args) {

		elections = new ArrayList<>();

		try {
			elections.add(DataHandler.generateSampleData());
		} catch (ParseException e) {
			e.printStackTrace();
		}

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

		addListItems(scene);
		// Display the Stage
		primaryStage.show();

	}


	public void addListItems(Scene scene) {

		ObservableList<String> items = FXCollections.observableArrayList(getElectionNames());
		@SuppressWarnings("unchecked")
		ListView<String> list = (ListView<String>) scene.lookup("#electionsList");
		list.setItems(items);
	}

	private ArrayList<String> getElectionNames()
	{
		ArrayList<String> temp = new ArrayList<>();

		for(Election item : elections)
		{
			temp.add(item.getName());
		}

		return temp;

	}

}
