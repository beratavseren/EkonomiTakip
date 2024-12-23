package com.example.demo.Dao;

import com.example.demo.Util.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class KamuCalisaniMudurlukSehirDao {
    public void addKamuCalisaniMudurlukSehir(long mudurluk_sehir_id,long kamu_calisani_id,int maas)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into kamucalisani_mudurluk_sehir (mudurluk_sehir_id,kamu_calisani_id,maas) values ('"+mudurluk_sehir_id+"','"+kamu_calisani_id+"',"+maas+")");
        }catch (SQLException e)
        {
            throw new RuntimeException("kamucalisani_mudurluk_sehir ara tablosuna veri eklenemedi"+e.getMessage(),e);
        }
    }

    public boolean updateKamuCalisaniMudurlukSehir(long kamu_calisani_id,int maas)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            statement.executeUpdate("update kamucalisani_mudurluk_sehir set maas="+maas+" where kamu_calisani_id='"+kamu_calisani_id+"' ");
            return true;
        }catch (SQLException e)
        {
            throw new RuntimeException("kamucalisani_mudurluk_sehir ara tablosunda veri güncellenemedi"+e.getMessage(),e);
        }
    }
}
