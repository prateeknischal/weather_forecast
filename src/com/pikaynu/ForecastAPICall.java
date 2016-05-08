package com.pikaynu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Prateek on 5/8/2016.
 */
class ForecastAPICall {
    private final String API_KEY = "YOUR API KEY";
    private double _latitute;
    private double _longitude;


    public ForecastAPICall(double latitute, double longitude){
        _latitute = latitute;
        _longitude = longitude;
    }
    public URL getURL(){
        URL url;
        String _url = "https://api.forecast.io/forecast/";
        String tmp = _url + API_KEY + "/" + String.valueOf(_latitute) + "," + String.valueOf(_longitude);
        tmp = tmp + "?exclude=minutely,hourly,daily,alerts,flags";
        try{
            url = new URL(tmp);
            return url;
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return null;
    }
    public String getAPIResponse(){
        URL url = getURL();
        if (url == null) {
            System.out.println("Unable to retrieve URL ");
            return null;
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String response = br.readLine();
            br.close();
            return response;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}