package com.weather.forecast.Model.DB.Entity;

import java.sql.Time;

public class UserData {

    private String Name;
    private String Surname;
    private String Location;
    private String publish_Date;
    private String publish_Time;
    private int Temperature;
    private String Event;
    private double Humidity;
    private double Windy;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPublish_Date() {
        return publish_Date;
    }

    public void setPublish_Date(String publish_Date) {
        this.publish_Date = publish_Date;
    }

    public String getPublish_Time() {
        return publish_Time;
    }

    public void setPublish_Time(String publish_Time) {
        this.publish_Time = publish_Time;
    }

    public int getTemperature() {
        return Temperature;
    }

    public void setTemperature(int temperature) {
        Temperature = temperature;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public double getHumidity() {
        return Humidity;
    }

    public void setHumidity(double humidity) {
        Humidity = humidity;
    }

    public double getWindy() {
        return Windy;
    }

    public void setWindy(double windy) {
        Windy = windy;
    }
}
