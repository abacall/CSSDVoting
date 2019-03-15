package eVoteSystem;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

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
