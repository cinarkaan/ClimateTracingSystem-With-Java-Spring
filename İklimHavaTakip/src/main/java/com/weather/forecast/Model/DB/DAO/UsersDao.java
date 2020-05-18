package com.weather.forecast.Model.DB.DAO;

import com.weather.forecast.Model.DB.Entity.Users;
import com.weather.forecast.Model.DB.Util.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsersDao {
    Connection connection = null;
    DBConnect dbConnect = new DBConnect();

    // Sing Up işlemi yapar
    public boolean Create (Users users) {
        if (users.getId().equals("") || users.getPassword().equals("")) {
            System.out.println("Bos kayıt yapılamaz !!!!!!!!");
            return false;
        } else {
            String query = "insert into users(id,password) values('" + users.getId() + "','" + users.getPassword() + "')";
            try {
                connection = dbConnect.connection();
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                System.out.println("Values was able to inserted with succesfully!!!!");
                connection.close();
                statement.close();
                return true;
            } catch (Exception e) {
                System.out.println(query);
                System.out.println(e);
                System.out.println("Create is not succesfully");
                return false;
            }
        }
    }

    // Sing in işlemi yapar
    public boolean Read (Users users) {
        String query = "Select * from users where id = '"+users.getId()+"' ";
        String id = null;
        String pass = null;
        try {
            connection = dbConnect.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                 id = resultSet.getString("id");
                 pass = resultSet.getString("password");
            }
            System.out.println("id = " + id);
            System.out.println("pass = " + pass);
            if (pass.equals(users.getPassword())) {
                connection.close();
                statement.close();
                resultSet.close();
                return true;
            } else {
                connection.close();
                statement.close();
                resultSet.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Yazilan sorgu : " + query);
            System.out.println("Id : " + id);
            System.out.println("Password : " + pass);
            System.out.println(e);
            return false;
        }
    }

    // user_id'yi getirir
    public Long getUser_id (String id) {
        String query = "Select * from users where id = '"+id+"' ";
        Long user_id = null;
        try {
            connection = dbConnect.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                user_id = resultSet.getLong("user_id");
            }
            System.out.println("Getirilen user_id = " + user_id);
            return user_id;
        } catch (Exception e) {
            System.out.println("Yazılan sorgu : " + query);
            System.out.println(e);
            return null;
        }
    }


}
