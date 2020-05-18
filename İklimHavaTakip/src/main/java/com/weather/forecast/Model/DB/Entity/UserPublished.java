package com.weather.forecast.Model.DB.Entity;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;

public class UserPublished {

    private Long user_id;
    private Long data_id;
    private String location;
    private String date;
    private String time;
    private int currently_temperature;
    private String currently_event;
    private float currently_humidity;
    private float getCurrently_windy;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getData_id() {
        return data_id;
    }

    public void setData_id(Long data_id) {
        this.data_id = data_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        Format f = new SimpleDateFormat("MM/dd/yy");
        String strDate = f.format(new Date());
        return strDate;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        LocalTime now = LocalTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.time = time;
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCurrently_temperature() {
        return currently_temperature;
    }

    public void setCurrently_temperature(int currently_temperature) {
        this.currently_temperature = currently_temperature;
    }

    public String getCurrently_event() {
        return currently_event;
    }

    public void setCurrently_event(String currently_event) {
        this.currently_event = currently_event;
    }

    public float getCurrently_humidity() {
        return currently_humidity;
    }

    public void setCurrently_humidity(float currently_humidity) {
        this.currently_humidity = currently_humidity;
    }

    public float getGetCurrently_windy() {
        return getCurrently_windy;
    }

    public void setGetCurrently_windy(float getCurrently_windy) {
        this.getCurrently_windy = getCurrently_windy;
    }

}


