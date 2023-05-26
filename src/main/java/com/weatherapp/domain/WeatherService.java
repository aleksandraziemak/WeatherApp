package com.weatherapp.domain;

import com.weatherapp.domain.model.Weather;
import com.weatherapp.domain.model.WeatherQuery;
import com.weatherapp.infrastructure.WeatherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public Weather getWeather(WeatherQuery query) {
        return weatherRepository.getWeather(query);
    }
}
