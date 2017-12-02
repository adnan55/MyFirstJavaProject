package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;



// Implement Initializable Interface in Showentrycontroller class to Intialize Table, Table Column,
public class showentrycontroller implements Initializable {

    @FXML
    private TableView<Person> showentrytable2;
    @FXML
    private TableColumn<Person, String> fullnamecolumn;
    @FXML
    private TableColumn<Person, String> fathersnamecolumn;
    @FXML
    private TableColumn<Person, Integer> agecolumn;
    @FXML
    private TableColumn<Person, String> gendercolumn;
    @FXML
    private TableColumn<Person, String> occupationcolumn;
    @FXML
    private TableColumn<Person, String> idproofcolumn;
    @FXML
    private TableColumn<Person, Integer> idnocolumn;
    @FXML
    private TableColumn<Person, String> statecolumn;
    @FXML
    private TableColumn<Person, String> citycolumn;
    @FXML
    private TableColumn<Person, String> nationalitycolumn;
    @FXML
    private TableColumn<Person, String> mobilenocolumn;
    @FXML
    private TableColumn<Person, String> pincodecolumn;


    @FXML
    private TableColumn<Person, Integer> noofpersoncolumn;
    @FXML
    private TableColumn<Person, String> roomtypecolumn;
    @FXML
    private TableColumn<Person, Integer> noofbedcolumn;
    @FXML
    private TableColumn<Person, Integer> roomnocolumn;
    @FXML
    private TableColumn<Person, LocalDate> checkindatecolumn;
    @FXML
    private TableColumn<Person, LocalDate> checkoutdatecolumn;
    @FXML
    private TableColumn<Person, LocalTime> checkintimecolumn;
    @FXML
    private TableColumn<Person, LocalTime> checkouttimecolumn;
    @FXML
    private TableColumn<Person, Integer> totalpaymentcolumn;
    @FXML
    private TableColumn<Person, String> paymentmadebycolumn;

    @FXML
    private ScrollPane sp;


    @Override
    // Intializing Table and Table Columnns.
    public void initialize(URL location, ResourceBundle resources) {
        fullnamecolumn.setCellValueFactory(new PropertyValueFactory<Person, String>("fullname"));
        fathersnamecolumn.setCellValueFactory(new PropertyValueFactory<Person, String>("fathersname"));
        agecolumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        occupationcolumn.setCellValueFactory(new PropertyValueFactory<Person, String>("occupation"));
        gendercolumn.setCellValueFactory(new PropertyValueFactory<Person, String>("gender"));
        idproofcolumn.setCellValueFactory(new PropertyValueFactory<Person, String>("idproof"));
        idnocolumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("idno"));
        statecolumn.setCellValueFactory(new PropertyValueFactory<Person, String>("state"));
        citycolumn.setCellValueFactory(new PropertyValueFactory<Person, String>("city"));
        nationalitycolumn.setCellValueFactory(new PropertyValueFactory<Person, String>("nationality"));
        mobilenocolumn.setCellValueFactory(new PropertyValueFactory<Person, String>("mobileno"));
        pincodecolumn.setCellValueFactory(new PropertyValueFactory<Person, String>("pincode"));
        noofpersoncolumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("noofperson"));
        roomtypecolumn.setCellValueFactory(new PropertyValueFactory<Person, String>("roomtype"));
        noofbedcolumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("roomalloted"));
        roomnocolumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("roomno"));
        checkindatecolumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("checkindate"));
        checkoutdatecolumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("checkoutdate"));
        checkintimecolumn.setCellValueFactory(new PropertyValueFactory<Person, LocalTime>("checkintime"));
        checkouttimecolumn.setCellValueFactory(new PropertyValueFactory<Person, LocalTime>("checkouttime"));
        totalpaymentcolumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("totalpayment"));
        paymentmadebycolumn.setCellValueFactory(new PropertyValueFactory<Person, String>("paymentmadeby"));


        fullnamecolumn.setCellFactory(TextFieldTableCell.forTableColumn());


        showentrytable2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setContent(showentrytable2);







    }

    // showentry table method to get the table components.
    public TableView<Person> getShowentrytable2() {
        return showentrytable2;
    }

   // method to call the Guest Detail  Page to enter new Entry.
    public void newentrybuttonpressed(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are You sure You Want to Go Back and add New Entry");
        alert.setContentText("Click on Yes to Confirm");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES) {


            Parent detailviewer = FXMLLoader.load(getClass().getResource("GuestDetail.fxml"));
            Scene view = new Scene(detailviewer);
            Stage showit = (Stage) ((Node) event.getSource()).getScene().getWindow();
            showit.setScene(view);
            showit.centerOnScreen();
            showit.show();


        }
    }


    // method to call the Homepage
    public void backtohomebuttonpressed(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are You sure You Want to Go Back to Home ");
        alert.setContentText("Click on Yes to Confirm");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES) {


            Parent taketohome = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene gotohome = new Scene(taketohome);
            Stage showhome = (Stage) ((Node) event.getSource()).getScene().getWindow();
            showhome.setScene(gotohome);
            showhome.setResizable(false);
            showhome.centerOnScreen();
            showhome.show();
        }
    }

    // Method to save the Guestdetails on database and show it in the tableformat in Showwentry Page
    public void showbtnpushed(ActionEvent event) throws Exception {
        GuestDetailController control = new GuestDetailController();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/savera_lodge?autoReconnect=true&useSSL=true", "root", "august1708");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from guestdetail");

            while (rs.next()) {

                control.getData().add(new Person(rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getLong(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getLong(11),
                        rs.getLong(12), rs.getInt(13), rs.getString(14), rs.getInt(15),
                        rs.getInt(16), rs.getDate(17).toLocalDate(), rs.getDate(18).toLocalDate(), rs.getTime(19).toLocalTime(),
                        rs.getTime(20).toLocalTime(), rs.getInt(21), rs.getString(22)));
            }
            showentrytable2.setItems(control.getData());


        } catch (Exception e) {
            e.printStackTrace();
        }


    }









    }
