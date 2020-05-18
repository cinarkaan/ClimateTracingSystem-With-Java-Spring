package com.weather.forecast.Model.AbstractFactory.Accuweather;

import com.weather.forecast.Model.AbstractFactory.Services;
import com.weather.forecast.Model.Attribute.CurrentlyAttribute;

public class AccuweatherCurrent extends CurrentlyAttribute implements Services {

    AccuWeather accuWeather = new AccuWeather();

    @Override
    public void getData() {
        getCountryCode(Country);
        accuWeather.setLocationKeyUrl(Province);
        accuWeather.run(null,Country,Province);
        accuWeather.getCurrentlyData(this);
        showData();
    }

    @Override
    public void showData() {
        System.out.println("Accuweather Services");
        System.out.println(CountryName);
        System.out.println(Province);
        System.out.println(Temperature);
        System.out.println(ReelFeel);
        System.out.println(Event);
        System.out.println(Windys);
        System.out.println(Humitiy);
        System.out.println(Pressure);
    }

    @Override
    public void setSearchData(String Country, String Province, String Day) {
        this.Country = Country;
        this.Province = Province;
    }

    @Override
    public boolean getisHasError() {
        return this.isHasError;
    }

    @Override
    public void setisHasError(boolean isHasError) {
        this.isHasError = isHasError;
    }

    /* Encapsulations.!!!!! Kalıtım sınıfında protected erişim belirleyicisiyle tanımlanmış değişkenlerin get set metodları
    override edilip front-end te gösterilmek için kullanılıyor
    */

    @Override
    public String getCountryName() {
        return CountryName;
    }

    @Override
    public void setCountryName(String codeCountry) {
        CountryName = codeCountry;
    }

    @Override
    public String getCountry() {
        return Country;
    }

    @Override
    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String getProvince() {
        return Province;
    }

    @Override
    public void setProvince(String province) {
        Province = province;
    }

    @Override
    public String getTemperature() {
        return Temperature;
    }

    @Override
    public void setTemperature(String temperature) {
        Temperature = temperature;
    }

    @Override
    public String getReelFeel() {
        return ReelFeel;
    }

    @Override
    public void setReelFeel(String reelFeel) {
        ReelFeel = reelFeel;
    }

    @Override
    public String getHumitiy() {
        return Humitiy;
    }

    @Override
    public void setHumitiy(String humitiy) {
        Humitiy = humitiy;
    }

    @Override
    public String getPressure() {
        return Pressure;
    }

    @Override
    public void setPressure(String pressure) {
        Pressure = pressure;
    }

    @Override
    public String getWindys() {
        return Windys;
    }

    @Override
    public void setWindys(String windys) {
        Windys = windys;
    }

    @Override
    public String getEvent() {
        return Event;
    }

    @Override
    public void setEvent(String event) {
        Event = event;
    }

    @Override
    public String getMonth() {
        return null;
    }

    @Override
    public void setMonth(String month) {

    }

    @Override
    public String getEventNight() {
        return null;
    }

    @Override
    public void setEventNight(String eventNight) {

    }

    @Override
    public String getEventDay() {
        return null;
    }

    @Override
    public void setEventDay(String eventDay) {

    }

    @Override
    public String getHighTemperature() {
        return null;
    }

    @Override
    public String getLowTemperature() {
        return null;
    }

    @Override
    public void setHighTemperature(String highTemperature) {

    }

    @Override
    public void setLowTemperature(String lowTemperature) {

    }

}
