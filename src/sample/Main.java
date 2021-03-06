package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.NetworkHelper;

import java.io.*;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage){

        NetworkHelper.connect();

        primaryStage.setTitle("Library wizard");
        this.primaryStage=primaryStage;
        mainWindow();
    }

    public void mainWindow(){
        try {
            FXMLLoader loader=new FXMLLoader(Main.class.getResource("sample.fxml"));
            AnchorPane pane=loader.load();

            Controller mainController=loader.getController();
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
