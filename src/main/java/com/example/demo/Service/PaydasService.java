package com.example.demo.Service;



import com.example.demo.Dao.KisiDao;
import com.example.demo.Dao.PaydasDao;
import com.example.demo.Entity.Kisi;
import com.example.demo.Entity.Paydas;

import java.util.List;

public class PaydasService {
    PaydasDao paydasDao;
    KisiDao kisiDao;

    public PaydasService()
    {
        this.paydasDao=new PaydasDao();
        this.kisiDao=new KisiDao();
    }

    public boolean addPaydas(Paydas paydas)
    {
        try {
            Kisi kisi=kisiDao.addKisi(paydas.getKisi());
            paydas.setKisi(kisi);
            paydasDao.addPaydas(paydas);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Paydas eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deletePaydas(long paydas_id)
    {
        try {
            paydasDao.deletePaydas(paydas_id);
            return true;
        }catch (Exception e)
        {
            throw new RuntimeException("Paydas silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updatePaydas(long paydas_id,Paydas paydas)
    {
        try {
            paydas.getKisi().setTckn(paydasDao.findTcknByPaydasId(paydas_id));
            return paydasDao.updatePaydas(paydas);
        }catch (Exception e)
        {
            throw new RuntimeException("Paydas güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Paydas searchPaydas(long paydas_id)
    {
        try {
            return paydasDao.searchPaydas(paydas_id);
        }catch (Exception e)
        {
            throw new RuntimeException("Paydas aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<Paydas> getPaydas()
    {
        try {
            return paydasDao.getPaydas();
        }catch (Exception e)
        {
            throw new RuntimeException("Paydaslar aranamadı. Hata: "+e.getMessage(),e);
        }
    }
}
