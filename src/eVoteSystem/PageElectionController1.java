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
    private Button button_confirm_page1;

    @FXML
    void handleSubmitButtonAction(ActionEvent event) {
    	button_confirm_page1.setText("clicked");

    }

}
