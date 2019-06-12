package com.niaapplications.loyaltyapp;

public class Business {


 private String name, email, pw, street, state, city,zip, number;


    public Business(){
        this.name = name;
        this.email = email;
        this.number = number;
        this.city = city;
        this.pw = pw;
        this.street = street;
        this.state = state;
        this.zip = zip;
    }

    public Business(String name, String email, String pw, String street, String city, String state, String zip, String number){

        this.name = name;
        this.email = email;
        this.number = number;
        this.city = city;
        this.pw = pw;
        this.street = street;
        this.state = state;
        this.zip = zip;



    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

