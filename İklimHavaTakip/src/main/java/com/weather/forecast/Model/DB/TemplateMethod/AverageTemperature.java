package com.weather.forecast.Model.DB.TemplateMethod;

import com.weather.forecast.Model.DB.Entity.TemperatureAverage;
import com.weather.forecast.Model.DB.Util.GetEarthTempByYear;

import java.util.ArrayList;

public class AverageTemperature extends Data {

    ArrayList <TemperatureAverage> temperatureByYearList;
    GetEarthTempByYear getEarthTempByYear;

    public AverageTemperature () {
        run();
    }

    @Override
    void Initialize() {
        getEarthTempByYear = new GetEarthTempByYear();
    }

    @Override
    void prepareData() {
        temperatureByYearList = new ArrayList<>();
    }

    @Override
    void Finish() {
        getEarthTempByYear.getDataFromUrl();
        temperatureByYearList = getEarthTempByYear.TurnListFromUrl();
    }

    @Override
    public void run() {
        Initialize();
        prepareData();
        Finish();
    }

    public ArrayList<TemperatureAverage> getTemperatureByYearList() {
        return temperatureByYearList;
    }
}
