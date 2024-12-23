package com.example.demo.Dao;



import com.example.demo.Entity.AnonimSirket;
import com.example.demo.Entity.Sirket;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AnonimSirketDao {
    List<AnonimSirket> anonimSirketList;

    public AnonimSirket addAnonimSirket(AnonimSirket anonimSirket)
    {
        try {

            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into " +
                    "anonimsirket (sirket_id,halka_aciklik_orani) " +
                    "values ('"+anonimSirket.getSirket().getSirket_id()+"',"+anonimSirket.getHalka_aciklik_orani()+")",statement.RETURN_GENERATED_KEYS);


            anonimSirket.setAnonimsirket_id(GeneratedKeyAl.generatedKeyAl(statement.getGeneratedKeys(), "anonimsirket_id"));
            return anonimSirket;

        }catch (SQLException e)
        {
            throw new RuntimeException("Anonim şirket eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteAnonimSirket(long anonimsirket_id)
    {
        try {

            Statement statement=DBConnection.connect().createStatement();
            long sirket_id=findSirketIdByAnonimSirketId(anonimsirket_id);
            statement.executeUpdate("delete from sirket where sirket_id='"+sirket_id+"'");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Anonim şirket silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateAnonimsirket(AnonimSirket anonimSirket)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            long anonimsirket_id=findAnonimsirketidBySirketAd(anonimSirket.getSirket().getSirket_ad());

            statement.executeUpdate("update sirket " +
                    "set gelir="+anonimSirket.getSirket().getGelir()+
                    ",gider="+anonimSirket.getSirket().getGider()+
                    ",vergi_borcu="+anonimSirket.getSirket().getVergi_borcu()+" " +
                    "where sirket_ad='"+anonimSirket.getSirket().getSirket_ad()+"'");

            statement.executeUpdate("update anonimsirket " +
                    "set halka_aciklik_orani="+anonimSirket.getHalka_aciklik_orani()+" " +
                    "where anonimsirket_id='"+anonimsirket_id+"'");

            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Anonim şirket güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public AnonimSirket searchAnonimSirket(long anonimsirket_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananAnonimSirket=statement.executeQuery("select * from sirket natural join anonimsirket where anonimsirket_id='"+anonimsirket_id+"'");
            if (arananAnonimSirket.next())
            {
                long sirket_id=arananAnonimSirket.getLong("sirket_id");
                String sirket_ad= arananAnonimSirket.getString("sirket_ad");
                long vergi_no=arananAnonimSirket.getLong("vergi_no");
                int gelir=arananAnonimSirket.getInt("gelir");
                int gider=arananAnonimSirket.getInt("gider");
                int vergi_borcu= arananAnonimSirket.getInt("vergi_borcu");
                int halka_aciklik_orani=arananAnonimSirket.getInt("halka_aciklik_orani");

                return new AnonimSirket(new Sirket(sirket_id,sirket_ad,vergi_no,gelir,gider,vergi_borcu),anonimsirket_id,halka_aciklik_orani);

            }
            else {
                return null;
            }
        }catch (SQLException e)
        {
            throw new RuntimeException("Anonim şirket aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<AnonimSirket> getAnonimSirket()
    {
        anonimSirketList=new ArrayList<>();
        try {

            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananAnonimSirketler=statement.executeQuery("select * from sirket natural join anonimsirket");

            while (arananAnonimSirketler.next())
            {
                long sirket_id=arananAnonimSirketler.getLong("sirket_id");
                String sirket_ad= arananAnonimSirketler.getString("sirket_ad");
                long vergi_no=arananAnonimSirketler.getLong("vergi_no");
                int gelir=arananAnonimSirketler.getInt("gelir");
                int gider=arananAnonimSirketler.getInt("gider");
                int vergi_borcu= arananAnonimSirketler.getInt("vergi_borcu");
                long anonimsirket_id=arananAnonimSirketler.getLong("anonimsirket_id");
                int halka_aciklik_orani=arananAnonimSirketler.getInt("halka_aciklik_orani");

                anonimSirketList.add(new AnonimSirket(new Sirket(sirket_id,sirket_ad,vergi_no,gelir,gider,vergi_borcu),anonimsirket_id,halka_aciklik_orani));
            }

            return anonimSirketList;

        }catch (SQLException e)
        {
            throw new RuntimeException("Anonim şirketler aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    private long findAnonimsirketidBySirketAd(String sirket_ad)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            return GeneratedKeyAl.generatedKeyAl(statement.executeQuery("select anonimsirket_id from sirket natural join anonimsirket where sirket_ad = '"+sirket_ad+"'"),"anonimsirket_id");
        }catch (SQLException e)
        {
            throw new RuntimeException("şirket adından Anonim Şirket id bulunamadı. Hata: "+e.getMessage(),e);
        }
    }

    private long findSirketIdByAnonimSirketId(long anonimsirket_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            return GeneratedKeyAl.generatedKeyAl(statement.executeQuery("select sirket_id from sirket natural join anonimsirket where anonimsirket_id='"+anonimsirket_id+"'"),"sirket_id");
        }catch (SQLException e)
        {
            throw new RuntimeException("Anonim şirket'den Şirket id bulunamadı. Hata: "+e.getMessage(),e);
        }
    }
}
