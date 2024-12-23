package com.example.demo.Entity;

public class Mudurluk {

    public Mudurluk(String mudurluk_ad, long mudurluk_id, int gelir, int gider, int netgelir, Bakanlik bakanlik) {
        this.mudurluk_ad = mudurluk_ad;
        this.mudurluk_id = mudurluk_id;
        this.gelir = gelir;
        this.gider = gider;
        this.netgelir = netgelir;
        this.bakanlik = bakanlik;
    }

    public Mudurluk()
    {

    }

    public Mudurluk(String mudurluk_ad, int gelir, int gider, int netgelir) {
        this.mudurluk_ad = mudurluk_ad;
        this.gelir = gelir;
        this.gider = gider;
        this.netgelir = netgelir;
    }

    private String mudurluk_ad;
    private long mudurluk_id;
    private int gelir;

    public Mudurluk(int gelir, int gider, int netgelir) {
        this.gelir = gelir;
        this.gider = gider;
        this.netgelir = netgelir;
    }

    private int gider;
    private int netgelir;
    private Bakanlik bakanlik;

    public String getMudurluk_ad() {
        return mudurluk_ad;
    }

    public void setMudurluk_ad(String mudurluk_ad) {
        this.mudurluk_ad = mudurluk_ad;
    }

    public long getMudurluk_id() {
        return mudurluk_id;
    }

    public void setMudurluk_id(long mudurluk_id) {
        this.mudurluk_id = mudurluk_id;
    }

    public int getGelir() {
        return gelir;
    }

    public void setGelir(int gelir) {
        this.gelir = gelir;
    }

    public int getGider() {
        return gider;
    }

    public void setGider(int gider) {
        this.gider = gider;
    }

    public int getNetgelir() {
        return netgelir;
    }

    public void setNetgelir(int netgelir) {
        this.netgelir = netgelir;
    }

    public Bakanlik getBakanlik() {
        return bakanlik;
    }

    public void setBakanlik(Bakanlik bakanlik) {
        this.bakanlik = bakanlik;
    }
}
