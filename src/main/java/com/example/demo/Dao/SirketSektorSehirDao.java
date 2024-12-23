package com.example.demo.Dao;



import com.example.demo.Util.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class SirketSektorSehirDao {
    public void addSirketSektorSehir(long sirket_id,long sektor_id,int plaka_kodu)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into sirket_sektor_sehir (sirket_id,sektor_id,plaka_kodu) values ('"+sirket_id+"','"+sektor_id+"',"+plaka_kodu+")");
        }catch (SQLException e)
        {
            throw new RuntimeException("Sirket_sektor_sehir ara tablosuna veri eklenemedi. Hata: "+e.getMessage(),e);
        }
    }
}
