package com.example.demo.Entity;

public class Bakanlik {

    private String bakanlik_ad;
    private long bakanlik_id;

    public Bakanlik(String bakanlik_ad) {
        this.bakanlik_ad = bakanlik_ad;
    }


    public Bakanlik(String bakanlik_ad, long bakanlik_id) {
        this.bakanlik_ad = bakanlik_ad;
        this.bakanlik_id = bakanlik_id;
    }


    public String getBakanlik_ad() {
        return bakanlik_ad;
    }

    public void setBakanlik_ad(String bakanlik_ad) {
        this.bakanlik_ad = bakanlik_ad;
    }

    public long getBakanlik_id() {
        return bakanlik_id;
    }

    public void setBakanlik_id(long bakanlik_id) {
        this.bakanlik_id = bakanlik_id;
    }
}
