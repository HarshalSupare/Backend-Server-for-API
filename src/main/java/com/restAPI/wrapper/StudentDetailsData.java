package com.restAPI.wrapper;

import java.io.StringReader;

public class StudentDetailsData {
    private String address_city;
    private String email_id;
    private String school_id;
    private String accomplishments;


    @Override
    public String toString() {
        return "StudentDetailsData{" +
                "address_city='" + address_city + '\'' +
                ", email_id='" + email_id + '\'' +
                ", school_id='" + school_id + '\'' +
                ", accomplishments='" + accomplishments + '\'' +
                '}';
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getAccomplishments() {
        return accomplishments;
    }

    public void setAccomplishments(String accomplishments) {
        this.accomplishments = accomplishments;
    }
}
