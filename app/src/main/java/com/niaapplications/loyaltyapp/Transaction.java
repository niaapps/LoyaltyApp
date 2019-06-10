package com.niaapplications.loyaltyapp;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Transaction {

    private double amt;
    private int transPoints;
    private Business business;
    //time of day

    public Transaction(){
        this.amt = amt;
        this.transPoints = transPoints;
        this.business = business;
        //time of day
    }
    public Transaction(Business biz, int points, double amount){
        this.amt = amount;
        this.transPoints = points;
        this.business = biz;
        //time of day
    }




    }

