package com.example.converter.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String validData(String inputData) {
        Pattern pattern = Pattern.compile("\\d+.\\d+");
        Matcher matcher = pattern.matcher(inputData);
        String answer = null;
        if (!matcher.matches()) {
            answer = "Invalid Data!";
        }
        return answer;
    }

    public static String validArrayData(List<String> inputArrayData) {
        Pattern pattern = Pattern.compile("\\d+.\\d+");
        String answer = null;
        for (String element: inputArrayData) {
            Matcher matcher = pattern.matcher(element);
            if (!matcher.matches()) {
                answer = "Invalid Data!";
            }
        }
        return answer;
    }
}
