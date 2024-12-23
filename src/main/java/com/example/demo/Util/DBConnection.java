package com.example.demo.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection=null;
    private DBConnection()
    {
    }
    public static Connection connect()
    {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EkonomiTakip","postgres","admin");
        }
        catch (Exception e){
        System.out.println(e);
        }
        return connection;
    }
}
