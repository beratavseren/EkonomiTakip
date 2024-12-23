package com.example.demo.Entity;

public class Sehir {

    private int plaka_kodu;
    private String sehir_adi;

    public Sehir(String sehir_adi,int plaka_kodu)
    {
        this.sehir_adi=sehir_adi;
        this.plaka_kodu=plaka_kodu;
    }

    public Sehir(String sehir_adi)
    {
        this.sehir_adi=sehir_adi;
    }

    public int getPlaka_kodu() {
        return plaka_kodu;
    }

    public void setPlaka_kodu(int plaka_kodu) {
        this.plaka_kodu = plaka_kodu;
    }

    public String getSehir_adi() {
        return sehir_adi;
    }

    public void setSehir_adi(String sehir_adi) {
        this.sehir_adi = sehir_adi;
    }
}
