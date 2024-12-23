package com.example.demo.Service;



import com.example.demo.Dao.AnonimSirketDao;
import com.example.demo.Dao.PaydasAnonimSirketDao;
import com.example.demo.Dao.SirketDao;
import com.example.demo.Dao.SirketSektorSehirDao;
import com.example.demo.Entity.AnonimSirket;
import com.example.demo.Entity.Sirket;

import java.util.List;

public class AnonimSirketService {
    AnonimSirketDao anonimSirketDao;
    SirketDao sirketDao;
    PaydasAnonimSirketDao paydasAnonimSirketDao;
    SirketSektorSehirDao sirketSektorSehirDao;

    public AnonimSirketService()
    {
        this.anonimSirketDao=new AnonimSirketDao();
        this.sirketDao=new SirketDao();
        this.paydasAnonimSirketDao=new PaydasAnonimSirketDao();
        this.sirketSektorSehirDao=new SirketSektorSehirDao();
    }

    public boolean addAnonimsirket(AnonimSirket anonimSirket, long sektor_id, int plaka_kodu)
    {
        try {
            Sirket sirket=sirketDao.addSirket(anonimSirket.getSirket());
            anonimSirket.setSirket(sirket);
            anonimSirket=anonimSirketDao.addAnonimSirket(anonimSirket);
            sirketSektorSehirDao.addSirketSektorSehir(anonimSirket.getSirket().getSirket_id(),sektor_id,plaka_kodu);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Anonim Şirket eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteAnonimSirket(long anonimsirket_id)
    {
        try {
            return anonimSirketDao.deleteAnonimSirket(anonimsirket_id);
        }catch (Exception e)
        {
            throw new RuntimeException("Anonim Şirket silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateAnonimSirket(AnonimSirket anonimSirket)
    {
        try {
            return anonimSirketDao.updateAnonimsirket(anonimSirket);
        }catch (Exception e)
        {
            throw new RuntimeException("Anonim Şirket güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public AnonimSirket searchAnonimSirket(long anonimsirket_id)
    {
        try {
            return anonimSirketDao.searchAnonimSirket(anonimsirket_id);
        }catch (Exception e)
        {
            throw new RuntimeException("Anonim Şirket aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<AnonimSirket> getAnonimSirket()
    {
        try {
            return anonimSirketDao.getAnonimSirket();
        }catch (Exception e)
        {
            throw new RuntimeException("Anonim Şirketler aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public boolean addPaydastoAnonimSirket(long paydas_id,int hisse_sayisi,long anonimsirket_id)
    {
        try {
            AnonimSirket anonimSirket=anonimSirketDao.searchAnonimSirket(anonimsirket_id);
            paydasAnonimSirketDao.addPaydasAnonimSirket(paydas_id,hisse_sayisi,anonimSirket);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Paydas anonim şirkete eklenemedi. Hata: "+e.getMessage(),e);
        }
    }
}
