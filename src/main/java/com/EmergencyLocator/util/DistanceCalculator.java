package com.EmergencyLocator.util;


public class DistanceCalculator {

    private static final int EARTH_RADIUS_KM = 6371;

    public static double calculate(double userLat, double userLong, double hospitalLat, double hospitalLong){
        double latDistance = Math.toRadians(hospitalLat - userLat);
        double lonDistance = Math.toRadians(hospitalLong - userLong);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(userLat))
                * Math.cos(Math.toRadians(hospitalLat))
                * Math.sin(lonDistance / 2)
                * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return EARTH_RADIUS_KM * c;
    }
}
