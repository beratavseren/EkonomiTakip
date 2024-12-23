package com.example.demo.Entity;

public class Sirket {

    private long sirket_id;
    private String sirket_ad;
    private long vergi_no;
    private int gelir;
    private int gider;
    private int vergi_borcu;

    public Sirket(long sirket_id, String sirket_ad, long vergi_no, int gelir, int gider, int vergi_borcu) {
        this.sirket_id = sirket_id;
        this.sirket_ad = sirket_ad;
        this.vergi_no = vergi_no;
        this.gelir = gelir;
        this.gider = gider;
        this.vergi_borcu = vergi_borcu;
    }

    public Sirket(String sirket_ad, int gelir, int gider, int vergi_borcu)
    {
        this.sirket_ad=sirket_ad;
        this.gelir=gelir;
        this.gider=gider;
        this.vergi_borcu=vergi_borcu;
    }

    public Sirket(String sirket_ad)
    {
        this.sirket_ad=sirket_ad;
    }

    public long getSirket_id() {
        return sirket_id;
    }

    public void setSirket_id(long sirket_id) {
        this.sirket_id = sirket_id;
    }

    public String getSirket_ad() {
        return sirket_ad;
    }

    public void setSirket_ad(String sirket_ad) {
        this.sirket_ad = sirket_ad;
    }

    public long getVergi_no() {
        return vergi_no;
    }

    public void setVergi_no(long vergi_no) {
        this.vergi_no = vergi_no;
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

    public int getVergi_borcu() {
        return vergi_borcu;
    }

    public void setVergi_borcu(int vergi_borcu) {
        this.vergi_borcu = vergi_borcu;
    }
}
