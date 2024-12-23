package com.example.demo.Dao;



import com.example.demo.Entity.Kisi;
import com.example.demo.Entity.Paydas;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaydasDao {
    List<Paydas> paydasList;

    public Paydas addPaydas(Paydas paydas)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into paydas (tckn) values ('"+paydas.getKisi().getTckn()+"')",statement.RETURN_GENERATED_KEYS);

            long paydas_id=GeneratedKeyAl.generatedKeyAl(statement.getGeneratedKeys(), "paydas_id");
            paydas.setPaydas_id(paydas_id);

            return paydas;

        }catch (SQLException e)
        {
            throw new RuntimeException("Paydas eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deletePaydas(long paydas_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();

            long tckn = findTcknByPaydasId(paydas_id);
            statement.executeUpdate("delete from kisi where tckn = '"+tckn+"' ");

            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Paydas silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updatePaydas(Paydas paydas)
    {
        try {
            Statement statement = DBConnection.connect().createStatement();
            statement.executeUpdate("update kisi set isim = '"+paydas.getKisi().getIsim()+"',soyisim = '"+paydas.getKisi().getSoyisim()+"' where tckn='"+paydas.getKisi().getTckn()+"'");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Paydas güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Paydas searchPaydas(long paydas_id)
    {
        try {
            Statement statement = DBConnection.connect().createStatement();
            ResultSet arananPaydas = statement.executeQuery("select * from kisi natural join paydas where paydas_id='"+paydas_id+"'");

            if (arananPaydas.next())
            {
                long tckn = arananPaydas.getLong("tckn");
                String isim = arananPaydas.getString("isim");
                String soyisim = arananPaydas.getString("soyisim");
                String ilce = arananPaydas.getString("ilce");
                String cadde = arananPaydas.getString("cadde");
                String adres = arananPaydas.getString("adres");

                return new Paydas(new Kisi(tckn,isim,soyisim,ilce,cadde,adres),paydas_id);
            }
            else {
                return null;
            }
        }catch (SQLException e)
        {
            throw new RuntimeException("Paydas aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<Paydas> getPaydas()
    {
        paydasList=new ArrayList<>();

        try {

            Statement statement = DBConnection.connect().createStatement();
            ResultSet arananPaydaslar = statement.executeQuery("select * from kisi natural join paydas");

            while (arananPaydaslar.next())
            {
                long tckn = arananPaydaslar.getLong("tckn");
                String isim = arananPaydaslar.getString("isim");
                String soyisim = arananPaydaslar.getString("soyisim");
                String ilce = arananPaydaslar.getString("ilce");
                String cadde = arananPaydaslar.getString("cadde");
                String adres = arananPaydaslar.getString("adres");
                long paydas_id = arananPaydaslar.getLong("paydas_id");

                paydasList.add(new Paydas(new Kisi(tckn,isim,soyisim,ilce,cadde,adres),paydas_id));
            }

            return paydasList;

        }catch (SQLException e)
        {
            throw new RuntimeException("Paydaslar aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public long findTcknByPaydasId(long paydas_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            return GeneratedKeyAl.generatedKeyAl(statement.executeQuery("select tckn from kisi natural join paydas where paydas_id='"+paydas_id+"'"),"tckn");
        }catch (SQLException e)
        {
            throw new RuntimeException("tckn paydas_id den bulunamadı. Hata: "+e.getMessage(),e);
        }
    }
}
