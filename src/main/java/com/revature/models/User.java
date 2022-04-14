package com.revature.models;
import java.util.List;


public class User extends AbstractUser {

    private List<Reimbursement> reimbursements;

    private String first;
    private String last;
    private String email;

    public User() {
        super();
    }

    public User(String username, String password, String email) {
        super(username, password);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
