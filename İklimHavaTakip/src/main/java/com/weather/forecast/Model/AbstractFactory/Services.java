package com.weather.forecast.Model.AbstractFactory;

public interface Services {

    public void getData();
    public void showData();
    public void setSearchData (String Country,String Province,String Day);

    public boolean getisHasError ();
    public void setisHasError (boolean isHasError);

    //Current Encapsulations
    public String getCountryName();
    public void setCountryName(String codeCountry);
    public String getCountry();
    public void setCountry(String country);
    public String getProvince();
    public void setProvince(String province);
    public String getTemperature();
    public void setTemperature(String temperature);
    public String getReelFeel();
    public void setReelFeel(String reelFeel);
    public String getHumitiy();
    public void setHumitiy(String humitiy);
    public String getPressure();
    public void setPressure(String pressure);
    public String getWindys();
    public void setWindys(String windys);
    public String getEvent();
    public void setEvent(String event);

    //Long Encapsulations

    public String getMonth();
    public void setMonth(String month);
    public String getEventNight();
    public void setEventNight(String eventNight);
    public String getEventDay();
    public void setEventDay(String eventDay);
    public String getHighTemperature ();
    public String getLowTemperature ();
    public void setHighTemperature(String highTemperature);
    public void setLowTemperature(String lowTemperature);

}
