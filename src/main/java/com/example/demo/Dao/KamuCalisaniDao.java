package com.example.demo.Dao;

import com.example.demo.Entity.KamuCalisani;
import com.example.demo.Entity.Kisi;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KamuCalisaniDao {
    List<KamuCalisani> kamuCalisaniList;
    public KamuCalisani addKamuCalisani(KamuCalisani kamuCalisani)
    {
        try {

            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into kamucalisani (tckn) values ('"+kamuCalisani.getKisi().getTckn()+"')",statement.RETURN_GENERATED_KEYS);

            long kamu_calisani_id = GeneratedKeyAl.generatedKeyAl(statement.getGeneratedKeys(),"kamu_calisani_id");
            kamuCalisani.setKamu_calisani_id(kamu_calisani_id);

            return kamuCalisani;

        }catch (SQLException e)
        {
            throw new RuntimeException("Kamu çalışanı eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteKamuCalisani(long kamu_calisani_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            long tckn = findtcknbykamucalisaniid(kamu_calisani_id);
            statement.executeUpdate("delete from kisi where tckn='"+tckn+"'");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Kamu çalışanı silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateKamuCalisani(long kamu_calisani_id,KamuCalisani kamuCalisani)
    {
        try {

            Statement statement=DBConnection.connect().createStatement();

            long tckn = findtcknbykamucalisaniid(kamu_calisani_id);
            statement.executeUpdate("update kisi set isim='"+kamuCalisani.getKisi().getIsim()+"',soyisim='"+kamuCalisani.getKisi().getSoyisim()+"' where tckn='"+tckn+"'");

            return true;

        }catch (SQLException e)
        {
            throw new RuntimeException("Kamu çalışanı güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public KamuCalisani searchKamuCalisani(long kamu_calisani_id)
    {
        try {

            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananKamuCalisani =statement.executeQuery("select * from kamucalisani natural join kisi where kamu_calisani_id='"+kamu_calisani_id+"'");

            if (arananKamuCalisani.next())
            {
                String isim = arananKamuCalisani.getString("isim");
                String soyisim = arananKamuCalisani.getString("soyisim");
                long tckn = arananKamuCalisani.getLong("tckn");

                return new KamuCalisani(kamu_calisani_id,new Kisi(tckn,isim,soyisim));
            }else {
                return null;
            }

        }catch (SQLException e)
        {
            throw new RuntimeException("Kamu çalışanı aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<KamuCalisani> getKamuCalisani()
    {
        kamuCalisaniList=new ArrayList<>();

        try {

            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananKamuCalisani =statement.executeQuery("select * from kamucalisani natural join kisi");

            while (arananKamuCalisani.next())
            {
                String isim = arananKamuCalisani.getString("isim");
                String soyisim = arananKamuCalisani.getString("soyisim");
                long tckn = arananKamuCalisani.getLong("tckn");

                long kamu_calisani_id= arananKamuCalisani.getLong("kamu_calisani_id");

                kamuCalisaniList.add(new KamuCalisani(kamu_calisani_id,new Kisi(tckn,isim,soyisim)));
            }

            return kamuCalisaniList;

        }catch (SQLException e)
        {
            throw new RuntimeException("Kamu çalışanları aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public long findtcknbykamucalisaniid(long kamu_calisani_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            long tckn=GeneratedKeyAl.generatedKeyAl(statement.executeQuery("select tckn from kisi natural join kamucalisani where kamu_calisani_id = '"+kamu_calisani_id+"' "),"tckn");
            return tckn;
        }catch (SQLException e)
        {
            throw new RuntimeException("tckn kamu_calisani_id yardımıyla bulunamadı. Hata: "+e.getMessage(),e);
        }
    }
}
