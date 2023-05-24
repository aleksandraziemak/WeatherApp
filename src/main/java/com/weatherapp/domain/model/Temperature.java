package com.weatherapp.domain.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Temperature {
    private BigDecimal temperature;
    private BigDecimal feelsLike;
}
