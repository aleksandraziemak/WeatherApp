package com.weatherapp.infrastructure.openweather;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenWeatherResponse {
    private List<OpenWeather> weather;
    private OpenWeatherMain main;
    private OpenWeatherWind wind;
    private OpenWeatherSys sys;
    private String name;
}
