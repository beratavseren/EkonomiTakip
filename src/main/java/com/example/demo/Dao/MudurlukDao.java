package com.example.demo.Dao;



import com.example.demo.Entity.Bakanlik;
import com.example.demo.Entity.Mudurluk;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MudurlukDao {
    List<Mudurluk> mudurlukList;

    public Mudurluk addMudurluk(Mudurluk mudurluk)
    {
        try {

            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into mudurluk (mudurluk_ad,gelir,gider,netgelir,bakanlik_id) values ('"+mudurluk.getMudurluk_ad()+"',"+mudurluk.getGelir()+","+mudurluk.getGider()+","+mudurluk.getNetgelir()+",'"+mudurluk.getBakanlik().getBakanlik_id()+"')",statement.RETURN_GENERATED_KEYS);

            long mudurluk_id=GeneratedKeyAl.generatedKeyAl(statement.getGeneratedKeys(), "mudurluk_id");
            mudurluk.setMudurluk_id(mudurluk_id);

            return mudurluk;

        }catch (SQLException e)
        {
            throw new RuntimeException("Mudurluk eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteMudurluk(long mudurluk_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            statement.executeUpdate("delete from mudurluk where mudurluk_id='"+mudurluk_id+"'");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Mudurluk silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateMudurluk(long mudurluk_id,Mudurluk mudurluk)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            statement.executeUpdate("update mudurluk set gelir="+mudurluk.getGelir()+",gider="+mudurluk.getGider()+",netgelir="+mudurluk.getNetgelir()+" where mudurluk_id='"+mudurluk_id+"' ");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Mudurluk güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Mudurluk searchMudurluk(long mudurluk_id)
    {
        try {

            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananMudurluk = statement.executeQuery("select * from mudurluk natural join bakanlik where mudurluk_id='"+mudurluk_id+"'");

            if (arananMudurluk.next())
            {

                long bakanlik_id=arananMudurluk.getLong("bakanlik_id");
                String bakanlik_ad= arananMudurluk.getString("bakanlik_ad");

                String mudurluk_ad= arananMudurluk.getString("mudurluk_ad");
                int gelir=arananMudurluk.getInt("gelir");
                int gider=arananMudurluk.getInt("gider");
                int netgelir=arananMudurluk.getInt("netgelir");

                return new Mudurluk(mudurluk_ad,mudurluk_id,gelir,gider,netgelir,new Bakanlik(bakanlik_ad,bakanlik_id));

            }
            else {
                return null;
            }
        }catch (SQLException e)
        {
            throw new RuntimeException("Mudurluk aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<Mudurluk> getMudurluk()
    {
        mudurlukList=new ArrayList<>();

        try {
            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananMudurlukler = statement.executeQuery("select * from mudurluk natural join bakanlik");

            while (arananMudurlukler.next())
            {

                long bakanlik_id=arananMudurlukler.getLong("bakanlik_id");
                String bakanlik_ad= arananMudurlukler.getString("bakanlik_ad");

                long mudurluk_id = arananMudurlukler.getLong("mudurluk_id");
                String mudurluk_ad= arananMudurlukler.getString("mudurluk_ad");
                int gelir=arananMudurlukler.getInt("gelir");
                int gider=arananMudurlukler.getInt("gider");
                int netgelir=arananMudurlukler.getInt("netgelir");

                mudurlukList.add(new Mudurluk(mudurluk_ad,mudurluk_id,gelir,gider,netgelir,new Bakanlik(bakanlik_ad,bakanlik_id)));
            }

            return mudurlukList;

        }catch (SQLException e)
        {
            throw new RuntimeException("Mudurlukler aranamadı. Hata: "+e.getMessage(),e);
        }
    }
}
