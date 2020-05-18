package com.weather.forecast.Model.AbstractFactory.Accuweather;

import com.weather.forecast.Model.AbstractFactory.AbstractFactory;
import com.weather.forecast.Model.AbstractFactory.Services;

public class AccuweatherFactory extends AbstractFactory {

    @Override
    public Services getServices(String ServiceName) {
        if (ServiceName.equalsIgnoreCase("Current")) {
            return new AccuweatherCurrent();
        } else if (ServiceName.equalsIgnoreCase("Long")) {
            return new AccuweatherLong();
        }
        return null;
    }
}
