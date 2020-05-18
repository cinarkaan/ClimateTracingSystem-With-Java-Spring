package com.weather.forecast.Model.AbstractFactory;

public abstract class AbstractFactory {

    protected abstract Services getServices(String ServiceName);

}
