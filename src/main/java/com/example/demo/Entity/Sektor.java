package com.example.demo.Entity;

public class Sektor {

    private long sektor_id;
    private Ekonomi ekonomi;
    private int vergi_orani;
    private String sektor_ad;

    public Sektor(String sektor_ad)
    {
        this.sektor_ad=sektor_ad;
    }

    public Sektor(String sektor_ad,int vergi_orani)
    {
        this.sektor_ad=sektor_ad;
        this.vergi_orani=vergi_orani;
    }

    public Sektor(long ekonomi_id,int vergi_orani,String sektor_ad)
    {
        this.vergi_orani=vergi_orani;
        this.sektor_ad=sektor_ad;
        this.ekonomi=new Ekonomi(ekonomi_id);
    }

    public Sektor(long sektor_id, Ekonomi ekonomi, int vergi_orani, String sektor_ad) {
        this.sektor_id = sektor_id;
        this.ekonomi = ekonomi;
        this.vergi_orani = vergi_orani;
        this.sektor_ad = sektor_ad;
    }

    public long getSektor_id() {
        return sektor_id;
    }

    public void setSektor_id(long sektor_id) {
        this.sektor_id = sektor_id;
    }

    public Ekonomi getEkonomi() {
        return ekonomi;
    }

    public void setEkonomi(Ekonomi ekonomi) {
        this.ekonomi = ekonomi;
    }

    public int getVergi_orani() {
        return vergi_orani;
    }

    public void setVergi_orani(int vergi_orani) {
        this.vergi_orani = vergi_orani;
    }

    public String getSektor_ad() {
        return sektor_ad;
    }

    public void setSektor_ad(String sektor_ad) {
        this.sektor_ad = sektor_ad;
    }
}
