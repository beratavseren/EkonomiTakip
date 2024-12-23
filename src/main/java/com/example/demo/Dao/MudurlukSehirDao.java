package com.example.demo.Dao;

import com.example.demo.Util.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class MudurlukSehirDao {
    public long addMudurlukSehir(long mudurluk_id,int plaka_kodu)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into mudurluk_sehir (mudurluk_id,plaka_kodu) values ('"+mudurluk_id+"',"+plaka_kodu+")",statement.RETURN_GENERATED_KEYS);
            return GeneratedKeyAl.generatedKeyAl(statement.getResultSet(), "mudurluk_sehir_id");
        }catch (SQLException e)
        {
            throw new RuntimeException("mudurluk şehir ara tablosuna ekleme yapılamadı"+e.getMessage(),e);
        }
    }

    public long searchMudurlukSehir(long mudurluk_id,int plaka_kodu)
    {
        try {
            Statement statement=DBConnection.connect().createStatement();
            return GeneratedKeyAl.generatedKeyAl(statement.executeQuery("select mudurluk_sehir_id from mudurluk_sehir where mudurluk_id='"+mudurluk_id+"' and plaka_kodu="+plaka_kodu+" "),"mudurluk_sehir_id");
        }catch (SQLException e)
        {
            throw new RuntimeException("mudurluk şehir ara tablosunda arama yapılamadı"+e.getMessage(),e);
        }
    }
}
