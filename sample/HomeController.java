package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Optional;

public class HomeController {
    // method to go on Next Page with Mouse Click
    public void newButtonPushed(ActionEvent event) throws IOException {

        Parent detailviewer = FXMLLoader.load(getClass().getResource("GuestDetail.fxml"));
        Scene view = new Scene(detailviewer);
        Stage showit = (Stage) ((Node) event.getSource()).getScene().getWindow();
        showit.setScene(view);
        showit.centerOnScreen();

        showit.show();
    }


    // method to go on Next Page using Enter Keypress
    public  void newButtonkeypressed(KeyEvent event) throws IOException{
        if (event.getCode().toString().equals("ENTER"))  {
            Parent detailviewer = FXMLLoader.load(getClass().getResource("GuestDetail.fxml"));
            Scene view = new Scene(detailviewer);
            Stage showit = (Stage) ((Node) event.getSource()).getScene().getWindow();
            showit.setScene(view);
            showit.centerOnScreen();

            showit.show();
        }
        }


    @FXML
    private JFXButton showEntriesbtn;


    //Method to go on Next page of Show Entry with Mouse Click
    public void showEntryButtonPushed(ActionEvent event) throws IOException {
                Parent taketoshowentry = FXMLLoader.load(getClass().getResource("ShowEntries.fxml"));
        Scene gotoscene = new Scene(taketoshowentry);
        Stage showthescene = (Stage) ((Node) event.getSource()).getScene().getWindow();
        showthescene.setScene(gotoscene);
        showthescene.setResizable(false);
        showthescene.centerOnScreen();
        showthescene.show();


    }

    // Method to go on Show Entry Page Using Enter Keypress
    public void  showentrykeypressed(KeyEvent event) throws IOException{
        if (event.getCode().toString().equals("ENTER")){
            Parent taketoshowentry = FXMLLoader.load(getClass().getResource("ShowEntries.fxml"));
            Scene gotoscene = new Scene(taketoshowentry);
            Stage showthescene = (Stage) ((Node) event.getSource()).getScene().getWindow();
            showthescene.setScene(gotoscene);
            showthescene.setResizable(false);
            showthescene.centerOnScreen();

            showthescene.show();

        }
        }




     // Method to Close the Home Page With Confirmation of Yes and No with Mouse Click
    public void closetheHomePage() throws Exception {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"",ButtonType.YES,ButtonType.NO);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are You sure You Want to Exit from Application");
        alert.setContentText("Click on Yes to exit");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get()==ButtonType.YES){
            System.exit(0);
        }
        }
        // Method to close the Home page with Confirmation of Yes and Not with Enter Keypress
      public void closetheHomeKeypressed(KeyEvent event){
        if(event.getCode().toString().equals("ENTER")){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"",ButtonType.YES,ButtonType.NO);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Are You sure You Want to Exit from Application");
            alert.setContentText("Click on Yes to exit");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()==ButtonType.YES){
                System.exit(0); }
        }
        }


}




