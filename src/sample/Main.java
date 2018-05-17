package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Library;
import model.User;
import net.NetworkHelper;

import java.io.*;

public class Main extends Application {

    private Stage primaryStage;
    Controller mainController;

    Library lib = new Library();
    User user=new User();

    @Override
    public void start(Stage primaryStage){

        loginWindow();

       /* primaryStage.setTitle("Library wizard");
        this.primaryStage=primaryStage;
        mainWindow();*/
    }

    public void loginWindow(){
        try{
            NetworkHelper.connect();

            Stage loginStage=new Stage();
            FXMLLoader loader=new FXMLLoader(Main.class.getResource("login.fxml"));
            AnchorPane loginPane=loader.load();

            LoginController loginController=loader.getController();
            loginController.setMain(this);

            loginStage.setScene(new Scene(loginPane));
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mainWindow(){
        try {
            FXMLLoader loader=new FXMLLoader(Main.class.getResource("sample.fxml"));
            AnchorPane pane=loader.load();

            mainController=loader.getController();
            mainController.setMain(this);

            primaryStage.setScene(new Scene(pane, 810, 520));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
