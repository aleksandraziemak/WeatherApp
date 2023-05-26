package com.weatherapp.infrastructure.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenWeatherMain {
    private BigDecimal temp;
    @JsonProperty("feels_like")
    private BigDecimal feelsLike;
    private int pressure;
    private int humidity;
}
