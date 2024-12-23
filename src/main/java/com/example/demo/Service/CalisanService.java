package com.example.demo.Service;



import com.example.demo.Dao.CalisanDao;
import com.example.demo.Dao.CalisanSirketDao;
import com.example.demo.Dao.KisiDao;
import com.example.demo.Entity.Calisan;
import com.example.demo.Entity.calisan_sirket;

import java.util.List;

public class CalisanService {
    KisiDao kisiDao;
    CalisanDao calisanDao;
    CalisanSirketDao calisanSirketDao;

    public CalisanService()
    {
        this.kisiDao=new KisiDao();
        this.calisanDao=new CalisanDao();
        this.calisanSirketDao=new CalisanSirketDao();
    }

    public boolean addCalisan(Calisan calisan, long sirket_id, int maas)
    {
        try {
            calisan.setKisi(kisiDao.addKisi(calisan.getKisi()));
            calisan=calisanDao.addCalisan(calisan);
            calisanSirketDao.addCalisanSirket(calisan.getCalisan_id(),sirket_id,maas);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Calisan eklenemedi. Hata"+e.getMessage(),e);
        }
    }

    public boolean deleteCalisan(long calisan_id)
    {
        try {
            return calisanDao.deleteCalisan(calisan_id);
        }catch (Exception e)
        {
            throw new RuntimeException("Calisan silinemedi. Hata"+e.getMessage(),e);
        }
    }

    public boolean updateCalisan(long calisan_id,long sirket_id,int maas)
    {
        try {
            calisanSirketDao.updateCalisanSirket(calisan_id,sirket_id,maas);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Calisan güncellenemedi. Hata"+e.getMessage(),e);
        }
    }

    public calisan_sirket searchCalisan(long calisan_id)
    {
        try {
            Calisan calisan=calisanDao.searchCalisan(calisan_id);
            return calisanSirketDao.searchCalisanSirket(calisan);
        }catch (Exception e)
        {
            throw new RuntimeException("Calisan aranamadı. Hata"+e.getMessage(),e);
        }
    }

    public List<calisan_sirket> getCalisan()
    {
        try {
            return calisanSirketDao.getCalisanSirket(calisanDao.getCalisan());
        }catch (Exception e)
        {
            throw new RuntimeException("Calisanlar aranamadı. Hata"+e.getMessage(),e);
        }
    }
}
