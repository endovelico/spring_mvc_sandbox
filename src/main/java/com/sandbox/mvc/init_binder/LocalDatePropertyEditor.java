/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sandbox.mvc.init_binder;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDatePropertyEditor
        extends PropertyEditorSupport {

    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void setAsText(String text) {

        LocalDate date =
                LocalDate.parse(text, formatter);

        setValue(date);
    }

    @Override
    public String getAsText() {

        LocalDate date =
                (LocalDate) getValue();

        if (date == null) {
            return "";
        }

        return date.format(formatter);
    }
}