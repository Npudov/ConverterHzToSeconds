package com.example.converter.controller;

import com.example.converter.service.ConverterService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConverterController {


    @GetMapping("/HzToTime")
    public String hzToTimeConvert(@RequestParam("Frequency") String hzData, HttpServletResponse response) {
        return ConverterService.processingConvertHzToTime(hzData, response);
    }

    @GetMapping("/TimeToHz")
    public String timeToHzConvert(@RequestParam("time") String timeData, HttpServletResponse response) {
        return ConverterService.processingConvertTimeToHz(timeData, response);
    }

    @GetMapping("/HzToTimeArray")
    public List<String> hzToTimeConvertArray(@RequestParam(value="direction", required = false) String dir,
                                             @RequestBody List<String> hzArray, HttpServletResponse response) {
        return ConverterService.processingConvertHzToTimeArray(hzArray, dir, response);
    }

    @GetMapping("/TimeToHzArray")
    public List<String> timeToHzConvertArray(@RequestParam(value="direction", required = false) String dir,
                                             @RequestBody List<String> timeArray, HttpServletResponse response) {
        return ConverterService.processingConvertTimeToHzArray(timeArray, dir, response);
    }
}
