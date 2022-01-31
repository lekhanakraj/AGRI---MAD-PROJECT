package com.example.agri;

public class uplodinfo {
    public String imageName;
    public String imageURL;
    public uplodinfo(){}

    public uplodinfo(String name, String url) {
        this.imageName = name;
        this.imageURL = url;
    }

    public String getImageName() {
        return imageName;
    }
    public String getImageURL() {
        return imageURL;
    }
}
