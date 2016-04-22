package com.example.rohit.roomer;

import android.graphics.Bitmap;

/**
 * Created by Rohit on 2/25/15.
 */
public class User {

    private String fullName;
    private String city;
    private String university;
    private Bitmap image;
    private String email;
    private String phoneNumber;
    private String age;
    private byte[] dataa;

    public User(String fullName1,String city1, String university1) {
        fullName = fullName1 ;
        city=city1;
        university=university1;
        /*image=image1;
        email=email1;
        phoneNumber=phoneNumber1;
        age=age1;*/
        //dataa=data1;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }
    public void setDataa(byte[] dataa) {
        this.dataa = dataa;
    }

    public byte[] getDataa() {
        return dataa;
    }
}