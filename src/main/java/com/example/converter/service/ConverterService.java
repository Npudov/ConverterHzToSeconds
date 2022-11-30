package com.example.converter.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    public static String convertToTime(String hzData) {
        if (Double.parseDouble(hzData) == 0) {
            return null;
        }
        return String.valueOf(1 / Double.parseDouble(hzData));
    }

    public static String convertToHz(String timeData) {
        if (Double.parseDouble(timeData) == 0) {
            return null;
        }
        return String.valueOf(1 / Double.parseDouble(timeData));
    }
}
