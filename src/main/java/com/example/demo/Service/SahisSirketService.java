package com.example.demo.Service;



import com.example.demo.Dao.*;
import com.example.demo.Entity.Kisi;
import com.example.demo.Entity.Paydas;
import com.example.demo.Entity.SahisSirket;
import com.example.demo.Entity.Sirket;

import java.util.List;

public class SahisSirketService {
    SahisSirketDao sahisSirketDao;
    SirketDao sirketDao;
    PaydasDao paydasDao;
    KisiDao kisiDao;
    SirketSektorSehirDao sirketSektorSehirDao;

    public SahisSirketService()
    {
        sirketSektorSehirDao=new SirketSektorSehirDao();
        sahisSirketDao=new SahisSirketDao();
        sirketDao=new SirketDao();
        paydasDao=new PaydasDao();
        kisiDao=new KisiDao();
    }

    //isim soyisim ; sirket_ad gelir gider vergi_borcu
    public boolean addSahisSirket(SahisSirket sahisSirket, long sektor_id, int plaka_kodu)
    {
        try {

            Kisi kisi = kisiDao.addKisi(sahisSirket.getPaydas().getKisi());
            sahisSirket.getPaydas().setKisi(kisi);

            Paydas paydas=paydasDao.addPaydas(sahisSirket.getPaydas());
            Sirket sirket=sirketDao.addSirket(sahisSirket.getSirket());

            sahisSirket.setSirket(sirket);
            sahisSirket.setPaydas(paydas);

            sahisSirketDao.addSahisSirket(sahisSirket);

            sirketSektorSehirDao.addSirketSektorSehir(sahisSirket.getSirket().getSirket_id(),sektor_id,plaka_kodu);

            return true;

        }catch (Exception e)
        {
            throw new RuntimeException("Sahis şirketi eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean addSahisSirketwithpaydas_id(long paydas_id,SahisSirket sahisSirket, long sektor_id, int plaka_kodu)
    {
        try {

            Paydas paydas=paydasDao.searchPaydas(paydas_id);
            Sirket sirket=sirketDao.addSirket(sahisSirket.getSirket());

            sahisSirket.setSirket(sirket);
            sahisSirket.setPaydas(paydas);

            sahisSirketDao.addSahisSirket(sahisSirket);

            sirketSektorSehirDao.addSirketSektorSehir(sahisSirket.getSirket().getSirket_id(),sektor_id,plaka_kodu);

            return true;

        }catch (Exception e)
        {
            throw new RuntimeException("Sahis şirketi eklenemedi. Hata: "+e.getMessage(),e);
        }
    }


    public boolean deleteSahisSirket(long sahissirket_id)
    {
        try {
            sahisSirketDao.deleteSahisSirket(sahissirket_id);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Sahis şirketi silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateSahisSirketPaydas(long sahissirket_id,long paydas_id)
    {
        try {

            Paydas paydas=paydasDao.searchPaydas(paydas_id);
            sahisSirketDao.updateSahisSirketPaydas(sahissirket_id,paydas);

            return true;

        }catch (Exception e)
        {
            throw new RuntimeException("Sahis şirketinin paydaşı güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateSahisSirket(Sirket sirket)
    {
        try {
            SahisSirket sahisSirket=new SahisSirket();
            sahisSirket.setSirket(sirket);
            sahisSirketDao.updateSahisSirket(sahisSirket);
            return true;

        }catch (Exception e)
        {
            throw new RuntimeException("Sahis şirketi güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public SahisSirket searchSahisSirket(long sahissirket_id)
    {
        try {
            return sahisSirketDao.searchSahisSirket(sahissirket_id);
        }catch (Exception e)
        {
            throw new RuntimeException("Sahis şirketi aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<SahisSirket> getSahisSirket()
    {
        try {
            return sahisSirketDao.getSahisSirket();
        }catch (Exception e)
        {
            throw new RuntimeException("Sahis şirketler getirilemedi. Hata: "+e.getMessage(),e);
        }
    }
}
