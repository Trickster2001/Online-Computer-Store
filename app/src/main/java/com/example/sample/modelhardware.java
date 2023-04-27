package com.example.sample;

public class modelhardware {
    String name,price,purl;

    modelhardware()
    {

    }

    public modelhardware(String name, String price, String purl) {
        this.name = name;
        this.price = price;
        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
