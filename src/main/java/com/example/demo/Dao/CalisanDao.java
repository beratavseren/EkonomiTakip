package com.example.demo.Dao;



import com.example.demo.Entity.Calisan;
import com.example.demo.Entity.Kisi;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CalisanDao {
    List<Calisan> calisanList;

    public Calisan addCalisan(Calisan calisan)
    {
        try {

            Statement statement = DBConnection.connect().createStatement();
            statement.executeUpdate("insert into calisan (tckn) values ('"+calisan.getKisi().getTckn()+"')",statement.RETURN_GENERATED_KEYS);

            long calisan_id = GeneratedKeyAl.generatedKeyAl(statement.getGeneratedKeys(),"calisan_id");
            calisan.setCalisan_id(calisan_id);

            return calisan;

        }catch (SQLException e)
        {
            throw new RuntimeException("Calisan eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteCalisan(long calisan_id)
    {
        try {

            Statement statement=DBConnection.connect().createStatement();

            long tckn = findTcknbyCalisanId(calisan_id);
            statement.executeUpdate("delete from kisi where tckn='"+tckn+"'");

            return true;

        }catch (SQLException e)
        {
            throw new RuntimeException("Calisan silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateCalisan(long calisan_id,Calisan calisan)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            long tckn = findTcknbyCalisanId(calisan_id);
            statement.executeUpdate("update kisi set isim = '"+calisan.getKisi().getIsim()+"',soyisim = '"+calisan.getKisi().getSoyisim()+"' where tckn='"+tckn+"'");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Calisan güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Calisan searchCalisan(long calisan_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananCalisan = statement.executeQuery("select * from kisi natural join calisan where calisan_id='"+calisan_id+"'");

            if (arananCalisan.next())
            {
                long tckn = arananCalisan.getLong("tckn");
                String isim= arananCalisan.getString("isim");
                String soyisim = arananCalisan.getString("soyisim");
                String ilce = arananCalisan.getString("ilce");
                String cadde = arananCalisan.getString("cadde");
                String adres = arananCalisan.getString("adres");

                return new Calisan(new Kisi(tckn,isim,soyisim,ilce,cadde,adres),calisan_id);
            }
            else {
                return null;
            }
        }catch (SQLException e)
        {
            throw new RuntimeException("Calisan aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<Calisan> getCalisan()
    {
        calisanList=new ArrayList<>();

        try {

            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananCalisanlar = statement.executeQuery("select * from kisi natural join calisan");

            while (arananCalisanlar.next())
            {
                long tckn = arananCalisanlar.getLong("tckn");
                String isim= arananCalisanlar.getString("isim");
                String soyisim = arananCalisanlar.getString("soyisim");
                String ilce = arananCalisanlar.getString("ilce");
                String cadde = arananCalisanlar.getString("cadde");
                String adres = arananCalisanlar.getString("adres");
                long calisan_id = arananCalisanlar.getLong("calisan_id");

                calisanList.add(new Calisan(new Kisi(tckn,isim,soyisim,ilce,cadde,adres),calisan_id));
            }

            return calisanList;

        }catch (SQLException e)
        {
            throw new RuntimeException("Calisan aranamadı. Hata: "+e.getMessage(),e);
        }
    }
    public long findTcknbyCalisanId(long calisan_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            long tckn=GeneratedKeyAl.generatedKeyAl(statement.executeQuery("select * from kisi natural join calisan where calisan_id='"+calisan_id+"'"),"tckn");
            return tckn;
        }catch (SQLException e)
        {
            throw new RuntimeException("Calisan_id'den tckn aranamadı. Hata: "+e.getMessage(),e);
        }
    }

}
