package com.niaapplications.loyaltyapp;

import java.lang.reflect.Array;

public class Customer {

private String usrNumber, usrEmail;
private int points;
private Transaction [] transactions;


public Customer(){
    this.usrNumber = usrNumber;
    this.usrEmail = usrEmail;
    this.points = points;
}
    public Customer(String num, String email, int points){
        this.usrNumber = num;
        this.usrEmail = email;
        this.points = points;
    }

    public String getUsrNumber() {
        return usrNumber;
    }

    public void setUsrNumber(String usrNumber) {
        this.usrNumber = usrNumber;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }
}
