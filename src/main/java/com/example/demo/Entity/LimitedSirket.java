package com.example.demo.Entity;

public class LimitedSirket {
    private Sirket sirket;
    private long limitedsirket_id;
    private int ortak_sayisi;

    public LimitedSirket(String sirket_ad,int gelir,int gider,int vergi_borcu,int ortak_sayisi)
    {
        this.sirket=new Sirket(sirket_ad,gelir,gider,vergi_borcu);
        this.ortak_sayisi=ortak_sayisi;
    }

    public LimitedSirket(Sirket sirket,long limitedsirket_id,int ortak_sayisi)
    {
        this.sirket=sirket;
        this.ortak_sayisi=ortak_sayisi;
        this.limitedsirket_id=limitedsirket_id;
    }

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    public long getLimitedsirket_id() {
        return limitedsirket_id;
    }

    public void setLimitedsirket_id(long limitedsirket_id) {
        this.limitedsirket_id = limitedsirket_id;
    }

    public int getOrtak_sayisi() {
        return ortak_sayisi;
    }

    public void setOrtak_sayisi(int ortak_sayisi) {
        this.ortak_sayisi = ortak_sayisi;
    }
}
