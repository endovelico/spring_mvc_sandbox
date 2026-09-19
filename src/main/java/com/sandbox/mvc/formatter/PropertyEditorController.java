/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandbox.mvc.formatter;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class PropertyEditorController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(
                LocalDate.class,
                new LocalDatePropertyEditor()
        );
    }

    @GetMapping("/property-editor")
    public String propertyEditor(
            @RequestParam LocalDate date) {

        return "Received date: " + date;
    }
}