package com.example.demo.Entity;

public class Kisi {
    private long tckn;
    private String isim;
    private String soyisim;
    private  String ilce;
    private String cadde;
    private String adres;

    public Kisi()
    {

    }

    public Kisi(long tckn, String isim, String soyisim, String ilce, String cadde, String adres) {
        this.tckn = tckn;
        this.isim = isim;
        this.soyisim = soyisim;
        this.ilce = ilce;
        this.cadde = cadde;
        this.adres = adres;
    }

    public Kisi(String isim,String soyisim)
    {
        this.isim=isim;
        this.soyisim=soyisim;
    }

    public Kisi(long tckn,String isim,String soyisim)
    {
        this.isim=isim;
        this.soyisim=soyisim;
        this.tckn=tckn;
    }

    public long getTckn() {
        return tckn;
    }

    public void setTckn(long tckn) {
        this.tckn = tckn;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getCadde() {
        return cadde;
    }

    public void setCadde(String cadde) {
        this.cadde = cadde;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
