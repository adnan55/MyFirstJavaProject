package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllotingController implements Initializable {

    public void paymentBtnpushed(ActionEvent event) throws IOException{
        Parent taketopayment = FXMLLoader.load(getClass().getResource("Payment.fxml"));
        Scene gototopayment = new Scene(taketopayment);
        Stage showpayment = (Stage) ((Node) event.getSource()).getScene().getWindow();
        showpayment.setScene(gototopayment);
        showpayment.setResizable(false);
        showpayment.show();


    }

    public void goBacktoGuestDetailBtnpushed(ActionEvent event) throws IOException {
        Parent takebacktoguestdetail = FXMLLoader.load(getClass().getResource("GuestDetail.fxml"));
        Scene gobacktoguestdetail = new Scene(takebacktoguestdetail);
        Stage showbacktoguestdetail = (Stage) ((Node) event.getSource()).getScene().getWindow();
        showbacktoguestdetail.setScene(gobacktoguestdetail);
        showbacktoguestdetail.setResizable(false);
        showbacktoguestdetail.show();

    }
    @FXML
    private JFXTextField noofPersontf1,noofPersontf2,noofRoomtf,noofBedtf,roomnotf,bednotf;

    public void allotingclearbtnpushed(ActionEvent event) {
        noofPersontf1.clear();
        noofPersontf2.clear();
        noofRoomtf.clear();
        noofBedtf.clear();
        roomnotf.clear();
        bednotf.clear();
    }





        @FXML
    private RadioButton roomrb, bedrb,attachedrb,nonattachedrb;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup toggleGroup = new ToggleGroup();
        this.roomrb.setToggleGroup(toggleGroup);
        this.bedrb.setToggleGroup(toggleGroup);

        ToggleGroup toggleGroup1 = new ToggleGroup();
        this.attachedrb.setToggleGroup(toggleGroup1);
        this.nonattachedrb.setToggleGroup(toggleGroup1);


    }
}
