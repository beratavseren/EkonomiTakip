package com.example.demo.Entity;

public class KamuCalisani {
    public KamuCalisani(long kamu_calisani_id, Kisi kisi) {
        this.kamu_calisani_id = kamu_calisani_id;
        this.kisi = kisi;
    }

    private long kamu_calisani_id;
    private Kisi kisi;

    public KamuCalisani(String isim,String soyisim)
    {
        this.kisi=new Kisi(isim,soyisim);
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public long getKamu_calisani_id() {
        return kamu_calisani_id;
    }

    public void setKamu_calisani_id(long kamu_calisani_id) {
        this.kamu_calisani_id = kamu_calisani_id;
    }
}
