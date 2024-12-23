package com.example.demo.Service;

import com.example.demo.Dao.KamuCalisaniDao;
import com.example.demo.Dao.KamuCalisaniMudurlukSehirDao;
import com.example.demo.Dao.KisiDao;
import com.example.demo.Dao.MudurlukSehirDao;
import com.example.demo.Entity.KamuCalisani;

import java.util.List;

public class KamuCalisaniService {
    KamuCalisaniDao kamuCalisaniDao;
    MudurlukSehirDao mudurlukSehirDao;
    KamuCalisaniMudurlukSehirDao kamuCalisaniMudurlukSehirDao;
    KisiDao kisiDao;

    public KamuCalisaniService()
    {
        kamuCalisaniDao=new KamuCalisaniDao();
        mudurlukSehirDao=new MudurlukSehirDao();
        kamuCalisaniMudurlukSehirDao=new KamuCalisaniMudurlukSehirDao();
        kisiDao=new KisiDao();
    }

    public boolean addKamuCalisani(KamuCalisani kamuCalisani,long mudurluk_id,int plaka_kodu,int maas)
    {
        kamuCalisani.setKisi(kisiDao.addKisi(kamuCalisani.getKisi()));
        kamuCalisani=kamuCalisaniDao.addKamuCalisani(kamuCalisani);

        kamuCalisaniMudurlukSehirDao.addKamuCalisaniMudurlukSehir(mudurlukSehirDao.searchMudurlukSehir(mudurluk_id,plaka_kodu),kamuCalisani.getKamu_calisani_id(),maas);

        return true;
    }

    public boolean deleteKamuCalisani(long kamu_calisani_id)
    {
        return kamuCalisaniDao.deleteKamuCalisani(kamu_calisani_id);
    }

    public boolean updateKamuCalisani(long kamu_calisani_id,int maas)
    {
        return kamuCalisaniMudurlukSehirDao.updateKamuCalisaniMudurlukSehir(kamu_calisani_id,maas);
    }

    public KamuCalisani searchKamuCalisani(long kamu_calisani_id)
    {
        return kamuCalisaniDao.searchKamuCalisani(kamu_calisani_id);
    }

    public List<KamuCalisani> getKamuCalisani()
    {
        return kamuCalisaniDao.getKamuCalisani();
    }

}
