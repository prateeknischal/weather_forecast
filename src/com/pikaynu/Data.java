package com.pikaynu;

import org.json.JSONObject;
import java.util.Date;

/**
 * Created by Prateek on 5/8/2016.
 */
class Data {
    private String str;
    /*
        Data points available in api call
     */
    private double _latitude;
    private double _longitude;
    private String _timezone;
    private double _offsetGMT;
    private long _time;
    private String _summary;
    private String _icon;
    private double _precipitationIntensity;
    private double _precipitationProbability;
    private String _precipitationType;
    private double _temperature;
    private double _apparentTemperature;
    private double _dewPoint;
    private double _humidity;
    private double _windSpeed;
    private double _windBearing;
    private double _cloudCover;
    private double _pressure;
    private double _ozone;

    public Data(String str){
        // JSON response of the API
        this.str = str;
    }

    static final int SUCCESS = 0;
    static final int ERROR = 1;
    public int parseJSON(){
        try {
            JSONObject obj = new JSONObject(str);
            /*
                Meta data
            */
            _latitude = obj.getDouble("latitude");
            _longitude = obj.getDouble("longitude");
            _timezone = obj.getString("timezone");
            _offsetGMT = obj.getDouble("offset");

            /*
                Weather information
            */
            JSONObject wi = obj.getJSONObject("currently");
            _time = wi.getLong("time");
            _summary = wi.getString("summary");
            _icon = wi.getString("icon");
            _precipitationIntensity = wi.getDouble("precipIntensity");
            _precipitationProbability = wi.getDouble("precipProbability");
            _precipitationType = wi.getString("precipType");
            _temperature = wi.getDouble("temperature");
            _apparentTemperature = wi.getDouble("apparentTemperature");
            _dewPoint = wi.getDouble("dewPoint");
            _humidity = wi.getDouble("humidity");
            _windSpeed = wi.getDouble("windSpeed");
            _windBearing = wi.getDouble("windBearing");
            _cloudCover = wi.getDouble("cloudCover");
            _pressure = wi.getDouble("pressure");
            _ozone = wi.getDouble("ozone");
            return SUCCESS;
        } catch (Exception e){
            System.out.println("Unable to parse JSON");
            e.printStackTrace();
        }
        return ERROR;
    }

    public double FtoC(double t){
        double tmp = (t - 32.0) * 5.0 / 9.0;
        tmp = tmp * 10;
        tmp = (double)Math.round(tmp) / 10.0;
        return tmp;
    }

    public void prettyPrint(){
        System.out.println("=============================================================");
        System.out.println("\t\t\t WEATHER REPORT");
        System.out.println("Location    : " + _latitude + " N ," + _longitude + " E");
        System.out.println("Time Zone   : " + _timezone);
        System.out.println("Time        : " + new Date(_time * 1000L));
        System.out.println("Summary     : " + _summary);
        System.out.println("Temperature : " + FtoC(_temperature) + " C");
        System.out.println("Real Feel   : " + FtoC(_apparentTemperature) + " C");
        System.out.println("Humidity    : " + _humidity);
        System.out.println("pressure    : " + _pressure);
        System.out.println("pressure    : " + _windSpeed + " @ Bearing " + _windBearing);
        System.out.println("=============================================================");
    }

    /*
    getters for all data points
     */

    public double get_latitude() {
        return _latitude;
    }

    public double get_longitude() {
        return _longitude;
    }

    public String get_timezone() {
        return _timezone;
    }

    public double get_offsetGMT() {
        return _offsetGMT;
    }

    public long get_time() {
        return _time;
    }

    public String get_summary() {
        return _summary;
    }

    public String get_icon() {
        return _icon;
    }

    public double get_precipitationIntensity() {
        return _precipitationIntensity;
    }

    public double get_precipitationProbability() {
        return _precipitationProbability;
    }

    public String get_precipitationType() {
        return _precipitationType;
    }

    public double get_temperature() {
        return _temperature;
    }

    public double get_apparentTemperature() {
        return _apparentTemperature;
    }

    public double get_dewPoint() {
        return _dewPoint;
    }

    public double get_humidity() {
        return _humidity;
    }

    public double get_windspeed() {
        return _windSpeed;
    }

    public double get_windBearing() {
        return _windBearing;
    }

    public double get_cloudCover() {
        return _cloudCover;
    }

    public double get_pressure() {
        return _pressure;
    }

    public double get_ozone() {
        return _ozone;
    }
}

