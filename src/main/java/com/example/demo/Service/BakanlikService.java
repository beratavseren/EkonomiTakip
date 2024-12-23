package com.example.demo.Service;



import com.example.demo.Dao.BakanlikDao;
import com.example.demo.Entity.Bakanlik;

import java.util.List;

public class BakanlikService {
    BakanlikDao bakanlikDao;

    public BakanlikService()
    {
        bakanlikDao=new BakanlikDao();
    }

    public boolean addBakanlik(Bakanlik bakanlik)
    {
        try {
            return bakanlikDao.addBakanlik(bakanlik);
        }catch (Exception e)
        {
            throw new RuntimeException("Bakanlik eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteBakanlik(long bakanlik_id)
    {
        try {
            return bakanlikDao.deleteBakanlik(bakanlik_id);
        }catch (Exception e)
        {
            throw new RuntimeException("Bakanlik eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateBakanlik(long bakanlik_id,Bakanlik bakanlik)
    {
        try {
            return bakanlikDao.updateBakanlik(bakanlik_id,bakanlik);
        }catch (Exception e)
        {
            throw new RuntimeException("Bakanlik eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Bakanlik searchBakanlik(long bakanlik_id)
    {
        try {
            return bakanlikDao.searchBakanlik(bakanlik_id);
        }catch (Exception e)
        {
            throw new RuntimeException("Bakanlik eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public List<Bakanlik> getBakanlik()
    {
        try {
            return bakanlikDao.getBakanlik();
        }catch (Exception e)
        {
            throw new RuntimeException("Bakanlik eklenemedi. Hata: "+e.getMessage(),e);
        }
    }
}
