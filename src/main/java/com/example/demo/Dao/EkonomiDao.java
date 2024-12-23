package com.example.demo.Dao;


import com.example.demo.Entity.Ekonomi;
import com.example.demo.Util.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EkonomiDao {

    List<Ekonomi> ekonomiList;

    public Ekonomi addEkonomi(Ekonomi ekonomi)
    {
        try {

            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into ekonomi (ekonomi_ad) values ('"+ekonomi.getEkonomi_ad()+"')",statement.RETURN_GENERATED_KEYS);

            long ekonomi_id=GeneratedKeyAl.generatedKeyAl(statement.getGeneratedKeys(),"ekonomi_id");
            ekonomi.setEkonomi_id(ekonomi_id);

            return ekonomi;

        }catch (SQLException e)
        {
            throw new RuntimeException("Ekonomi eklenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public void deleteEkonomi(long ekonomi_id)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            statement.executeUpdate("delete from ekonomi where ekonomi_id = '"+ekonomi_id+"' ");
        }catch (SQLException e)
        {
            throw new RuntimeException("Ekonomi silinemedi. Hata: "+e.getMessage(),e);
        }
    }

    public void updateEkonomi(long ekonomi_id,Ekonomi ekonomi)
    {
        try {

            ekonomi.setEkonomi_id(ekonomi_id);

            Statement statement=DBConnection.connect().createStatement();
            statement.executeUpdate("update ekonomi set ekonomi_ad = '"+ekonomi.getEkonomi_ad()+"' where ekonomi_id = '"+ekonomi.getEkonomi_id()+"' ");

        }catch (SQLException e)
        {
            throw new RuntimeException("Ekonomi güncellenemedi. Hata: "+e.getMessage(),e);
        }
    }

    public Ekonomi searchEkonomi(long ekonomi_id)
    {
        try {

            Statement statement=DBConnection.connect().createStatement();
            ResultSet arananEkonomi = statement.executeQuery("select * from ekonomi where ekonomi_id = '"+ekonomi_id+"' ");

            if (arananEkonomi.next())
            {
                String ekonomi_ad = arananEkonomi.getString("ekonomi_ad");
                return new Ekonomi(ekonomi_ad,ekonomi_id);
            }
            else {
                return null;
            }

        }catch (SQLException e)
        {
            throw new RuntimeException("Ekonomi aranamadı. Hata: "+e.getMessage(),e);
        }
    }

    public List<Ekonomi> getEkonomi()
    {
        try {

            ekonomiList=new ArrayList<Ekonomi>();

            Statement statement = DBConnection.connect().createStatement();
            ResultSet ekonomiler = statement.executeQuery("select * from ekonomi");

            while (ekonomiler.next())
            {
                String ekonomi_ad = ekonomiler.getString("ekonomi_ad");
                long ekonomi_id = ekonomiler.getLong("ekonomi_id");

                ekonomiList.add(new Ekonomi(ekonomi_ad,ekonomi_id));
            }

            return ekonomiList;

        }catch (SQLException e)
        {
            throw new RuntimeException("Ekonomi aranamadı. Hata: "+e.getMessage(),e);
        }
    }
}
