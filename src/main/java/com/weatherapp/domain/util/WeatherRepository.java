package com.weatherapp.domain.util;

import com.weatherapp.domain.Response;
import com.weatherapp.domain.model.Weather;
import com.weatherapp.infrastructure.openweather.OpenWeatherAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class WeatherRepository {

    private final OpenWeatherAdapter weatherAdapter;

    public Weather getWeather(Response response) {
        return weatherAdapter.getDailyForecast(response);
    }
}
