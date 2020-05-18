package com.weather.forecast.Model.AbstractFactory;

public class ManageServices {

    private Services services;
    AbstractFactory servicesFactory,servicesFactoryAnalysis;
    private String Services;
    private String Country;
    private String Province;
    private String Day;
    private String event1,event2;

    public String getEvent1() {
        return event1;
    }

    public void setEvent1(String event1) {
        this.event1 = event1;
    }

    public String getEvent2() {
        return event2;
    }

    public void setEvent2(String event2) {
        this.event2 = event2;
    }

    public Services getService () {
        return services;
    }

    public String getServices() {
        return Services;
    }

    public void setServices(String services) {
        Services = services;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    // Seçilen servise göre sınıflari yaratir
    public void selectServices () {
        if (Services.equalsIgnoreCase("AccuWeather")) {
            servicesFactory = FactoryProduct.getFactory(true);
        } else if (Services.equalsIgnoreCase("Wunderground")) {
            servicesFactory = FactoryProduct.getFactory(false);
        } else {
            servicesFactory = FactoryProduct.getFactory(true);
            servicesFactoryAnalysis = FactoryProduct.getFactory(false);
        }
    }

    // Current tahminleri göster
    public void getCurrent() {
        services = servicesFactory.getServices("Current");
        services.setSearchData(Country,Province,Day);
        services.getData();
    }

    // Long Tahminleri göster
    public void getLong () {
        services = servicesFactory.getServices("Long");
        services.setSearchData(Country,Province,Day);
        services.getData();
    }

    // Her iki servisin verilerini analiz eder
    public void getAnalysis() {
        float temprature,realfeel;
        String temp;
        services = servicesFactory.getServices("Current");
        services.setSearchData(Country,Province,Day);
        services.getData();
        if (services.getTemperature().length() == 3) {
            temprature = Float.parseFloat(services.getTemperature().substring(0,2));
        } else {
            temprature = Float.parseFloat(services.getTemperature().substring(0,1));
        }
        if (services.getReelFeel().length() == 3) {
            realfeel = Float.parseFloat(services.getReelFeel().substring(10,12));
        } else {
            realfeel = Float.parseFloat(services.getReelFeel().substring(9,11));
        }

        event1 = services.getEvent();
        services = servicesFactoryAnalysis.getServices("Current");
        services.setSearchData(Country,Province,Day);
        services.getData();
        temprature = (temprature + Float.parseFloat(services.getTemperature())) / 2;
        realfeel = (realfeel + Float.parseFloat(services.getReelFeel())) / 2 ;
        event2 = services.getEvent();
        services.setTemperature(String.valueOf(temprature));
        services.setReelFeel(String.valueOf(realfeel));
        System.out.println("Ortalama sicaklik  : " + temprature);
        System.out.println("Ortalama hissedilen sicaklik  : " + realfeel);
        System.out.println("Ortalama olay1Servis1  : " + event1);
        System.out.println("Ortalama olay2Servis2  : " + event2);
    }
}
