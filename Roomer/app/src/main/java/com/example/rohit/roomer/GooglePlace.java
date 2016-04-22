package com.example.rohit.roomer;

/**
 * Created by Rohit on 3/6/15.
 */

public class GooglePlace {
    private String name;
    private String category;
    private String rating;
    private String open;
    private String address;
    private String lati;
    private String longi;
    private String place_id;

    public GooglePlace() {
        this.name = "";
        this.rating = "";
        this.open = "";
        this.lati="";
        this.longi="";
        this.setCategory("");
        this.address="";
        this.place_id="";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setOpenNow(String open) {
        this.open = open;
    }

    public String getOpenNow() {
        return open;
    }

    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return address;
    }
    public void setLati(String lati){
        this.lati=lati;
    }
    public String getLati(){
        return lati;
    }
    public void setLongi(String longi){
        this.longi=longi;
    }
    public String getLongi(){
        return longi;
    }
    public void setPlace_id(String place_id){
        this.place_id=place_id;
    }
    public String getPlace_id(){
        return place_id;
    }
}
