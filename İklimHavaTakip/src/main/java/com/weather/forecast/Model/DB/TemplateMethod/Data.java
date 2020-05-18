package com.weather.forecast.Model.DB.TemplateMethod;

public abstract class Data {

    abstract void Initialize ();
    abstract void prepareData ();
    abstract void Finish ();

    public void run() {
        Initialize();
        prepareData();
        Finish();
    }

}
