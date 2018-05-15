package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LibraryController{

    @FXML private TextField name;
    @FXML private TextField libId;
    @FXML private TextField countryId;
    @FXML private Label label;

    private Main main;

    public void setMain(Main main){
        this.main=main;
    }

    public void create(ActionEvent event){
        main.lib.setName(name.getText());
        main.lib.setLibId(libId.getText());
        try {
            main.lib.setContryId(Integer.parseInt(countryId.getText()));
        }catch (NumberFormatException e) {
            label.setText("Enter country ID, please.");
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
}
