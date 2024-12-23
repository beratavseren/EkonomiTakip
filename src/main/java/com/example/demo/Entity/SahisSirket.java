package com.example.demo.Entity;

public class SahisSirket {
    public SahisSirket(Sirket sirket, Paydas paydas, long sahissirket_id) {
        this.sirket = sirket;
        this.paydas = paydas;
        this.sahissirket_id = sahissirket_id;
    }

    private Sirket sirket;
    private Paydas paydas;
    private long sahissirket_id;

    public SahisSirket(){}

    public SahisSirket(String isim,String soyisim,String sirket_ad,int gelir,int gider,int vergi_borcu)
    {
        this.sirket=new Sirket(sirket_ad,gelir,gider,vergi_borcu);
        this.paydas=new Paydas(isim, soyisim);
    }

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    public Paydas getPaydas() {
        return paydas;
    }

    public void setPaydas(Paydas paydas) {
        this.paydas = paydas;
    }

    public long getSahissirket_id() {
        return sahissirket_id;
    }

    public void setSahissirket_id(long sahissirket_id) {
        this.sahissirket_id = sahissirket_id;
    }
}
