package com.example.demo.Dao;



import com.example.demo.Entity.Kisi;
import com.example.demo.Entity.Paydas;
import com.example.demo.Entity.SahisSirket;
import com.example.demo.Entity.Sirket;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SahisSirketDao {
    List<SahisSirket> sahisSirketList;

    public SahisSirket addSahisSirket(SahisSirket sahisSirket)
    {
        try {

            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into sahissirket (sirket_id,paydas_id) values ('"+sahisSirket.getSirket().getSirket_id()+"','"+sahisSirket.getPaydas().getPaydas_id()+"')",statement.RETURN_GENERATED_KEYS);

            long sahissirket_id = GeneratedKeyAl.generatedKeyAl(statement.getGeneratedKeys(),"sahissirket_id");
            sahisSirket.setSahissirket_id(sahissirket_id);

            return sahisSirket;

        }catch (SQLException e)
        {
            throw new RuntimeException("Sahis şirketi eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean deleteSahisSirket(long sahissirket_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();

            long sirket_id=findSirketIdBySahisSirketId(sahissirket_id);
            statement.executeUpdate("delete from sirket where sirket_id = '"+sirket_id+"' ");

            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("Sahis şirketi silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    //hem şirketin sahibi değiştirilebilecek hem de şirketin gelir-gider vb. değişebilecek.
    public boolean updateSahisSirket(SahisSirket sahisSirket)
    {
        try {

            Statement statement = DBConnection.connect().createStatement();
            statement.executeUpdate("update sirket set gelir="+sahisSirket.getSirket().getGelir()+",gider = "+sahisSirket.getSirket().getGider()+", vergi_borcu="+sahisSirket.getSirket().getVergi_borcu()+" where sirket_ad='"+sahisSirket.getSirket().getSirket_ad()+"'");

            return true;

        }catch (SQLException e)
        {
            throw new RuntimeException("Sahis şirketi güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public boolean updateSahisSirketPaydas(long sahissirket_id, Paydas paydas)
    {
        try {

            Statement statement=DBConnection.connect().createStatement();
            statement.executeUpdate("update sahissirket set paydas_id='"+paydas.getPaydas_id()+"' where sahissirket_id='"+sahissirket_id+"'");

            return true;

        }catch (SQLException e)
        {
            throw new RuntimeException("Sahis şirketi güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public SahisSirket searchSahisSirket(long sahissirket_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            ResultSet sahisSirketResult =statement.executeQuery("select * from kisi natural join paydas natural join sahissirket natural join sirket where sahissirket_id='"+sahissirket_id+"'");

            if (sahisSirketResult.next())
            {
                long tckn = sahisSirketResult.getLong("tckn");
                String isim = sahisSirketResult.getString("isim");
                String soyisim = sahisSirketResult.getString("soyisim");
                String ilce = sahisSirketResult.getString("ilce");
                String cadde = sahisSirketResult.getString("cadde");
                String adres = sahisSirketResult.getString("adres");

                Kisi kisi=new Kisi(tckn,isim,soyisim,ilce,cadde,adres);

                long paydas_id = sahisSirketResult.getLong("paydas_id");

                Paydas paydas = new Paydas(kisi,paydas_id);

                String sirket_ad = sahisSirketResult.getString("sirket_ad");
                long sirket_id = sahisSirketResult.getLong("sirket_id");
                long vergi_no = sahisSirketResult.getLong("vergi_no");
                int gelir = sahisSirketResult.getInt("gelir");
                int gider = sahisSirketResult.getInt("gider");
                int vergi_borcu = sahisSirketResult.getInt("vergi_borcu");

                Sirket sirket= new Sirket(sirket_id,sirket_ad,vergi_no,gelir,gider,vergi_borcu);

                return new SahisSirket(sirket,paydas,sahissirket_id);
            }
            else {
                return null;
            }

        }catch (SQLException e)
        {
            throw new RuntimeException("Sahis şirketi aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<SahisSirket> getSahisSirket() {

        sahisSirketList=new ArrayList<>();

        try {

            Statement statement=DBConnection.connect().createStatement();
            ResultSet sahisSirketler=statement.executeQuery("select * from kisi natural join paydas natural join sahissirket natural join sirket");

            while (sahisSirketler.next())
            {
                long tckn = sahisSirketler.getLong("tckn");
                String isim = sahisSirketler.getString("isim");
                String soyisim = sahisSirketler.getString("soyisim");
                String ilce = sahisSirketler.getString("ilce");
                String cadde = sahisSirketler.getString("cadde");
                String adres = sahisSirketler.getString("adres");

                Kisi kisi=new Kisi(tckn,isim,soyisim,ilce,cadde,adres);

                long paydas_id = sahisSirketler.getLong("paydas_id");

                Paydas paydas = new Paydas(kisi,paydas_id);

                String sirket_ad = sahisSirketler.getString("sirket_ad");
                long sirket_id = sahisSirketler.getLong("sirket_id");
                long vergi_no = sahisSirketler.getLong("vergi_no");
                int gelir = sahisSirketler.getInt("gelir");
                int gider = sahisSirketler.getInt("gider");
                int vergi_borcu = sahisSirketler.getInt("vergi_borcu");

                Sirket sirket= new Sirket(sirket_id,sirket_ad,vergi_no,gelir,gider,vergi_borcu);

                long sahissirket_id = sahisSirketler.getLong("sahissirket_id");

                sahisSirketList.add(new SahisSirket(sirket,paydas,sahissirket_id));
            }

            return sahisSirketList;

        }catch (SQLException e)
        {
            throw new RuntimeException("Sahis şirketi aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public long findPaydasIdBySahisSirketId(long sahissirket_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            return GeneratedKeyAl.generatedKeyAl(statement.executeQuery("select paydas_id from sahissirket where sahissirket_id='"+sahissirket_id+"'"),"paydas_id");
        }catch (SQLException e)
        {
            throw new RuntimeException("şirket_id sahissirket_id den bulunamadı. Hata: "+e.getMessage(),e);
        }
    }

    public long findSirketIdBySahisSirketId(long sahissirket_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            return GeneratedKeyAl.generatedKeyAl(statement.executeQuery("select sirket_id from sirket natural join sahissirket where sahissirket_id='"+sahissirket_id+"'"),"sirket_id");
        }catch (SQLException e)
        {
            throw new RuntimeException("şirket_id sahissirket_id den bulunamadı. Hata: "+e.getMessage(),e);
        }
    }
}
