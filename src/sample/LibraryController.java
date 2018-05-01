package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Library;

import java.net.URL;
import java.util.ResourceBundle;

public class LibraryController{

    Library lib;

    @FXML private TextField name;
    @FXML private TextField libId;
    @FXML private TextField countryId;
    @FXML private Label label;

    public void setLib(Library lib){
        this.lib=lib;
    }

    public void create(ActionEvent event){
        lib.setName(name.getText());
        lib.setLibId(libId.getText());
        try {
            lib.setContryId(Integer.parseInt(countryId.getText()));
        }catch (NumberFormatException e) {
            label.setText("Enter country ID, please.");
        }
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
}
