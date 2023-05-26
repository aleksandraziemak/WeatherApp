package com.weatherapp.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherQuery {
    private String city;
    private TemperatureUnits units;

    private WeatherQuery(String city, TemperatureUnits unit) {
        this.city = city;
        this.units = unit;
    }

    public static WeatherQuery of(String city, TemperatureUnits units) {
        return new WeatherQuery(city, units);
    }
}
