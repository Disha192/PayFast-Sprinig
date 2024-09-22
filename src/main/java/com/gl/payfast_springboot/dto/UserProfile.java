package com.gl.payfast_springboot.dto;

public class UserProfile {
    private String username;
    private String email;
    private String password;
    private String role;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String cardName;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String cardType;

    public UserProfile() {
    }

    public UserProfile(String username, String email, String password, String role, String phone, String address, String city, String state, String country, String zip, String cardName, String cardNumber, String expiryDate, String cvv, String cardType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.cardType = cardType;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public String getCardType() {
        return cardType;
    }
}
