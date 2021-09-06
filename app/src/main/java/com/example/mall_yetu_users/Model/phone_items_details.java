package com.example.mall_yetu_users.Model;

public class phone_items_details {
    String description,img,pname,price,pid;

    public phone_items_details(String description, String img, String pname, String price, String pid) {
        this.description = description;
        this.img = img;
        this.pname = pname;
        this.price = price;
        this.pid = pid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
