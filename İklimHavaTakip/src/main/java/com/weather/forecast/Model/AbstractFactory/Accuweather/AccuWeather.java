package com.weather.forecast.Model.AbstractFactory.Accuweather;

import org.json.JSONArray;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
-----------------Accuweather Değişkenleri-----------------------
apikey --> Accuwether tarafından geliştiriciler için verilen bir uniqe özel anahtar.Verileri alırken gereklidir
locationKey --> Bölgelerin sayısal değerlerini tutan değişken
forecasturl --> Tahminlerin alındığı sayfa
locationKeyUrl --> Tahminler için gerekli olan locationKey'in json verisi halinde bulunduğu url.Burdan locationKey parse edilir
*/

public class AccuWeather{

    private final String apiKey = "nqrj361I6Bmt27YTZtr7euejK2qmsKRQ";
    private String locationKey = null;
    private StringBuffer stringBuffer;
    private String forecastUrl = "https://www.accuweather.com/tr/tr/mersin/"+locationKey+"/current-weather/"+ locationKey;
    private String locationKeyUrl = "http://dataservice.accuweather.com/locations/v1/cities/search.json?q=" +
            "mersin" +"&apikey="+apiKey+"&language=tr&details=false";

    public AccuWeather() {

    }

    // Tahminlerin alınması için zorunlu yapılandırmaları yapar
    public void run (String day,String CountryCode,String Province) {
        getHttpUrl(locationKeyUrl);
        getLocationKey();
        setUrl(locationKey,day,Province,CountryCode);
    }

    // Json ile parse edilecek url yi getirip stringBuffer degiskenine atar
    private void getHttpUrl(String getUrl) {
        try {
            URL url = new URL(getUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            stringBuffer = new StringBuffer();
            while((inputLine = bufferedReader.readLine()) != null) {
                stringBuffer.append(inputLine);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Accuweather servisi tarafından sağlanan bölge için uniqe sayısal değerdir.
    private void getLocationKey() {
        try {
            JSONArray jsonArray = new JSONArray(stringBuffer.toString());
            locationKey = jsonArray.getJSONObject(0).getString("Key");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Mevcut tahmini getiren method
    public void getCurrentlyData(AccuweatherCurrent accuweatherCurrent) {
        try {
            final Document document = org.jsoup.Jsoup.connect(forecastUrl).userAgent("Safari/537.36").timeout(10 * 1000).get();
            Element element = document.select("div.temperatures > p.value").first();
            accuweatherCurrent.setTemperature(element.text());
            element = document.select("div.temperatures > p.realFeel").first();
            accuweatherCurrent.setReelFeel(element.text());
            element = document.select("div.phrase").first();
            accuweatherCurrent.setEvent(element.text());
            element = document.select("div.list > p").get(1);
            accuweatherCurrent.setWindys(element.text());
            element = document.select("div.list > p").get(3);
            accuweatherCurrent.setHumitiy(element.text());
            element = document.select("div.list > p").get(5);
            accuweatherCurrent.setPressure(element.text());
        } catch (Exception e) {
            accuweatherCurrent.setisHasError(true);
            System.out.println(e);
        }
    }

    // Uzun tahmini getiren method
    public void getLongData(AccuweatherLong accuweatherLong) {
        try {
            this.forecastUrl = "https://www.accuweather.com/tr/tr/mersin/"+locationKey+"/daily-weather-forecast/"+ locationKey+ "?day=2";
            System.out.println(forecastUrl);
            final Document document = org.jsoup.Jsoup.connect(forecastUrl).userAgent("Safari/537.36").timeout(10 * 1000).get();
            Element element = document.select("div.panel-1 > div.half-day-card div.accordion-item.accordion-content > div.accordion-item-header-container > div.conditions-card.card.panel > div.temp-icon-wrapper > div.temperatures > p.value").first();
            accuweatherLong.setHighTemperature(element.text());
            element = document.select("div.panel-2 > div.half-day-card div.accordion-item.accordion-content > div.accordion-item-header-container > div.conditions-card.card.panel > div.temp-icon-wrapper > div.temperatures > p.value").first();
            accuweatherLong.setLowTemperature(element.text());
            element = document.select("div.panel-1 > div.half-day-card div.accordion-item.accordion-content > div.accordion-item-header-container > div.conditions-card.card.panel > div.phrase").first();
            accuweatherLong.setEventDay(element.text());
            element = document.select("div.panel-2 > div.half-day-card div.accordion-item.accordion-content > div.accordion-item-header-container > div.conditions-card.card.panel > div.phrase").first();
            accuweatherLong.setEventNight(element.text());
        } catch (Exception e) {
            accuweatherLong.setisHasError(true);
            System.out.println(e);
        }
    }

    public void setLocationKeyUrl (String Province) {
        this.locationKeyUrl = "http://dataservice.accuweather.com/locations/v1/cities/search.json?q=" +
                Province +"&apikey="+apiKey+"&language=tr&details=false";
    }

    // LocationKey alındıktan sonra url'yi tekrar düzenler
    private void setUrl(String locationKey,String day,String Province,String CountryCode) {
        if (day == null) {
            this.forecastUrl = "https://www.accuweather.com/tr/tr/adana/"+locationKey+"/current-weather/"+ locationKey;
        } else {
            this.forecastUrl = "https://www.accuweather.com/"+CountryCode+"/"+CountryCode+"/"+Province+"/"+locationKey+"/daily-weather-forecast/"+ locationKey+ "?day=" + day;
        }
    }
}
