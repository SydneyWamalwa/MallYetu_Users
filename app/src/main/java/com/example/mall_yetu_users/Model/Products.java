package com.example.mall_yetu_users.Model;

public class Products {
    private String shname,img,uid;

    public Products(String uid) {
        this.uid = uid;
    }

    public Products(String shname, String img) {
        this.shname = shname;
        this.img = img;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getShname() {
        return shname;
    }

    public void setShname(String shname) {
        this.shname = shname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
