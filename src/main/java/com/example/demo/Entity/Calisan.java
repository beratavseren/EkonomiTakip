package com.example.demo.Entity;

public class Calisan {
    private Kisi kisi;
    private long calisan_id;

    public Calisan(Kisi kisi, long calisan_id) {
        this.kisi = kisi;
        this.calisan_id = calisan_id;
    }

    public Calisan(String isim, String soyisim)
    {
        this.kisi=new Kisi(isim,soyisim);
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public long getCalisan_id() {
        return calisan_id;
    }

    public void setCalisan_id(long calisan_id) {
        this.calisan_id = calisan_id;
    }
}
