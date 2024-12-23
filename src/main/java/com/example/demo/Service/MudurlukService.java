package com.example.demo.Service;



import com.example.demo.Dao.BakanlikDao;
import com.example.demo.Dao.MudurlukDao;
import com.example.demo.Dao.MudurlukSehirDao;
import com.example.demo.Entity.Mudurluk;

import java.util.List;

public class MudurlukService {
    MudurlukDao mudurlukDao;
    BakanlikDao bakanlikDao;
    MudurlukSehirDao mudurlukSehirDao;

    public MudurlukService()
    {
        mudurlukDao=new MudurlukDao();
        bakanlikDao=new BakanlikDao();
        mudurlukSehirDao=new MudurlukSehirDao();
    }
    //3'lü ilişkiye çare bul

    //mudurluk_sehir e ekleme yap

    //mudurluk-sehire ekleme test et
    public boolean addMudurluk(long bakanlik_id, int plaka_kodu, Mudurluk mudurluk)
    {
        try {
            mudurluk.setBakanlik(bakanlikDao.searchBakanlik(bakanlik_id));
            mudurlukSehirDao.addMudurlukSehir(mudurlukDao.addMudurluk(mudurluk).getMudurluk_id(),plaka_kodu);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Mudurluk eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteMudurluk(long mudurluk_id)
    {
        try {
            mudurlukDao.deleteMudurluk(mudurluk_id);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Mudurluk silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateMudurluk(long mudurluk_id,Mudurluk mudurluk)
    {
        try {
            mudurluk.setMudurluk_ad(mudurlukDao.searchMudurluk(mudurluk_id).getMudurluk_ad());
            mudurlukDao.updateMudurluk(mudurluk_id,mudurluk);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Mudurluk güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Mudurluk searchMudurluk(long mudurluk_id)
    {
        try {
            return mudurlukDao.searchMudurluk(mudurluk_id);
        }catch (Exception e)
        {
            throw new RuntimeException("Mudurluk aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<Mudurluk> getMudurluk()
    {
        try {
            return mudurlukDao.getMudurluk();
        }catch (Exception e)
        {
            throw new RuntimeException("Mudurlukler aranamadı. Hata: "+e.getMessage(),e);
        }
    }
}
