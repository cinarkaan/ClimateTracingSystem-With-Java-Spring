package com.weather.forecast.Model.DB.DAO;

import com.weather.forecast.Model.DB.Entity.UserProperties;
import com.weather.forecast.Model.DB.Util.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserPropertiesDao {

    Connection connection = null;
    DBConnect dbConnect = new DBConnect();

    public boolean Create (UserProperties pentity) {
        String query = "insert into userproperties values('"+pentity.getUser_id()+"','"+pentity.getName()+"'," +
                "'"+pentity.getSurname()+"','"+pentity.getPhone()+"'," +
                "'"+pentity.getJob()+"','"+pentity.getReason_register()+"'," +
                "'"+pentity.getCountry()+"','"+pentity.getCity()+"')";
        try {
            connection = dbConnect.connection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("UserProperties was created with succesful");
            connection.close();
            statement.close();
            return true;
        } catch (Exception e) {
            System.out.println("UserProperties created failed !!!!!!");
            System.out.println("Yazılan sorgu : " + query);
            System.out.println(e);
            return false;
        }
    }

    public void Update (UserProperties userentty) {
        String query = "Update userproperties set name='"+userentty.getName()+"', " +
                "surname = '"+userentty.getSurname()+"', phone= '"+userentty.getPhone()+"'," +
                " job='"+userentty.getJob()+"',reason_register = '"+userentty.getReason_register()+"'" +
                " ,country = '"+userentty.getCountry()+"' ,city = '"+userentty.getCity()+"' " +
                "where user_id = "+userentty.getUser_id()+"";
        try {
            connection = dbConnect.connection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println(query);
        } catch (Exception e) {
            System.out.println("Yazılan sorgu : " + query);
            System.out.println(e);
        }
    }

    public UserProperties Read (UserProperties userProperties) {
        String query = "select * from userproperties where user_id = '"+ userProperties.getUser_id()+"' ";
        try {
            connection = dbConnect.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                userProperties.setName(resultSet.getString("name"));
                userProperties.setSurname(resultSet.getString("surname"));
                userProperties.setPhone(resultSet.getString("phone"));
                userProperties.setJob(resultSet.getString("job"));
                userProperties.setReason_register(resultSet.getString("reason_register"));
                userProperties.setCountry(resultSet.getString("country"));
                userProperties.setCity(resultSet.getString("city"));
            }
            System.out.println("Userproperties read was succesfully!!!!!");
            return userProperties;
        } catch (Exception e) {
            System.out.println("Yazılan sorgu : " + query);
            System.out.println(e);
            return null;
        }
    }



}
