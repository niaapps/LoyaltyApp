package com.niaapplications.loyaltyapp;

import java.lang.reflect.Array;

public class Customer {

private String usrNumber, usrEmail;
private int points = 0;
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

}
