package com.pikaynu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the coordinates : ");
        double lat = Double.parseDouble(br.readLine());
        double lon = Double.parseDouble(br.readLine());

        if (lat < -90.0 || lat > 90.0 || lon < 0.0 || lon > 360.0) {
            System.out.println("Invalid Coordinates");
            return;
        }
        ForecastAPICall fac = new ForecastAPICall(lat, lon);
        String apiResponse = fac.getAPIResponse();
        if (apiResponse != null) {
            Data d = new Data(apiResponse);
            int status = d.parseJSON();
            if (status == 0) d.prettyPrint();
        }
    }
}
