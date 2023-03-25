package Entities;

public class Account {
    private Strategy payStrat; // Strategy
    private String fname; // First name
    private String lname; // Last name
    private String username; // Username
    private String password; // Password
    private String email; // Email
    private long cardnumber; // Card number
    private int cvv; // CVV
    private String billing; // Billing address
    private String expiration; // Expiration date

    public Account() { // default ctor
    }

    public Account(String fname, String lname, String username, String password, String email, String cardnumber,
            String cvv,
            String billing, String expiration) {// ctor with parameters except for Strategy
        // stores all the users info that they input into the GUI
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cardnumber = Long.parseLong(cardnumber);
        this.cvv = Integer.parseInt(cvv);
        this.billing = billing;
        this.expiration = expiration;
    }

    public Account(String fname, String lname, String username, String password, String email, String cardnumber,
            String cvv,
            String billing, String expiration, Strategy payStrat) { // ctor with parameters including Strategy
        // stores all the users info that they input into the GUI
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cardnumber = Long.parseLong(cardnumber);
        this.cvv = Integer.parseInt(cvv);
        this.billing = billing;
        this.expiration = expiration;
        this.payStrat = payStrat;
    }

    public Strategy getPayStrat() { // getter for Strategy
        return this.payStrat;
    }

    public void setPayStrat(Strategy payStrat) { // setter for Strategy
        this.payStrat = payStrat;
    }

    public String getFname() { // getter for first name
        return this.fname;
    }

    public void setFname(String fname) { // setter for first name
        this.fname = fname;
    }

    public String getLname() { // getter for last name
        return this.lname;
    }

    public void setLname(String lname) { // setter for last name
        this.lname = lname;
    }

    public String getUsername() { // getter for username
        return this.username;
    }

    public void setUsername(String username) { // setter for username
        this.username = username;
    }

    public String getPassword() { // getter for password
        return this.password;
    }

    public void setPassword(String password) { // setter for password
        this.password = password;
    }

    public String getEmail() { // getter for email
        return this.email;
    }

    public void setEmail(String email) { // setter for email
        this.email = email;
    }

    public long getCardnumber() { // getter for card number
        return this.cardnumber;
    }

    public void setCardnumber(long cardnumber) { // setter for card number
        this.cardnumber = cardnumber;
    }

    public int getCvv() { // getter for CVV
        return this.cvv;
    }

    public void setCvv(int cvv) { // setter for CVV
        this.cvv = cvv;
    }

    public String getBilling() { // getter for billing address
        return this.billing;
    }

    public void setBilling(String billing) { // setter for billing address
        this.billing = billing;
    }

    public String getExpiration() { // getter for expiration date
        return this.expiration;
    }

    public void setExpiration(String expiration) { // setter for expiration date
        this.expiration = expiration;
    }

}