package com.weatherapp.domain.util;

import com.weatherapp.domain.Response;
import com.weatherapp.domain.model.Weather;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public Weather getWeather(Response response) {
        return weatherRepository.getWeather(response);
    }
}
