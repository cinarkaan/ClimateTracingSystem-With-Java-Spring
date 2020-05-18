package com.weather.forecast.Model.AbstractFactory.Wunderground;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Wunderground{

    private String url;

    public Wunderground() {

    }

    // Fahrenait olarak getirilen veriyi celcious yapar
    public String getCelcious(String fahrenait) {
        int Celcious = ((Integer.parseInt(fahrenait) - 35) * 5) / 9;
        return Integer.toString(Celcious);
    }

    // Anlık hava durumu bilgilerini alan method
    public void getCurrentlyData(WundergroundCurrent wundergroundCurrent) {
        if (wundergroundCurrent.getProvince() == null) {
            wundergroundCurrent.setCountry(null);
            wundergroundCurrent.setProvince(null);
        } else if (wundergroundCurrent.getProvince() != null) {
            try {
                final Document document = org.jsoup.Jsoup.connect(url).userAgent("Safari/537.36").timeout(10 * 1000).get();
                Element element = document.select("span.wu-unit-temperature > span.wu-value").first();
                wundergroundCurrent.setTemperature(getCelcious(element.text()));
                element = document.select("div.feels-like > span.temp").first();
                wundergroundCurrent.setReelFeel(getCelcious(element.text().substring(0, 2)));
                element = document.select("div.condition-icon > p").first();
                wundergroundCurrent.setEvent(element.text());
                element = document.select("span.test-false > span").first();
                wundergroundCurrent.setWindys(element.text());
                element = document.select("span.wu-unit-pressure > span").first();
                wundergroundCurrent.setPressure(element.text() + " inhg");
                element = document.select("span.wu-unit-humidity > span").first();
                wundergroundCurrent.setHumitiy("%" + element.text());
            } catch (Exception ex) {
                wundergroundCurrent.setisHasError(true);
                ex.printStackTrace();
            }
        }
    }

    // Uzun tahmin bilgilerini alan method
    public void getLongData(WundergroundLong wundergroundLong) {
            try {
                final Document document = org.jsoup.Jsoup.connect(url).get();
                //Day Data
                Element elementDay = document.select("div#day-summary.small-12 > div.row.collapse").first();
                String allDataDay = elementDay.select("p").first().text(); // All data day
                String[] dataDay = allDataDay.split("\\.");
                wundergroundLong.setEventDay(dataDay[0]);
                wundergroundLong.setHighTemperature(dataDay[1]);
                //Night Data
                Element elementNight = document.select("div#night-summary.small-12 > div.row.collapse").first();
                String allDataNight = elementNight.select("p").first().text(); // All data night
                String[] dataNight = allDataNight.split("\\.");
                wundergroundLong.setEventNight(dataNight[0]);
                wundergroundLong.setLowTemperature(dataNight[1]);
            } catch (Exception e) {
                wundergroundLong.setisHasError(true);
                System.out.println(e);
            }
    }

    // Url için set method
    public void setUrl(String country,String province,String day) {
        if (day == null) {
            this.url = "https://www.wunderground.com/weather/" + country + "/" + province;
        } else {
            this.url = "https://www.wunderground.com/hourly/" +country + "/" + province+ "/" + "date" + "/" + "2020" + "-" + getMonth() + "-" + day;
            System.out.println(this.url);
        }
    }

    // Sayı olarak ay bilgisini getiren method
    public int getMonth() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getMonthValue();
    }


}