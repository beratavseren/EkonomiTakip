package com.example.demo.Dao;



import com.example.demo.Entity.Ekonomi;
import com.example.demo.Entity.Sektor;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SektorDao {

    List<Sektor> sektorList;

    public boolean addSektor(Sektor sektor)
    {
        try {

            Statement statement = DBConnection.connect().createStatement();
            statement.executeUpdate("insert into sektor (sektor_ad,vergi_orani,ekonomi_id) values ('"+sektor.getSektor_ad()+"',"+sektor.getVergi_orani()+",'"+sektor.getEkonomi().getEkonomi_id()+"')");
            return true;

        }catch (SQLException e)
        {
            throw new RuntimeException("Sektor eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteSektor(long sektor_id)
    {
        try {
            Statement statement = DBConnection.connect().createStatement();
            statement.executeUpdate("delete from sektor where sektor_id = '"+sektor_id+"' ");

            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Sektor silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateSektor(long sektor_id,Sektor sektor)
    {
        try {

            Statement statement = DBConnection.connect().createStatement();
            statement.executeUpdate("update sektor set vergi_orani="+sektor.getVergi_orani()+",sektor_ad='"+sektor.getSektor_ad()+"' where sektor_id='"+sektor_id+"'");

            return true;

        }catch (SQLException e)
        {
            throw new RuntimeException("Sektor güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Sektor searchSektor(long sektor_id)
    {
        try {

            Statement statement = DBConnection.connect().createStatement();
            ResultSet arananSektor =statement.executeQuery("select * from sektor natural join ekonomi where sektor_id = '"+sektor_id+"' ");

            if(arananSektor.next())
            {
                String sektor_ad = arananSektor.getString("sektor_ad");
                int vergi_orani = arananSektor.getInt("vergi_orani");

                long ekonomi_id = arananSektor.getInt("ekonomi_id");
                String ekonomi_ad= arananSektor.getString("ekonomi_ad");

                return new Sektor(sektor_id,new Ekonomi(ekonomi_ad,ekonomi_id),vergi_orani,sektor_ad);

            } else {
                return null;
            }
        }catch (SQLException e)
        {
            throw new RuntimeException("Sektor aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<Sektor> getSektor()
    {
        try {

            sektorList=new ArrayList<>();

            Statement statement = DBConnection.connect().createStatement();
            ResultSet sektorler = statement.executeQuery("select * from sektor natural join ekonomi");

            while (sektorler.next())
            {
                long sektor_id = sektorler.getLong("sektor_id");
                String sektor_ad = sektorler.getString("sektor_ad");
                int vergi_orani = sektorler.getInt("vergi_orani");

                String ekonomi_ad=sektorler.getString("ekonomi_ad");
                long ekonomi_id = sektorler.getInt("ekonomi_id");

                sektorList.add(new Sektor(sektor_id,new Ekonomi(ekonomi_ad,ekonomi_id),vergi_orani,sektor_ad));
            }

            return sektorList;

        }catch (SQLException e)
        {
            throw new RuntimeException("Sektorler Aranamadı. Hata: "+e.getMessage(),e);
        }
    }
}