package com.example.agri;

public class farmers {
    String name;
    String agr;
    String acre;

    public farmers(String name, String agr, String acre) {
        this.name = name;
        this.agr = agr;
        this.acre = acre;
    }

    public String getName() {
        return name;
    }

    public String getAgr() {
        return agr;
    }

    public String getAcre() {
        return acre;
    }
}
