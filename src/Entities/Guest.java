package Entities;

public class Guest {
    private String fname;
    private String lname;
    private String email;
    private long cardnumber;
    private int cvv;
    private String billing;
    private String expiration;

    public Guest(String fname, String lname, String email, String cardnumber, String cvv, String billing,
            String expiration) {
        //Constructor for guest that fills the properties of guest.java
        this.fname = fname;//first name
        this.lname = lname;//last name
        this.email = email;//email
        this.cardnumber = Long.parseLong(cardnumber);//card number
        this.cvv = Integer.parseInt(cvv);//cvv
        this.billing = billing;//billing
        this.expiration = expiration;//expiration
    }

    public String getFname() {
        //get first name
        return this.fname;
    }

    public String getLname() {
        //last name
        return this.lname;
    }

    public String getEmail() {
        //get email
        return this.email;
    }

    public long getCardnumber() {
        //get card number
        return this.cardnumber;
    }

    public int getCvv() {
        //get the cvv and return int
        return this.cvv;
    }

    public String getBilling() {
        //return the billing as a string
        return this.billing;
    }

    public String getExpiration() {
        //get the expiration date and return string
        return this.expiration;
    }

}
