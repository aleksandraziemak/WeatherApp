package com.weatherapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private Localisation localisation;
    private Temperature temperature;
    private int pressure;
    private int humidity;
    private float windSpeed;
    private Sky sky;
}
