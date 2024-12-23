package com.example.demo.Service;



import com.example.demo.Dao.EkonomiDao;
import com.example.demo.Entity.Ekonomi;

import java.util.List;

public class EkonomiService {
    EkonomiDao ekonomiDao;

    public EkonomiService()
    {
        ekonomiDao=new EkonomiDao();
    }

    public boolean addEkonomi(Ekonomi ekonomi)
    {
        try {
            ekonomiDao.addEkonomi(ekonomi);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Ekonomi eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteEkonomi(long ekonomi_id)
    {
        try {
            ekonomiDao.deleteEkonomi(ekonomi_id);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Ekonomi silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateEkonomi(long ekonomi_id,Ekonomi ekonomi)
    {
        try {
            ekonomiDao.updateEkonomi(ekonomi_id,ekonomi);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Ekonomi güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Ekonomi searchEkonomi(long ekonomi_id)
    {
        try {
            return ekonomiDao.searchEkonomi(ekonomi_id);
        }catch (Exception e)
        {
            throw new RuntimeException("Ekonomi aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<Ekonomi> getEkonomi()
    {
        try {
            return ekonomiDao.getEkonomi();
        }catch (Exception e)
        {
            throw new RuntimeException("Ekonomiler aranamadı. Hata: "+e.getMessage(),e);
        }
    }
}
