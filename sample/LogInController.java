package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.scene.EnteredExitedHandler;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


import java.awt.event.KeyListener;
import java.io.IOException;

import static javafx.scene.input.KeyEvent.*;

public class LogInController   {
    @FXML
    private JFXTextField usernametf;
    @FXML
    private JFXPasswordField passwordtf;
    @FXML
    private JFXButton loginbtn;
    @FXML
    private JFXButton cancelbtn;
    @FXML
    private Label messagelbl;

    String username = "Admin";
    String Password = "Password123";

    // Login Method to Enter in the Software with Login and Password with Mouse Click
    public void loginButtonPushed(ActionEvent event) throws IOException {
        if (usernametf.getText().equals(username) && passwordtf.getText().equals(Password)) {
            Parent detailviewer = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene view = new Scene(detailviewer);
            Stage showit = (Stage) ((Node) event.getSource()).getScene().getWindow();
            showit.setScene(view);
            showit.centerOnScreen();
            showit.show();


        } else {

            messagelbl.setText("UserName  or  Password is Incorrect");

        }
    }


    // Method to close the Login page with Cancel Button
    public void cancelbtnpushed(ActionEvent event) {

        System.exit(0);
    }


    // Method to Login with Keypress
    public void loginkeypressed(KeyEvent ke)  throws IOException {
        if (ke.getCode().toString().equals("ENTER")) {

            if (usernametf.getText().equals(username) && passwordtf.getText().equals(Password)) {
                Parent detailviewer = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                Scene view = new Scene(detailviewer);
                Stage showit = (Stage) ((Node) ke.getSource()).getScene().getWindow();
                showit.setScene(view);
                showit.centerOnScreen();
                showit.show();
            }


            else {

                messagelbl.setText("UserName  or  Password is Incorrect");

            }
        }

        }

        // Method to close the Login Page with Cancel Button
        public void cancelkeypressed(KeyEvent event){
            if (event.getCode().toString().equals("ENTER")){
                System.exit(0);
            }
        }



}
