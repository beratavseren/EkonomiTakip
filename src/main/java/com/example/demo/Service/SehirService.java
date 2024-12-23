package com.example.demo.Service;


import com.example.demo.Dao.SehirDao;
import com.example.demo.Entity.Sehir;

import java.util.List;

public class SehirService {
    SehirDao sehirDao;

    public SehirService()
    {
        sehirDao=new SehirDao();
    }

    public boolean addSehir(Sehir sehir)
    {
        try {
            return sehirDao.addSehir(sehir);
        }catch (Exception e)
        {
            throw new RuntimeException("Sehir eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteSehir(int plaka_kodu)
    {
        try {
            return sehirDao.deleteSehir(plaka_kodu);
        }catch (Exception e)
        {
            throw new RuntimeException("Sehir silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateSehir(int plaka_kodu,Sehir sehir)
    {
        try {
            return sehirDao.updateSehir(plaka_kodu, sehir);
        }catch (Exception e)
        {
            throw new RuntimeException("Sehir güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Sehir searchSehir(int plaka_kodu)
    {
        try {
            return sehirDao.searchSehir(plaka_kodu);
        }catch (Exception e)
        {
            throw new RuntimeException("Sehir aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<Sehir> getSehir()
    {
        try {
            return sehirDao.getSehir();
        }catch (Exception e)
        {
            throw new RuntimeException("Sehirler aranamadı. Hata: "+e.getMessage(),e);
        }
    }
}
