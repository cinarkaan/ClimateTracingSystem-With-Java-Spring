package com.weather.forecast.Model.AbstractFactory;

import com.weather.forecast.Model.AbstractFactory.Accuweather.AccuweatherFactory;
import com.weather.forecast.Model.AbstractFactory.Wunderground.WundergroundFactory;

public class FactoryProduct {

    public static AbstractFactory getFactory (boolean Choose) {
        if (Choose) {
            return new AccuweatherFactory();
        } else {
            return new WundergroundFactory();
        }
    }

}
