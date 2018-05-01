package sample;

import exceptions.LibraryNotFoundException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Library;
import net.NetworkHelper;

import java.io.IOException;

public class Controller {

    //Views
    @FXML private Label label;

    private Main main;
    Library lib=new Library();

    public void setMain(Main main){
        this.main=main;
    }

    public void closeApp(){
        NetworkHelper.disconnect();
        Platform.exit();
        System.exit(0);
    }

    public void createLib(){
        try {
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader(Main.class.getResource("library.fxml"));
            AnchorPane pane=loader.load();

            LibraryController libController=new LibraryController();
            libController.setLib(lib);

            primaryStage.setScene(new Scene(pane, 600, 250));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleButton(){
        try {
            if(lib.getName()==null) throw new LibraryNotFoundException("Create library or load it from DB.");
            label.setText(lib.toString());
        } catch(LibraryNotFoundException noLib){
            label.setText(noLib.getMessage());
        }
    }
    public void loadLib(){
        NetworkHelper.passValue(1,lib);
    }
}
