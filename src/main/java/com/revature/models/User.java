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

    public User(int id, String username, String password, Role role, String email) {
        super(id, username, password, role);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
