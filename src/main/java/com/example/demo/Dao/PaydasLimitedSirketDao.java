package com.example.demo.Dao;


import com.example.demo.Entity.LimitedSirket;
import com.example.demo.Util.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class PaydasLimitedSirketDao {
    public void addPaydas(long paydas_id, int ortaklik_yuzdesi, LimitedSirket limitedSirket)
    {
        try {
            Statement statement= DBConnection.connect().createStatement();
            statement.executeUpdate("insert into paydas_limitedsirket (paydas_id,ortaklik_yuzdesi,limitedsirket_id) values ('"+paydas_id+"',"+ortaklik_yuzdesi+",'"+limitedSirket.getLimitedsirket_id()+"')");
        }catch (SQLException e)
        {
            throw new RuntimeException("paydas_limitedsirket ara tablosuna veri eklenemedi"+e.getMessage(),e);
        }
    }
}
