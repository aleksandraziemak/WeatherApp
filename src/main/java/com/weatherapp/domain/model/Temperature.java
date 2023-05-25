package com.weatherapp.domain.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Temperature {
    private BigDecimal temperature;
    private BigDecimal feelsLike;

    private Temperature(BigDecimal temperature, BigDecimal feelsLike) {
        this.temperature = temperature;
        this.feelsLike = feelsLike;
    }

    public static Temperature of(BigDecimal temperature, BigDecimal feelsLike) {
        return new Temperature(temperature, feelsLike);
    }
}
