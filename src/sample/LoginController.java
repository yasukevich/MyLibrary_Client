package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.NetworkHelper;

public class LoginController {

    @FXML private TextField name;
    @FXML private TextField pass;
    @FXML private Label label;

    private Main main;

    public void setMain(Main main){
        this.main=main;
    }

    public void check(ActionEvent event){
        main.user.setName(name.getText());
        main.user.setPass(pass.getText());
        NetworkHelper.passValue(1,main.user);
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
}
