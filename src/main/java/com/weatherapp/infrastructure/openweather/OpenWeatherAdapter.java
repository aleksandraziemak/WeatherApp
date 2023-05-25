package com.weatherapp.infrastructure.openweather;

import com.weatherapp.domain.model.TemperatureUnits;
import com.weatherapp.domain.model.Weather;
import com.weatherapp.domain.model.WeatherQuery;
import java.util.Map;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
@EnableConfigurationProperties(OpenWeatherProperties.class)
public class OpenWeatherAdapter {
    private final RestTemplate restTemplate;
    private final OpenWeatherProperties openWeatherProperties;
    private static final Map<TemperatureUnits, String> MAP = Map.of(
        TemperatureUnits.KELVIN, "standard",
        TemperatureUnits.CELSIUS, "metric",
        TemperatureUnits.FAHRENHEIT, "imperial"
    );

    public Weather getCurrentForecast(WeatherQuery query) {
        return Optional.ofNullable(restTemplate.getForObject(
                openWeatherProperties.getHost() + openWeatherProperties.getTodayForecastPath(),
                OpenWeatherResponse.class,
                query.getCity(), openWeatherProperties.getApiKey(), MAP.get(query.getUnits())
            ))
            .map(WeatherMapper::map)
            .orElseThrow(() -> new IllegalStateException("Open Weather not responding"));
    }

    //    public List<Weather> getDailyForecast() {
    //        return Optional.ofNullable(restTemplate.getForObject(openWeatherProperties.getHost() + openWeatherProperties.getCurrencyPath()
    //                    + openWeatherProperties.getApiKey() + "&units=metric",
    //                OpenWeatherResponse.class, "Warsaw"))
    //            .map(this::map)
    //            .stream().toList();
    //    }
}
