package com.example.demo.Dao;



import com.example.demo.Entity.Sirket;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SirketDao {
    List<Sirket> sirketList;
    public Sirket addSirket(Sirket sirket)
    {
        try {

            Statement statement = DBConnection.connect().createStatement();
            statement.executeUpdate("insert into sirket (sirket_ad,gelir,gider,vergi_borcu) values ('"+sirket.getSirket_ad()+"' ,"+sirket.getGelir()+" ,"+sirket.getGider()+" ,"+sirket.getVergi_borcu()+")", statement.RETURN_GENERATED_KEYS);

            long sirket_id=GeneratedKeyAl.generatedKeyAl(statement.getGeneratedKeys(),"sirket_id");
            sirket.setSirket_id(sirket_id);

            return sirket;

        }catch (SQLException e)
        {
            throw new RuntimeException("Şirket eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public void deleteSirket (long sirket_id)
    {
        try {

            Statement statement=DBConnection.connect().createStatement();
            statement.executeUpdate("delete from sirket where sirket_id = '"+sirket_id+"'");

        }catch (SQLException e)
        {
            throw new RuntimeException("Şirket silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public void updateSirket (Sirket sirket)
    {
        try {

            Statement statement=DBConnection.connect().createStatement();
            statement.executeUpdate("update sirket set gelir='"+sirket.getGelir()+"',gider='"+sirket.getGider()+"',vergi_borcu='"+sirket.getVergi_borcu()+"' where sirket_ad='"+sirket.getSirket_ad()+"'");

        }catch (SQLException e)
        {
            throw new RuntimeException("Şirket güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Sirket searchSirket(long sirket_id)
    {
        try {

            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananKisi=statement.executeQuery("select * from sirket where sirket_id='"+sirket_id+"'");

            if (arananKisi.next())
            {
                return new Sirket(arananKisi.getLong("sirket_id"),arananKisi.getString("sirket_ad"), arananKisi.getLong("vergi_no"), arananKisi.getInt("gelir"), arananKisi.getInt("gider"),arananKisi.getInt("vergi_borcu"));
            }else {
                return null;
            }

        }catch (SQLException e)
        {
            throw new RuntimeException("Şirket aranamadı. Hata: " + e.getMessage(),e);
        }
    }

    public List<Sirket> getSirket()
    {
        try {

            sirketList=new ArrayList<Sirket>();

            Statement statement=DBConnection.connect().createStatement();
            ResultSet Sirketler=statement.executeQuery("select * from sirket");

            while (Sirketler.next())
            {

                long sirket_id=Sirketler.getLong("sirket_id");
                String sirket_ad = Sirketler.getString("sirket_ad");
                long vergi_no = Sirketler.getLong("vergi_no");
                int gelir = Sirketler.getInt("gelir");
                int gider = Sirketler.getInt("gider");
                int vergi_borcu = Sirketler.getInt("vergi_borcu");

                sirketList.add(new Sirket(sirket_id,sirket_ad,vergi_no,gelir,gider,vergi_borcu));
            }

            return sirketList;

        }catch (SQLException e)
        {
            throw new RuntimeException("Sirketler aranamadı. Hata:"+e.getMessage(),e);
        }
    }
}
