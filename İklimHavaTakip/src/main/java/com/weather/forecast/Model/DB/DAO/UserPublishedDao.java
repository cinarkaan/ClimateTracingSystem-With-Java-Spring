package com.weather.forecast.Model.DB.DAO;

import com.weather.forecast.Model.DB.Entity.UserData;
import com.weather.forecast.Model.DB.Entity.UserPublished;
import com.weather.forecast.Model.DB.Util.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserPublishedDao {
    Connection connection = null;
    DBConnect dbConnect = new DBConnect();

    public boolean Create (UserPublished userPublished) {
        String query = "insert into CurrentlyData(user_id,location,publish_date," +
                "publish_time,currently_temperature,currently_event," +
                "currently_humidity,currently_windy)  values("+userPublished.getUser_id()+",'"+userPublished.getLocation()+"'," +
                "'"+userPublished.getDate()+"','"+userPublished.getTime()+"'," +
                ""+userPublished.getCurrently_temperature()+",'"+userPublished.getCurrently_event()+"'," +
                ""+userPublished.getCurrently_humidity()+","+userPublished.getGetCurrently_windy()+")";
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

    public boolean getUseridFromPublished (Long user_id) {
        Long id = null;
        String query = "select * from currentlydata where user_id = " + user_id;
        try {
            connection = dbConnect.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = resultSet.getLong("user_id");
            }
            if (id == user_id) {
                System.out.println("Kayıt mecut");
                return true;
            } else {
                System.out.println("Kayıt mevcut degil!!!!");
                return false;
            }
            } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public ArrayList<UserData> Read () {
        String query = "select userproperties.name,userproperties.surname,location,publish_date,publish_time,currently_temperature" +
                ",currently_event,currently_humidity,currently_windy from currentlydata" +
                " inner join userproperties on userproperties.user_id = currentlydata.user_id";
        ArrayList<UserData> userDataList = new ArrayList<>();
        try {
            connection = dbConnect.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                UserData userData = new UserData();
                userData.setName(resultSet.getString("name"));
                userData.setSurname(resultSet.getString("surname"));
                userData.setLocation(resultSet.getString("location"));
                userData.setPublish_Date(resultSet.getString("publish_date"));
                userData.setPublish_Time(resultSet.getString("publish_time"));
                userData.setTemperature(resultSet.getInt("currently_temperature"));
                userData.setEvent(resultSet.getString("currently_event"));
                userData.setHumidity((float)resultSet.getDouble("currently_humidity"));
                userData.setWindy((float)resultSet.getDouble("currently_windy"));
                userDataList.add(userData);
            }
            return userDataList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean Update (UserPublished userPublished) {
        String query = "update currentlydata set location='"+userPublished.getLocation()+"'" +
                ",publish_date='"+userPublished.getDate()+"',publish_time='"+userPublished.getTime()+"'" +
                ",currently_temperature="+userPublished.getCurrently_temperature()+"" +
                ",currently_event='"+userPublished.getCurrently_event()+"'" +
                ",currently_humidity="+userPublished.getCurrently_humidity()+"" +
                ",currently_windy="+userPublished.getGetCurrently_windy()+" where user_id = " + userPublished.getUser_id();
        try {
            connection = dbConnect.connection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println(query);
            return true;
        } catch (Exception e) {
            System.out.println("Yazılan sorgu : " + query);
            System.out.println(e);
            return false;
        }
    }

}
