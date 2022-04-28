package com.revature.models;

public class User {

    private int id;
    private int role;
    private String username;
    private String password;
    private String first;
    private String last;
    private String email;

    public User() {
        username = "";
        password = "";
        first = "";
        last = "";
        email = "";
    }

    public User(int id, int role, String username, String password, String first, String last, String email) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.first = first;
        this.last = last;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
