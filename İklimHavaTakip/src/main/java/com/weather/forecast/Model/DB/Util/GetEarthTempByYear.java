package com.weather.forecast.Model.DB.Util;

import com.weather.forecast.Model.DB.Entity.TemperatureAverage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class GetEarthTempByYear {

    private String url = "https://data.giss.nasa.gov/gistemp/graphs/graph_data/Global_Mean_Estimates_based_on_Land_and_Ocean_Data/graph.txt";
    private String averageTempList;

    public void getDataFromUrl () {
        try {
            URL url = new URL(this.url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer stringBuffer = new StringBuffer();
            while((inputLine = bufferedReader.readLine()) != null) {
                stringBuffer.append(inputLine);
            }
            bufferedReader.close();
            averageTempList = stringBuffer.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<TemperatureAverage> TurnListFromUrl () {
        String subString = averageTempList.substring(129);
        ArrayList<TemperatureAverage> temperatureAveragesList = new ArrayList<>();
        int subCharacter = 129;
        int year = 1880;
        try {
            while (subString.length() != 0) {
                TemperatureAverage temperatureAverage = new TemperatureAverage();
                temperatureAverage.setYear(year);
                temperatureAverage.setAverageTemperature(Float.parseFloat(subString.substring(0,5)));
                if (subString.length() == 15) {
                    subString = "";
                } else{
                    subCharacter = subCharacter + 24;
                    subString = averageTempList.substring(subCharacter);
                }
                ++year;
                temperatureAveragesList.add(temperatureAverage);
            }
            return temperatureAveragesList;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
