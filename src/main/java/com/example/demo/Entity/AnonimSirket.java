package com.example.demo.Entity;

public class AnonimSirket {

    private Sirket sirket;
    private long anonimsirket_id;
    private int halka_aciklik_orani;

    public AnonimSirket(Sirket sirket, long anonimsirket_id, int halka_aciklik_orani) {
        this.sirket = sirket;
        this.anonimsirket_id = anonimsirket_id;
        this.halka_aciklik_orani = halka_aciklik_orani;
    }

    public AnonimSirket(String sirket_ad,int gelir,int gider,int vergi_borcu,int halka_aciklik_orani)
    {
        this.sirket=new Sirket(sirket_ad,gelir,gider,vergi_borcu);
        this.halka_aciklik_orani=halka_aciklik_orani;
    }

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    public long getAnonimsirket_id() {
        return anonimsirket_id;
    }

    public void setAnonimsirket_id(long anonimsirket_id) {
        this.anonimsirket_id = anonimsirket_id;
    }

    public int getHalka_aciklik_orani() {
        return halka_aciklik_orani;
    }

    public void setHalka_aciklik_orani(int halka_aciklik_orani) {
        this.halka_aciklik_orani = halka_aciklik_orani;
    }
}
