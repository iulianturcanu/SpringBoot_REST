package com.iudtu.lunchbox.dto;

public enum ItemType {
    FRUIT("fruit"),
    VEGETABLE("vegetable"),
    HOME_COOKED("home_cooked"),
    YOGURT("yogurt"),
    COOKIE("cookie"),
    SNACK("snack");

    private final String name;

    private ItemType(String name){
        this.name = name;
    }
}
