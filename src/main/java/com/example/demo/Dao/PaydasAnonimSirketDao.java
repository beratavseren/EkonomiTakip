package com.example.demo.Dao;



import com.example.demo.Entity.AnonimSirket;
import com.example.demo.Util.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class PaydasAnonimSirketDao {
    public void addPaydasAnonimSirket(long paydas_id, int hisse_sayisi, AnonimSirket anonimSirket)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into paydas_anonimsirket (paydas_id,hisse_sayisi,anonimsirket_id) values ('"+paydas_id+"',"+hisse_sayisi+",'"+anonimSirket.getAnonimsirket_id()+"')");
        }catch (SQLException e)
        {
            throw new RuntimeException("Paydas anonim şirket ara tablosuna eklenemedi. Hata: "+e.getMessage(),e);
        }
    }
}
