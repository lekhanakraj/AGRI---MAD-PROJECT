package com.example.agri;

public class UserHelperClass {

    String phonenumber;
   public UserHelperClass(){}

    public UserHelperClass(String phonenumber) {

        this.phonenumber = phonenumber;
    }



    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
