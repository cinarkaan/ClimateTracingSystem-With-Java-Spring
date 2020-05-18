package com.weather.forecast.Model.Attribute;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CurrentlyAttribute {

    //Currently Data
    protected String CountryName;
    protected String Country;
    protected String Province;
    protected String Temperature;
    protected String ReelFeel;
    protected String Humitiy;
    protected String Pressure;
    protected String Windys;
    protected String Event;
    protected boolean isHasError;

    public void getCountryCode(String Country) {

        Map<String, String> countries = new HashMap<String, String>();
        for (String iso : Locale.getISOCountries()) {
            Locale l = new Locale("", iso);
            countries.put(l.getDisplayCountry(), iso);
        }

        this.Country = countries.get(Country).toLowerCase();
        this.CountryName = this.Country;

    }

}
