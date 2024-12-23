package com.example.demo.Dao;



import com.example.demo.Entity.Calisan;
import com.example.demo.Entity.calisan_sirket;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CalisanSirketDao {

    List<calisan_sirket> calisanSirketList;
    public void addCalisanSirket(long calisan_id,long sirket_id,int maas)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into calisan_sirket (calisan_id,sirket_id,maas) values ("+calisan_id+","+sirket_id+","+maas+")");
        }catch (SQLException e)
        {
            throw new RuntimeException("Calisan_sirket ara tablosuna ekleme yapılamadı. Hata: "+e.getMessage(),e);
        }
    }

    public void updateCalisanSirket(long calisan_id,long sirket_id,int maas)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            statement.executeUpdate("update calisan_sirket set sirket_id = '"+sirket_id+"',maas = "+maas+" where calisan_id = '"+calisan_id+"'");
        }catch (SQLException e)
        {
            throw new RuntimeException("Calisan_sirket ara tablosunda güncelleme yapılamadı. Hata: "+e.getMessage(),e);
        }
    }

    public calisan_sirket searchCalisanSirket(Calisan calisan)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            ResultSet calisan_sirket=statement.executeQuery("select * from calisan_sirket where calisan_id='"+calisan.getCalisan_id()+"'");

            if (calisan_sirket.next())
            {
                int maas=calisan_sirket.getInt("maas");
                long sirket_id= calisan_sirket.getLong("sirket_id");
                return new calisan_sirket(calisan,sirket_id,maas);
            }
            else {
                return null;
            }
        }catch (SQLException e)
        {
            throw new RuntimeException("Calisan_sirket ara tablosu aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<calisan_sirket> getCalisanSirket(List<Calisan> list)
    {   calisanSirketList=new ArrayList<>();
        try {

            Statement statement=DBConnection.connect().createStatement();
            ResultSet calisan_sirketler=statement.executeQuery("select * from calisan_sirket");

            int CalisanListindex=0;

            while (calisan_sirketler.next())
            {
                int maas=calisan_sirketler.getInt("maas");
                long sirket_id= calisan_sirketler.getLong("sirket_id");
                calisanSirketList.add(new calisan_sirket(list.get(CalisanListindex),sirket_id,maas));
                CalisanListindex+=1;
            }

            return calisanSirketList;

        }catch (SQLException e)
        {
            throw new RuntimeException("Calisan_sirket ara tablosu aranamadı. Hata: "+e.getMessage(),e);
        }
    }
}
