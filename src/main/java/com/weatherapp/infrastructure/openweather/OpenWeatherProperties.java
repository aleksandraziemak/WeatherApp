package com.weatherapp.infrastructure.openweather;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("weather")
public class OpenWeatherProperties {
    private String host;
    private String todayForecastPath;
    private String apiKey;
}
