package com.example.mall_yetu_users.Model;

public class phone_item_sales {
    String shdesc,shpr,img;

    public phone_item_sales(String shdesc, String shpr, String img) {
        this.shdesc = shdesc;
        this.shpr = shpr;
        this.img = img;
    }

    public String getShdesc() {
        return shdesc;
    }

    public void setShdesc(String shdesc) {
        this.shdesc = shdesc;
    }

    public String getShpr() {
        return shpr;
    }

    public void setShpr(String shpr) {
        this.shpr = shpr;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
