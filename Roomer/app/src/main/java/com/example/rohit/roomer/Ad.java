package com.example.rohit.roomer;

/**
 * Created by vishesh on 3/7/2015.
 */
public class Ad {

    private String descriptionAd;
    private String titleAd;
    private String fullNameAd;

    public Ad(String title, String descriptionAd, String fullNameAd) {
        this.titleAd = title;
        this.descriptionAd = descriptionAd;
        this.fullNameAd = fullNameAd;
    }

    public String getDescriptionAd() {
        return descriptionAd;
    }

    public void setDescriptionAd(String descriptionAd) {
        this.descriptionAd = descriptionAd;
    }

    public String getTitleAd() {
        return titleAd;
    }

    public void setTitleAd (String title) {
        this.titleAd = title;
    }


    public String getFullNameAd() {
        return fullNameAd;
    }

    public void setFullNameAd(String fullNameAd) {
        this.fullNameAd = fullNameAd;
    }
}
