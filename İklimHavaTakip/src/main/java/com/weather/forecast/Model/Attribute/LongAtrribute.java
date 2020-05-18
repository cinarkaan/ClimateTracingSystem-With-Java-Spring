package com.weather.forecast.Model.Attribute;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LongAtrribute {

    protected String highTemperature;
    protected String lowTemperature;
    protected String eventDay;
    protected String eventNight;
    protected String CountryName;
    protected String Country;
    protected String Province;
    protected String Month;
    protected String Day;
    protected boolean isHasError;

    public void getCountryCode(String Country) {

        Map<String, String> countries = new HashMap<String, String>();
        for (String iso : Locale.getISOCountries()) {
            Locale l = new Locale("", iso);
            countries.put(l.getDisplayCountry(), iso);
        }

        this.Country = (countries.get(Country).toLowerCase());
        this.CountryName = this.Country;
    }

}
