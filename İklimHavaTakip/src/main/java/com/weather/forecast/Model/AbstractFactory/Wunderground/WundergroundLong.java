package com.weather.forecast.Model.AbstractFactory.Wunderground;

import com.weather.forecast.Model.AbstractFactory.Services;
import com.weather.forecast.Model.Attribute.LongAtrribute;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

public class WundergroundLong extends LongAtrribute implements Services {

    Wunderground wunderground = new Wunderground();
    // Suanki günün sayısal değerini getirir
    public int getNowDay () {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getDayOfMonth();
    }

    // Yıl için get method
    private int getYear () {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getYear();
    }

    // Suanki ayın sayısal değerini getirir
    private int getNowMonth () {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getMonthValue();
    }

    // Aydaki maximum gün sayısını bulur
    public int getMaxDayOfMonth () {
        YearMonth yearMonth = YearMonth.of(getYear(),getNowMonth());
        return yearMonth.lengthOfMonth();
    }

    @Override
    public void getData() {
        this.Month = String.valueOf(getNowMonth());
        getCountryCode(Country);
        wunderground.setUrl(CountryName,Province,Day);
        wunderground.getLongData(this);
        showData();
    }

    @Override
    public void showData() {
        System.out.println("Wunderground Services");
        System.out.println(Country);
        System.out.println(Province);
        System.out.println(Month);
        System.out.println(Day);
        System.out.println(eventDay);
        System.out.println(highTemperature);
        System.out.println(eventDay);
        System.out.println(lowTemperature);
    }

    @Override
    public void setSearchData(String Country, String Province, String Day) {
        this.Country = Country;
        this.Province = Province;
        this.Day = Day;
    }

    @Override
    public boolean getisHasError() {
        return isHasError;
    }

    @Override
    public void setisHasError(boolean isHasError) {
        this.isHasError = isHasError;
    }

    /*Encapsulations.!!!!! Kalıtım sınıfında protected erişim belirleyicisiyle tanımlanmış değişkenlerin get set metodları
    override edilip front-end te gösterilmek için kullanılıyor
    */

    @Override
    public String getCountryName() {
        return CountryName;
    }

    @Override
    public void setCountryName(String codeCountry) {
        this.CountryName = codeCountry;
    }

    @Override
    public String getCountry() {
        return Country;
    }

    @Override
    public void setCountry(String country) {
        this.Country = Country;
    }

    @Override
    public String getProvince() {
        return Province;
    }

    @Override
    public void setProvince(String province) {
        this.Province = Province;
    }

    @Override
    public String getTemperature() {
        return null;
    }

    @Override
    public void setTemperature(String temperature) {

    }

    @Override
    public String getReelFeel() {
        return null;
    }

    @Override
    public void setReelFeel(String reelFeel) {

    }

    @Override
    public String getHumitiy() {
        return null;
    }

    @Override
    public void setHumitiy(String humitiy) {

    }

    @Override
    public String getPressure() {
        return null;
    }

    @Override
    public void setPressure(String pressure) {

    }

    @Override
    public String getWindys() {
        return null;
    }

    @Override
    public void setWindys(String windys) {

    }

    @Override
    public String getEvent() {
        return null;
    }

    @Override
    public void setEvent(String event) {

    }

    @Override
    public String getMonth() {
        return Month;
    }

    @Override
    public void setMonth(String month) {
        this.Month = month;
    }

    @Override
    public String getEventNight() {
        return eventNight;
    }

    @Override
    public void setEventNight(String eventNight) {
        this.eventNight = eventNight;
    }

    @Override
    public String getEventDay() {
        return eventDay;
    }

    @Override
    public void setEventDay(String eventDay) {
        this.eventDay = eventDay;
    }

    @Override
    public String getHighTemperature() {
        return highTemperature;
    }

    @Override
    public String getLowTemperature() {
        return lowTemperature;
    }

    @Override
    public void setHighTemperature(String highTemperature) {
        this.highTemperature = highTemperature;
    }

    @Override
    public void setLowTemperature(String lowTemperature) {
        this.lowTemperature = lowTemperature;
    }
}
