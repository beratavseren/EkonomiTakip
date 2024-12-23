package com.example.demo.Entity;

public class Paydas {
    public Paydas(Kisi kisi, long paydas_id) {
        this.kisi = kisi;
        this.paydas_id = paydas_id;
    }

    private Kisi kisi;
    private long paydas_id;

    public Paydas(String isim,String soyisim)
    {
        this.kisi=new Kisi(isim,soyisim);
    }


    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public long getPaydas_id() {
        return paydas_id;
    }

    public void setPaydas_id(long paydas_id) {
        this.paydas_id = paydas_id;
    }
}
