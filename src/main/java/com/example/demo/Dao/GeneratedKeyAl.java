package com.example.demo.Dao;

import java.sql.ResultSet;

public abstract class GeneratedKeyAl {
    protected static long generatedKeyAl(ResultSet resultSet,String columnName) {
        try {
            if (resultSet.next()) {
                return resultSet.getInt(columnName);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
}
