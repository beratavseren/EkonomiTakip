package com.example.demo.Entity;

public class Ekonomi {
    private String ekonomi_ad;
    private long ekonomi_id;

    public Ekonomi(long ekonomi_id)
    {
        this.ekonomi_id=ekonomi_id;
    }

    public Ekonomi(String ekonomi_ad) {
        this.ekonomi_ad = ekonomi_ad;
    }

    public Ekonomi(String ekonomi_ad, long ekonomi_id) {
        this.ekonomi_ad = ekonomi_ad;
        this.ekonomi_id = ekonomi_id;
    }


    public String getEkonomi_ad() {
        return ekonomi_ad;
    }

    public void setEkonomi_ad(String ekonomi_ad) {
        this.ekonomi_ad = ekonomi_ad;
    }

    public long getEkonomi_id() {
        return ekonomi_id;
    }

    public void setEkonomi_id(long ekonomi_id) {
        this.ekonomi_id = ekonomi_id;
    }
}
