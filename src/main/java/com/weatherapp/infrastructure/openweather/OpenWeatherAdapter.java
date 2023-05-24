package com.weatherapp.infrastructure.openweather;

import com.weatherapp.domain.Response;
import com.weatherapp.domain.Units;
import com.weatherapp.domain.model.Weather;
import com.weatherapp.infrastructure.WeatherMapper;
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
    private static final Map<Units, String> MAP = Map.of(
        Units.K, "",
        Units.C, "&units=metric",
        Units.F, "&units=imperial"
    );

    public Weather getDailyForecast(Response response) {
        return Optional.ofNullable(restTemplate.getForObject(openWeatherProperties.getHost()
                    + openWeatherProperties.getTodayForecastPath()
                    + openWeatherProperties.getApiKey() + MAP.get(response.getUnits()),
                OpenWeatherResponse.class, response.getCity()))
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
