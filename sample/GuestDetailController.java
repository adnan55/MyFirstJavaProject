package sample;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;


public class GuestDetailController implements Initializable {




    public GuestDetailController() {
    }
    // Method to call the  back to home with Confirmation
    public void BacktoHomeButtonPushed(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are You sure You Want to Go Back to Home All data will be Unsaved");
        alert.setContentText("Click on Yes to Confirm");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES) {


            Parent taketohome = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene gotohome = new Scene(taketohome);
            Stage showhome = (Stage) ((Node) event.getSource()).getScene().getWindow();
            showhome.setScene(gotohome);
            showhome.setResizable(false);
            showhome.show();
        }


    }






    @FXML
    private JFXTextField fullnametf, addresstf, agetf, occupationtf, idtf, citytf, nationalitytf, mobilenotf,
            pincodetf, noofpersontf, roomnotf, roomchargetf, noofroomtf, totalpaymenttf, paymentmadebytf;
    @FXML
    JFXDatePicker checkindatedp, checkoutdatedp;

    @FXML
    private JFXTimePicker checkintimetp, checkouttimetp;

    // Method to clear all the TextFields and Combobox
    public void clearbtnpushed(ActionEvent event) {
        fullnametf.clear();
        addresstf.clear();
        agetf.clear();
        occupationtf.clear();
        idtf.clear();
        citytf.clear();
        nationalitytf.clear();
        mobilenotf.clear();
        pincodetf.clear();
        noofpersontf.clear();
        roomnotf.clear();
        roomchargetf.clear();
        noofroomtf.clear();
        totalpaymenttf.clear();
        paymentmadebytf.clear();


    }


    @FXML
    private JFXComboBox<String> stateComboBox;

    @FXML
    private JFXComboBox<String> idtypeComboBox;

    @FXML
    private JFXComboBox<String> genderComboBox;

    @FXML
    private JFXComboBox<String> roomComboBox;

    @FXML
    private JFXComboBox<String> roomtypeComboBox;


    // This list is for Selecting ID Proof
    ObservableList<String> idlist = FXCollections.observableArrayList("Aadhar Card", "Driving License"
            , "Voter ID", "PAN Card");

    // This list is for Selecting State
    ObservableList<String> statelist = FXCollections.observableArrayList("Andhra Pradesh", "Arunachal Pradesh",
            "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat",
            "Haryana", "Himachal Pradesh", "Jammu and Kashmir",
            "Jharkhand", "Karnataka", "Kerala", "Madya Pradesh",
            "Maharashtra", "Manipur", "Meghalaya", "Mizoram",
            "Nagaland", "Orissa", "Punjab", "Rajasthan",
            "Sikkim,", "Tamil Nadu", "Tripura", "Uttaranchal",
            "Uttar Pradesh", "West Bengal");

    //list for selecting Gender
    ObservableList<String> genderlist = FXCollections.observableArrayList("Male", "Female");
    // list for selecting Room/Bed
    ObservableList<String> roombed = FXCollections.observableArrayList("Room", "Bed");
    // list for selecting Room-Type
    ObservableList<String> roomtype1 = FXCollections.observableArrayList("Attached", "Non-Attached");

    public ObservableList<Person> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        idtypeComboBox.setItems(idlist);

        stateComboBox.setItems(statelist);

        genderComboBox.setItems(genderlist);

        roomComboBox.setItems(roombed);

        roomtypeComboBox.setItems(roomtype1);


    }
// Method to save the Guestdetail and on the database and show it on showentry page
    public void saveit(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ShowEntries.fxml"));
        Parent showit = loader.load();


        Scene gotoscene = new Scene(showit);
        Stage showthescene = (Stage) ((Node) event.getSource()).getScene().getWindow();
        showthescene.setResizable(false);
        showthescene.setScene(gotoscene);
        showthescene.centerOnScreen();
        showthescene.show();
        showentrycontroller controller = loader.getController();

        data.add(new Person(fullnametf.getText(), addresstf.getText(), Integer.parseInt(agetf.getText()),
                genderComboBox.getValue(), occupationtf.getText(), idtypeComboBox.getValue(),
                Long.parseLong(idtf.getText()), stateComboBox.getValue(), citytf.getText(),
                nationalitytf.getText(), Long.parseLong(mobilenotf.getText()), Long.parseLong(pincodetf.getText()), Integer.parseInt(noofpersontf.getText()),
                roomtypeComboBox.getValue(), Integer.parseInt(noofroomtf.getText()),
                Integer.parseInt(roomnotf.getText()), checkindatedp.getValue(), checkoutdatedp.getValue(),
                checkintimetp.getValue(), checkouttimetp.getValue(), Integer.parseInt(totalpaymenttf.getText()),
                paymentmadebytf.getText()));


        controller.getShowentrytable2().setItems(data);
        try {


            java.util.Date checkindate = new java.util.Date();
            java.util.Date checkoutdate = new java.util.Date();
            java.util.Date checkintime = new java.util.Date();
            java.util.Date checkouttime = new java.util.Date();

            java.sql.Date sqldate = new java.sql.Date(checkindate.getTime());
            java.sql.Date sqloutdate = new java.sql.Date(checkoutdate.getTime());
            java.sql.Time sqlcheckintime = new java.sql.Time(checkintime.getTime());
            java.sql.Time sqlcheckouttime = new java.sql.Time(checkouttime.getTime());


            String query = "INSERT INTO guestdetail (Name, Address, Age, Gender, Occupation, ID_type, ID_no, State, city, Nationality, Mobile_no, Pincode, No_of_person, Room_type,No_of_room, Room_no, checkInDate, checkOutDate, checkInTime, checkOutTime, Total_payment, Payment_made_by ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/savera_lodge?autoReconnect=true&useSSL=true", "root", "august1708");
            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, fullnametf.getText());
            st.setString(2, addresstf.getText());
            st.setString(3, agetf.getText());
            st.setString(4, genderComboBox.getValue());
            st.setString(5, occupationtf.getText());
            st.setString(6, idtypeComboBox.getValue());
            st.setString(7, idtf.getText());
            st.setString(8, stateComboBox.getValue());
            st.setString(9, citytf.getText());
            st.setString(10, nationalitytf.getText());
            st.setString(11, mobilenotf.getText());
            st.setString(12, pincodetf.getText());
            st.setString(13, noofpersontf.getText());
            st.setString(14, roomtypeComboBox.getValue());
            st.setString(15, noofroomtf.getText());
            st.setString(16, roomnotf.getText());
            st.setDate(17, sqldate);
            st.setDate(18, sqloutdate);
            st.setTime(19, sqlcheckintime);
            st.setTime(20, sqlcheckouttime);
            st.setString(21, totalpaymenttf.getText());
            st.setString(22, paymentmadebytf.getText());


            st.executeUpdate();
            System.out.println("done");


            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/savera_lodge?autoReconnect=true&useSSL=true", "root", "august1708");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from guestdetail");

            while (rs.next()) {
                data.add(new Person(rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getLong(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getLong(11),
                        rs.getLong(12), rs.getInt(13), rs.getString(14), rs.getInt(15),
                        rs.getInt(16), rs.getDate(17).toLocalDate(), rs.getDate(18).toLocalDate(), rs.getTime(19).toLocalTime(),
                        rs.getTime(20).toLocalTime(), rs.getInt(21), rs.getString(22)));
            }

        } catch (Exception e) {

        }


    }
    // Method to call the observable list data
    public ObservableList<Person> getData() {

          return data;
    }
}





















