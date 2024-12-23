package com.example.demo.Dao;



import com.example.demo.Entity.LimitedSirket;
import com.example.demo.Entity.Sirket;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LimitedSirketDao {

    List<LimitedSirket> limitedSirketList;

    public LimitedSirket addLimitedSirket(LimitedSirket limitedSirket)
    {
        try {

            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into limitedsirket (sirket_id,ortak_sayisi) values ('"+limitedSirket.getSirket().getSirket_id()+"',"+limitedSirket.getOrtak_sayisi()+")",statement.RETURN_GENERATED_KEYS);

            limitedSirket.setLimitedsirket_id(GeneratedKeyAl.generatedKeyAl(statement.getGeneratedKeys(),"limitedsirket_id"));
            return limitedSirket;

        }catch (SQLException e)
        {
            throw new RuntimeException("Limited şirket eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public void deleteLimitedSirket(long limitedsirket_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            long sirketId=findSirketIdByLimitedSirketId(limitedsirket_id);
            statement.executeUpdate("delete from sirket where sirket_id = '"+sirketId+"' ");
        }catch (Exception e)
        {
            throw new RuntimeException("Limited şirket silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public void updateLimitedSirket(LimitedSirket limitedSirket)
    {
        try {

            Statement statement=DBConnection.connect().createStatement();
            statement.executeUpdate("update sirket set gelir="+limitedSirket.getSirket().getGelir()+",gider="+limitedSirket.getSirket().getGider()+",vergi_borcu="+limitedSirket.getSirket().getVergi_borcu()+" where sirket_ad='"+limitedSirket.getSirket().getSirket_ad()+"'");

            long limitedsirket_id=findLimitedSirketIdBySirketAd(limitedSirket.getSirket().getSirket_ad());

            statement.executeUpdate("update limitedsirket set ortak_sayisi = "+limitedSirket.getOrtak_sayisi()+" where limitedsirket_id = '"+limitedsirket_id+"'");

        }catch (SQLException e)
        {
            throw new RuntimeException("Limited şirket güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public LimitedSirket searchLimitedSirket(long limitedsirket_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananLimitedSirket=statement.executeQuery("select * from sirket natural join limitedsirket where limitedsirket_id='"+limitedsirket_id+"'");

            if (arananLimitedSirket.next())
            {
                long sirket_id=arananLimitedSirket.getLong("sirket_id");
                String sirket_ad= arananLimitedSirket.getString("sirket_ad");
                long vergi_no=arananLimitedSirket.getLong("vergi_no");
                int gelir=arananLimitedSirket.getInt("gelir");
                int gider=arananLimitedSirket.getInt("gider");
                int vergi_borcu= arananLimitedSirket.getInt("vergi_borcu");
                int ortak_sayisi=arananLimitedSirket.getInt("ortak_sayisi");

                return new LimitedSirket(new Sirket(sirket_id,sirket_ad,vergi_no,gelir,gider,vergi_borcu),limitedsirket_id,ortak_sayisi);
            }

            else {
                return null;
            }

        }catch (SQLException e)
        {
            throw new RuntimeException("Limited şirket aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<LimitedSirket> getLimitedSirket()
    {
        limitedSirketList=new ArrayList<>();

        try {

            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananLimitedSirketler=statement.executeQuery("select * from sirket natural join limitedsirket");

            while (arananLimitedSirketler.next())
            {
                long sirket_id=arananLimitedSirketler.getLong("sirket_id");
                String sirket_ad= arananLimitedSirketler.getString("sirket_ad");
                long vergi_no=arananLimitedSirketler.getLong("vergi_no");
                int gelir=arananLimitedSirketler.getInt("gelir");
                int gider=arananLimitedSirketler.getInt("gider");
                int vergi_borcu= arananLimitedSirketler.getInt("vergi_borcu");
                long limitedsirket_id = arananLimitedSirketler.getLong("limitedsirket_id");
                int ortak_sayisi=arananLimitedSirketler.getInt("ortak_sayisi");

                limitedSirketList.add(new LimitedSirket(new Sirket(sirket_id,sirket_ad,vergi_no,gelir,gider,vergi_borcu),limitedsirket_id,ortak_sayisi));
            }

            return limitedSirketList;

        }catch (SQLException e)
        {
            throw new RuntimeException("Limited şirketler aranamadı. Hata"+e.getMessage(),e);
        }
    }

    public long findSirketIdByLimitedSirketId(long limitedsirket_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("select sirket_id from sirket natural join limitedsirket where limitedsirket_id = '"+limitedsirket_id+"'");
            long sirket_id=GeneratedKeyAl.generatedKeyAl(resultSet,"sirket_id");
            return sirket_id;
        }catch (SQLException e)
        {
            throw new RuntimeException("Limited şirket id'sinden sirket_id'si bulunamadı. Hata: "+e.getMessage(),e);
        }
    }

    public long findLimitedSirketIdBySirketAd(String sirket_ad)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            return GeneratedKeyAl.generatedKeyAl(statement.executeQuery("select limitedsirket_id from sirket natural join limitedsirket"),"limitedsirket_id");
        }catch (SQLException e)
        {
            throw new RuntimeException("Şirket adından limited şirket id'si bulunamadı. Hata: "+e.getMessage(),e);
        }
    }
}
