package com.example.demo.Dao;



import com.example.demo.Entity.Sehir;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SehirDao {
    List<Sehir> sehirList;

    public boolean addSehir(Sehir sehir)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into sehir (plaka_kodu,sehir_adi) values ("+sehir.getPlaka_kodu()+",'"+sehir.getSehir_adi()+"')");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Şehir eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteSehir(int plaka_kodu)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("delete from sehir where plaka_kodu = "+plaka_kodu+" ");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Şehir eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateSehir(int plaka_kodu,Sehir sehir)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("update sehir set sehir_adi='"+sehir.getSehir_adi()+"' where plaka_kodu="+plaka_kodu+" ");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Şehir eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Sehir searchSehir(int plaka_kodu)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            ResultSet arananSehir =statement.executeQuery("select * from sehir where plaka_kodu="+plaka_kodu+" ");

            if (arananSehir.next())
            {
                String sehir_adi= arananSehir.getString("sehir_adi");

                return new Sehir(sehir_adi,plaka_kodu);
            }else {
                return null;
            }
        }catch (SQLException e)
        {
            throw new RuntimeException("Şehir eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public List<Sehir> getSehir()
    {
        sehirList=new ArrayList<>();
        try {
            Statement statement= DBConnection.connect().createStatement();
            ResultSet arananSehir =statement.executeQuery("select * from sehir");
            while (arananSehir.next())
            {
                int plaka_kodu=arananSehir.getInt("plaka_kodu");
                String sehir_adi=arananSehir.getString("sehir_adi");

                sehirList.add(new Sehir(sehir_adi,plaka_kodu));
            }
            return sehirList;
        }catch (SQLException e)
        {
            throw new RuntimeException("Şehir eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

}
