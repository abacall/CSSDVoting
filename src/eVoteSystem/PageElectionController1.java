package eVoteSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PageElectionController1 {

    @FXML
    private Label currentSelectedOptions;

    @FXML
    private Label totalOptions;

    @FXML
    private ListView<?> listView;

    @FXML
    private Button confirmButton;

    @FXML
    void handleConfirmButtonAction(ActionEvent event) {
    	confirmButton.setText("clicked");

    }

}

