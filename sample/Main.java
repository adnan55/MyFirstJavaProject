package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    @Override

    // Login page will Appear in Main Method.
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
       Scene scene = new Scene(root);
       scene.setRoot(root);
       primaryStage.setResizable(false);
       primaryStage.setScene(scene);
       primaryStage.centerOnScreen();

       primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);


    }
}
