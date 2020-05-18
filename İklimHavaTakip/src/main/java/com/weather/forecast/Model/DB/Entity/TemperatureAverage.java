package com.weather.forecast.Model.DB.Entity;

public class TemperatureAverage {

    private int Year;
    private float AverageTemperature;

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public float getAverageTemperature() {
        return AverageTemperature;
    }

    public void setAverageTemperature(float averageTemperature) {
        AverageTemperature = averageTemperature;
    }
}
