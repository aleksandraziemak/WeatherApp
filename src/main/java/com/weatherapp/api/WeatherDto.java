package com.weatherapp.api;

import com.weatherapp.domain.model.Localisation;
import com.weatherapp.domain.model.Sky;
import com.weatherapp.domain.model.Temperature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto {
    private LocalisationDto localisation;
    private TemperatureDto temperature;
    private int pressure;
    private int humidity;
    private float windSpeed;
    private SkyDto sky;
}
