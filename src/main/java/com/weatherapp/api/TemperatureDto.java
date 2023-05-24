package com.weatherapp.api;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureDto {
    private BigDecimal temperature;
    private BigDecimal feelsLike;
}
