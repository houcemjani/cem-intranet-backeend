/*
 * Copyright (c) 2017.
 * This software is developed by Advanced Derivative Solutions and 3H Partners.
 * You may not copy this code or reproduce it.
 */

package com.ads.Investigationintranet.domain.trial.dashboard;


public class ColoredMessage {

    private String message;
    private String color;

    public ColoredMessage(String message, String color) {
        this.message = message;
        this.color = color;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
