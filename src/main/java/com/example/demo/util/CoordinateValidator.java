package com.example.demo.util;

public class CoordinateValidator {

    public static boolean isValid(Double latitude, Double longitude) {

        if (latitude == null || longitude == null) {
            return false;
        }

        return latitude >= -90 && latitude <= 90
            && longitude >= -180 && longitude <= 180;
    }
}
