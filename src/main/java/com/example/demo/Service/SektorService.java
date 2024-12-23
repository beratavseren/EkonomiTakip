package com.example.demo.Service;


import com.example.demo.Dao.BakanlikDao;
import com.example.demo.Dao.SektorDao;
import com.example.demo.Entity.Sektor;

import java.util.List;

public class SektorService {
    SektorDao sektorDao;
    BakanlikDao bakanlikDao;

    public SektorService()
    {
        sektorDao=new SektorDao();
        bakanlikDao=new BakanlikDao();
    }
    public boolean addSektor(Sektor sektor)
    {
        sektorDao.addSektor(sektor);
        return true;
    }

    public boolean deleteSektor(long sektor_id)
    {
        sektorDao.deleteSektor(sektor_id);
        return true;
    }

    public boolean updateSektor(long sektor_id,Sektor sektor)
    {
        sektorDao.updateSektor(sektor_id,sektor);
        return true;
    }

    public Sektor searchSektor(long sektor_id)
    {
        return sektorDao.searchSektor(sektor_id);
    }

    public List<Sektor> getSektor()
    {
        return sektorDao.getSektor();
    }

}
