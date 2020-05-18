package com.weather.forecast.controller.Forecast;

import com.weather.forecast.Model.AbstractFactory.ManageServices;
import com.weather.forecast.Model.AbstractFactory.Wunderground.WundergroundLong;
import com.weather.forecast.Model.DB.Util.GetEarthTempByYear;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RequestMapping("/Search")
@Controller
public class ForecastController {

    // Mevcut tahmin sayfasına yönlendirir.
    @RequestMapping("/Searching")
    public String getForecastCurrent(Model m) {
        ManageServices manageServices = new ManageServices();
        m.addAttribute("Search",manageServices);
        return "ForecastChoose/ForecastCurrent";
    }

    @RequestMapping("/selectForecast")
    public String Forecast() {
        return "ForecastChoose/Forecast";
    }

    @RequestMapping("/AverageTemp")
    public String getAverageTemp () {
        return "Results/AverageTemperature";
    }

    // Uzun tahmin sayfasına yönlendirir.
    @RequestMapping("/LongSearching")
    public String getForecastLong(Model m){
        ManageServices manageServices = new ManageServices();
        m.addAttribute("ForecastLong",manageServices);
        return "ForecastChoose/ForecastLong";
    }

    // Uzun tahminde aydaki mevcut max gün sayısını çeker ve listeler
    @ModelAttribute("dayList")
    public Map<String,String> getDayList () {
        WundergroundLong wundergroundLong = new WundergroundLong();
        Map<String,String> dayList = new HashMap<String, String>();
        int max_day_of_month = wundergroundLong.getMaxDayOfMonth();
        int currently_day = wundergroundLong.getNowDay();
        int totalDays = max_day_of_month - currently_day;
        if (totalDays > 5) {
            totalDays = 5;
        }
        for (int i = 0 ; i <= totalDays ; i++) {
            dayList.put(Integer.toString(currently_day),"Next "+Integer.toString(currently_day) + "th " + "day");
            currently_day++;
        }
        return dayList;
    }

    // Tahmin alınabilercek servisleri getirir.
    @ModelAttribute("services")
    public Map<String,String> getServicesList () {
        HashMap <String,String> servicesList = new HashMap<>();
        servicesList.put("Wunderground","Wunderground");
        servicesList.put("AccuWeather","AccuWeather");
        servicesList.put("Analysis","Analysis");
        return servicesList;
    }

    @ModelAttribute("LongServices")
    public Map<String,String> getLongServices () {
        HashMap <String,String> servicesList = new HashMap<>();
        servicesList.put("Wunderground","Wunderground");
        servicesList.put("AccuWeather","AccuWeather");
        return servicesList;
    }

    // Ulke listesini çeker
    @ModelAttribute("countryList")
    public Map<String,String> getCountryList () {
        String[] locales = Locale.getISOCountries();
        HashMap <String,String> countryList = new HashMap<>();
        for (String countryCode : locales) {
            Locale countryObj = new Locale("",countryCode);
            countryList.put(countryObj.getDisplayCountry(),countryObj.getDisplayCountry());
        }
        return countryList;
    }

    // Uzun tahminin sonucu göstermek için ilgili sayfaya yönlendirir.
    @RequestMapping("/forecastResultLong")
    public String LongResult(@ModelAttribute("ForecastLong") ManageServices manageServices){
        manageServices.selectServices();
        manageServices.getLong();
        if (!manageServices.getService().getisHasError()) {
            return "Results/ForecastResultLong";
        } else {
            return "Error";
        }
    }

    // Mevcut tahminin sonucu göstermek için ilgili sayfaya yönlendirir.
    @RequestMapping("/forecastResult")
    public String CurrentlyResult(@ModelAttribute("Search") ManageServices manageServices) {
        manageServices.selectServices();
        if (manageServices.getServices().equalsIgnoreCase("Analysis")) {
            manageServices.getAnalysis();
            if (!manageServices.getService().getisHasError()) {
                return "Results/ForecastAnalysis";
            } else {
                return  "Error";
            }
        } else {
            manageServices.getCurrent();
            if (!manageServices.getService().getisHasError()) {
                return "Results/ForecastResultCurrently";
            } else {
                return "Error";
            }
        }
    }
}