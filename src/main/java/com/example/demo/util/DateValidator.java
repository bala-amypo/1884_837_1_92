package com.example.demo.util;

import java.time.LocalDateTime;

public class DateValidator {

    public static boolean isPastOrPresent(LocalDateTime dateTime) {

        if (dateTime == null) {
            return false;
        }

        return !dateTime.isAfter(LocalDateTime.now());
    }
}
