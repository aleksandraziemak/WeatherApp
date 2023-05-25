package com.weatherapp.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherQueryDto {
    private String city;
    private TemperatureUnitsDto units;
}
