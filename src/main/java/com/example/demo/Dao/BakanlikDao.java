package com.example.demo.Dao;



import com.example.demo.Entity.Bakanlik;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BakanlikDao {
    List<Bakanlik> bakanlikList;

    public boolean addBakanlik(Bakanlik bakanlik)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into bakanlik (bakanlik_ad) values ('"+bakanlik.getBakanlik_ad()+"')");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Bakanlik eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteBakanlik(long bakanlik_id)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("delete from bakanlik where bakanlik_id="+bakanlik_id+" ");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Bakanlik silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateBakanlik(long bakanlik_id,Bakanlik bakanlik)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("update bakanlik set bakanlik_ad='"+bakanlik.getBakanlik_ad()+"' where bakanlik_id='"+bakanlik_id+"'");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Bakanlik güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Bakanlik searchBakanlik(long bakanlik_id)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            ResultSet arananBakanlik = statement.executeQuery("select * from bakanlik where bakanlik_id='"+bakanlik_id+"'");
            if (arananBakanlik.next())
            {
                String bakanlik_ad=arananBakanlik.getString("bakanlik_ad");
                return new Bakanlik(bakanlik_ad,bakanlik_id);
            }
            else {
                return null;
            }
        }catch (SQLException e)
        {
            throw new RuntimeException("Bakanlik aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<Bakanlik> getBakanlik()
    {
        bakanlikList=new ArrayList<>();
        try {
            Statement statement= DBConnection.connect().createStatement();
            ResultSet arananBakanliklar = statement.executeQuery("select * from bakanlik");
            while (arananBakanliklar.next())
            {
                String bakanlik_ad=arananBakanliklar.getString("bakanlik_ad");
                long bakanlik_id=arananBakanliklar.getLong("bakanlik_id");

                bakanlikList.add(new Bakanlik(bakanlik_ad,bakanlik_id));
            }
            return bakanlikList;
        }catch (SQLException e)
        {
            throw new RuntimeException("Bakanliklar aranamadı. Hata: "+e.getMessage(),e);
        }
    }
}
