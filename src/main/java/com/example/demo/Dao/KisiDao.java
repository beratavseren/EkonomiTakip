package com.example.demo.Dao;



import com.example.demo.Entity.Kisi;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KisiDao {
    List<Kisi> kisiList;

    public Kisi addKisi(Kisi kisi)
    {
        try {

            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into kisi (isim,soyisim) values ('"+kisi.getIsim()+"','"+kisi.getSoyisim()+"')",statement.RETURN_GENERATED_KEYS);

            long tckn = GeneratedKeyAl.generatedKeyAl(statement.getGeneratedKeys(), "tckn");
            kisi.setTckn(tckn);

            return kisi;

        }catch (SQLException e)
        {
            throw new RuntimeException("Kisi eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteKisi(long tckn)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            statement.executeUpdate("delete from kisi where tckn = '"+tckn+"'");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Kisi silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateKisi(long tckn,Kisi kisi)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            statement.executeUpdate("update kisi set isim='"+kisi.getIsim()+"',soyisim='"+kisi.getSoyisim()+"' where tckn='"+tckn+"'");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Kisi güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Kisi searchKisi(long tckn)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananKisi = statement.executeQuery("select * from kisi where tckn='"+tckn+"'");
            if (arananKisi.next())
            {
                String isim = arananKisi.getString("isim");
                String soyisim = arananKisi.getString("soyisim");

                return new Kisi(tckn,isim,soyisim);
            }else {
                return null;
            }
        }catch (SQLException e)
        {
            throw new RuntimeException("Kisi aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<Kisi> getKisi()
    {
        kisiList=new ArrayList<>();

        try {
            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananKisiler = statement.executeQuery("select * from kisi");

            while (arananKisiler.next())
            {
                long tckn = arananKisiler.getLong("tckn");
                String isim = arananKisiler.getString("isim");
                String soyisim = arananKisiler.getString("soyisim");
                String ilce= arananKisiler.getString("ilce");
                String cadde= arananKisiler.getString("cadde");
                String adres= arananKisiler.getString("adres");

                kisiList.add(new Kisi(tckn,isim,soyisim,ilce,cadde,adres));
            }

            return kisiList;

        }catch (SQLException e)
        {
            throw new RuntimeException("Kişiler aranamadı. Hata: "+e.getMessage(),e);
        }
    }
}
