package com.example.demo.Entity;

public class sirket_sektor_sehir {

    private Sirket sirket;
    private Sektor sektor;
    private Sehir sehir;

    public sirket_sektor_sehir(String sirket_ad,int gelir,int gider,int vergi_borcu,String sektor_ad,String sehir_ad)
    {
        this.sirket=new Sirket(sirket_ad,gelir,gider,vergi_borcu);
        this.sektor=new Sektor(sektor_ad);
        this.sehir=new Sehir(sehir_ad);
    }


    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    public Sektor getSektor() {
        return sektor;
    }

    public void setSektor(Sektor sektor) {
        this.sektor = sektor;
    }

    public Sehir getSehir() {
        return sehir;
    }

    public void setSehir(Sehir sehir) {
        this.sehir = sehir;
    }
}
