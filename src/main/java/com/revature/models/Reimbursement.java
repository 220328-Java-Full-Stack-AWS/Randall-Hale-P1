package com.revature.models;

import java.sql.Timestamp;


public class Reimbursement {

    private int id;
    private int status;
    private double amount;
    private int author;
    private int resolver;
    private int type;
    private String description;
    private Timestamp submitted;
    private Timestamp resolved;


    public Reimbursement(){
        this.description = "";
    }


    public Reimbursement(int id, int status, double amount, int author, int resolver, int type,
                         String description, Timestamp submitted, Timestamp resolved) {
        this.id = id;
        this.status = status;
        this.amount = amount;
        this.author = author;
        this.resolver = resolver;
        this.type = type;
        this.description = description;
        this.submitted = submitted;
        this.resolved = resolved;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

}
