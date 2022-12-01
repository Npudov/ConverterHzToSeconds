package com.example.converter.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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

    public static List<String> sortArray(List<String> inputArrayData, String param) {
        List<Double> sortingArray = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        for (String elem: inputArrayData) {
            sortingArray.add(Double.parseDouble(elem));
        }
        if (param.equalsIgnoreCase("ASC")) {
            Collections.sort(sortingArray);
        }
        else if (param.equalsIgnoreCase("DESC")) {
            sortingArray.sort(Collections.reverseOrder());
        }
        sortingArray.forEach(elem -> answer.add(String.valueOf(elem)));
        return answer;
    }

    public static List<String> processingConvertHzToTimeArray(List<String> inputArrayData, HttpServletResponse response) {
        String validData = validArrayData(inputArrayData);
        List<String> answer = new ArrayList<>();
        if (validData == null) {
            inputArrayData.forEach(elem -> answer.add(convertToTime(elem)));
        }
        else {
            response.setStatus(400);
            answer.add(validData);
        }
        return answer;
    }

    public static List<String> processingConvertHzToTimeArray(List<String> inputArrayData, String param, HttpServletResponse response) {
        String validData = validArrayData(inputArrayData);
        List<String> answer = new ArrayList<>();
        if (validData == null) {
            inputArrayData.forEach(elem -> answer.add(convertToTime(elem)));
        }
        else {
            response.setStatus(400);
            answer.add(validData);
        }
        return sortArray(answer, param);
    }

    public static List<String> processingConvertTimeToHzArray(List<String> inputArrayData, HttpServletResponse response) {
        String validData = validArrayData(inputArrayData);
        List<String> answer = new ArrayList<>();
        if (validData == null) {
            inputArrayData.forEach(elem -> answer.add(convertToHz(elem)));
        }
        else {
            response.setStatus(400);
            answer.add(validData);
        }
        return answer;
    }

    public static List<String> processingConvertTimeToHzArray(List<String> inputArrayData, String param, HttpServletResponse response) {
        String validData = validArrayData(inputArrayData);
        List<String> answer = new ArrayList<>();
        if (validData == null) {
            inputArrayData.forEach(elem -> answer.add(convertToHz(elem)));
        }
        else {
            response.setStatus(400);
            answer.add(validData);
        }
        return sortArray(answer, param);
    }

    public static String processingConvertHzToTime(String inputData, HttpServletResponse response) {
        String validData = validData(inputData);
        String answer;
        if (validData == null) {
            answer = convertToTime(inputData);
        }
        else {
            response.setStatus(400);
            answer = validData;
        }
        return answer;
    }

    public static String processingConvertTimeToHz(String inputData, HttpServletResponse response) {
        String validData = validData(inputData);
        String answer;
        if (validData == null) {
            answer = convertToHz(inputData);
        }
        else {
            response.setStatus(400);
            answer = validData;
        }
        return answer;
    }
}
