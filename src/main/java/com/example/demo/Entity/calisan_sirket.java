package com.example.demo.Entity;

public class calisan_sirket {

    public calisan_sirket(Calisan calisan, long sirket_id, int maas) {
        this.calisan = calisan;
        this.sirket_id = sirket_id;
        this.maas = maas;
    }

    private Calisan calisan;
    private long sirket_id;
    private int maas;

    public calisan_sirket(String isim,String soyisim,long sirket_id,int maas)
    {
        this.calisan=new Calisan(isim,soyisim);
        this.sirket_id=sirket_id;
        this.maas=maas;
    }

    public Calisan getCalisan() {
        return calisan;
    }

    public void setCalisan(Calisan calisan) {
        this.calisan = calisan;
    }

    public long getSirketid() {
        return sirket_id;
    }

    public void setSirket(long sirket_id) {
        this.sirket_id = sirket_id;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }
}
