/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandbox.mvc.conversion_service;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ConversionDemoService {

    private final ConversionService conversionService;

    public ConversionDemoService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public void demonstrate() {

        // Built-in conversion: String -> Integer
        Integer number = conversionService.convert(
                "42",
                Integer.class
        );

        System.out.println(number);
        // 42


        // Custom conversion: String -> UserId
        UserId userId = conversionService.convert(
                "123",
                UserId.class
        );

        System.out.println(userId);
        // UserId[value=123]


        // Formatter: String -> LocalDate
        LocalDate date = conversionService.convert(
                "19/09/2026",
                LocalDate.class
        );

        System.out.println(date);
        // 2026-09-19


        // Formatter: LocalDate -> String
        String formattedDate = conversionService.convert(
                date,
                String.class
        );

        System.out.println(formattedDate);
        // 19/09/2026
    }
}