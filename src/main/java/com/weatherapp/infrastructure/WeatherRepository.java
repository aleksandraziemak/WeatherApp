package com.weatherapp.infrastructure;

import com.weatherapp.domain.model.Weather;
import com.weatherapp.domain.model.WeatherQuery;
import com.weatherapp.infrastructure.openweather.OpenWeatherAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class WeatherRepository {

    private final OpenWeatherAdapter weatherAdapter;

    public Weather getWeather(WeatherQuery query) {
        return weatherAdapter.getCurrentForecast(query);
    }
}
