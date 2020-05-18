package com.weather.forecast.Model.AbstractFactory.Wunderground;

import com.weather.forecast.Model.AbstractFactory.AbstractFactory;
import com.weather.forecast.Model.AbstractFactory.Services;

public class WundergroundFactory extends AbstractFactory {
    @Override
    public Services getServices(String ServiceName) {
        if (ServiceName.equalsIgnoreCase("Current")) {
            return new WundergroundCurrent();
        } else if (ServiceName.equalsIgnoreCase("Long")) {
            return new WundergroundLong();
        }
        return null;
    }
}
