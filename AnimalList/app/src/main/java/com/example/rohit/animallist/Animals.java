package com.example.rohit.animallist;

public class Animals {

    private String name1;
    private String image;

    public Animals(String name,String fileName) {
        name1 = name;
        image=fileName;
    }

    public String getName() {
        return name1;
    }

    public String getFileName() {
        return image;
    }


}
