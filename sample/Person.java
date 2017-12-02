package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.LocalTime;

public class Person {
    SimpleStringProperty fullname;
    SimpleStringProperty fathersname;
    SimpleIntegerProperty age;
    SimpleStringProperty gender;
    SimpleStringProperty occupation;
    SimpleStringProperty  idproof;
    SimpleLongProperty idno;
    SimpleLongProperty mobileno;
    SimpleLongProperty pincode;
    SimpleStringProperty state;
    SimpleStringProperty city;
    SimpleStringProperty nationality;
    SimpleIntegerProperty noofperson;
    SimpleStringProperty roomtype;
    SimpleIntegerProperty  roomalloted;
    SimpleIntegerProperty roomno;
    LocalDate checkindate;
    LocalDate checkoutdate;
    LocalTime checkintime;
    LocalTime checkouttime;
    SimpleIntegerProperty totalpayment;
    SimpleStringProperty paymentmadeby;


//Person constructor to save the details of the guest in the Person class

    public Person(String fullname, String fathersname, int age, String gender, String occupation, String idProof,
                  long idno,  String  state, String city, String nationality,long mobileno, long pincode, int noopperson, String roomtype, int roomalloted,
                  int roomno, LocalDate checkindate, LocalDate checkoutdate, LocalTime checkintime, LocalTime checkouttime,
                  int totalpayment, String paymentmadeby) {
        this.fullname = new SimpleStringProperty(fullname) ;
        this.fathersname = new SimpleStringProperty (fathersname);
        this.age=  new SimpleIntegerProperty(age);
        this.gender = new SimpleStringProperty (gender);
        this.occupation = new SimpleStringProperty (occupation);
        this.idproof = new SimpleStringProperty (idProof);
        this.idno = new SimpleLongProperty (idno);
        this.mobileno = new SimpleLongProperty(mobileno);
        this.pincode = new SimpleLongProperty(pincode);
        this.state = new SimpleStringProperty (state);
        this.city = new SimpleStringProperty (city);
        this.nationality = new SimpleStringProperty (nationality);
        this.noofperson = new SimpleIntegerProperty(noopperson);
        this.roomtype = new SimpleStringProperty (roomtype);
        this.roomalloted = new SimpleIntegerProperty(roomalloted);
        this.roomno = new SimpleIntegerProperty (roomno);
        this.checkindate =  checkindate;
        this.checkoutdate = checkoutdate;
        this.checkintime = checkintime;
        this.checkouttime = checkouttime;
        this.totalpayment = new SimpleIntegerProperty (totalpayment);
        this.paymentmadeby = new SimpleStringProperty (paymentmadeby);


    }


    public String getFullname() {
        return fullname.get();
    }

    public void   setFullname(String fullname) { this.fullname.set(fullname); ;
    }


    public String getFathersname(){ return fathersname.get();}

    public void   setFathersname(String fathersname) { this.fathersname.set(fathersname); ; }


    public int  getAge(){ return age.get(); }

    public void setAge(int age){ this.age.set(age); }


    public String getGender() {
        return gender.get();
    }

    public void   setGender(String gender) {this.gender.set(gender); ; }



    public String getOccupation() {
        return occupation.get();
    }

    public void   setOccupation(String occupation) { this.occupation.set(occupation); }


    public String getIdproof() { return idproof.get(); }

    public void   setIdproof(String idproof){ this.idproof.set(idproof); }


    public long  getIdno() { return idno.get(); }

    public void setIdno(Long idno) { this.idno.set(idno); }


    public String getState() { return state.get(); }

    public void  setState(String state){ this.state.set(state); }


    public String getCity() {
        return city.get();
    }

    public void   setCity(String city) { this.city.set(city); }


    public String getNationality(){ return  nationality.get(); }

    public void   setNationality(String nationality){ this.nationality.set(nationality); }


    public long getMobileno(){return  mobileno.get();}

    public void setMobileno(Long mobileno) { this.mobileno.set(mobileno); }


    public long getPincode() { return pincode.get(); }

    public void setPincode(Long pincode) { this.pincode.set(pincode); }


    public int  getNoofperson(){ return noofperson.get(); }

    public void setNoofperson(int noofperson){ this.noofperson.set(noofperson); }


    public String getRoomtype() { return roomtype.get(); }

    public void   setRoomtype(String roomtype){ this.roomtype.set(roomtype); }


    public int  getRoomalloted(){ return roomalloted.get(); }

    public void setRoomalloted(int  roomalloted){ this.roomalloted.set(roomalloted); }


    public int getRoomno(){ return roomno.get(); }

    public void setRoomno(int roomno){  this.roomno.set(roomno); }


    public LocalDate getCheckindate() { return checkindate; }

    public void       setCheckindate(LocalDate checkindate){ this.checkindate =checkindate; }


    public LocalDate getCheckoutdate() { return checkoutdate; }

    public void      setCheckoutdate(LocalDate checkoutdate) { this.checkoutdate = checkoutdate; }


    public LocalTime getCheckintime() { return checkintime; }

    public void       setCheckintime(LocalTime checkintime) { this.checkintime = checkintime; }


    public LocalTime getCheckouttime() { return checkouttime; }

    public void      setCheckouttime(LocalTime checkouttime) { this.checkouttime = checkouttime; }


    public int  getTotalpayment() { return totalpayment.get(); }

    public void setTotalpayment(int totalpayment) { this.totalpayment.set(totalpayment); }


    public String getPaymentmadeby() { return paymentmadeby.get(); }

    public void   setPaymentmadeby(String paymentmadeby) { this.paymentmadeby.set(paymentmadeby); }
}

