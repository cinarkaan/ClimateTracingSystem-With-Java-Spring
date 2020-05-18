package com.weather.forecast.Model.DB.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

    Connection connection;
    String url = "jdbc:postgresql://localhost:5432/ClimateAndWeatherTracking"; // Bağlanılacak veritabanı
    String user = "postgres"; // Veritabanı kullanıcı ismi
    String pass = "kaan123"; // Veritabanı parolası

    public Connection connection () {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,user,pass);
            System.out.println("Baglanti basarili");
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Baglanti basarisiz!!!!!");
        }
            return connection;
    }
}
