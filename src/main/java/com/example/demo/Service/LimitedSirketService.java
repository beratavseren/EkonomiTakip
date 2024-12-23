package com.example.demo.Service;



import com.example.demo.Dao.LimitedSirketDao;
import com.example.demo.Dao.PaydasLimitedSirketDao;
import com.example.demo.Dao.SirketDao;
import com.example.demo.Dao.SirketSektorSehirDao;
import com.example.demo.Entity.LimitedSirket;

import java.util.List;

public class LimitedSirketService {
    SirketDao sirketDao;
    LimitedSirketDao limitedSirketDao;
    PaydasLimitedSirketDao paydasLimitedSirketDao;
    SirketSektorSehirDao sirketSektorSehirDao;


    public LimitedSirketService()
    {
        this.sirketDao=new SirketDao();
        this.limitedSirketDao=new LimitedSirketDao();
        this.paydasLimitedSirketDao=new PaydasLimitedSirketDao();
        this.sirketSektorSehirDao=new SirketSektorSehirDao();
    }

    public boolean addLimitedSirket(LimitedSirket limitedSirket, long sektor_id, int plaka_kodu)
    {
        try {
            limitedSirket.setSirket(sirketDao.addSirket(limitedSirket.getSirket()));
            limitedSirketDao.addLimitedSirket(limitedSirket);
            sirketSektorSehirDao.addSirketSektorSehir(limitedSirket.getSirket().getSirket_id(),sektor_id,plaka_kodu);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Limited Şirket eklenemedi. Hata:"+e.getMessage(),e);
        }
    }

    public boolean deleteLimitedSirket(long limitedsirket_id)
    {
        try {
            limitedSirketDao.deleteLimitedSirket(limitedsirket_id);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Limited şirket silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateLimitedSirket(LimitedSirket limitedSirket)
    {
        try {
            limitedSirketDao.updateLimitedSirket(limitedSirket);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Limited Şirket güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public LimitedSirket searchLimitedSirket(long limitedsirket_id)
    {
        try {
            return limitedSirketDao.searchLimitedSirket(limitedsirket_id);
        }catch (Exception e)
        {
            throw new RuntimeException("Limited şirket aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<LimitedSirket> getLimitedSirket()
    {
        try {
            return limitedSirketDao.getLimitedSirket();
        }catch (Exception e)
        {
            throw new RuntimeException("Limited şirketler aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public boolean addPaydastoLimitedSirket(long paydas_id, int ortaklik_yuzdesi, long limitedsirket_id)
    {
        try {

            LimitedSirket limitedSirket=limitedSirketDao.searchLimitedSirket(limitedsirket_id);
            paydasLimitedSirketDao.addPaydas(paydas_id,ortaklik_yuzdesi,limitedSirket);
            return true;

        }catch (Exception e)
        {
            throw new RuntimeException("Paydas, limited şirket ara tablosuna eklenemedi. Hata: "+e.getMessage(),e);
        }
    }
}
