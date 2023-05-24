package com.weatherapp.infrastructure.openweather;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenWeatherMain {
    private BigDecimal temp;
    private BigDecimal feels_like;
    private int pressure;
    private int humidity;
}
