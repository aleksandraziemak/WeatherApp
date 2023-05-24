package com.weatherapp.api;

import com.weatherapp.domain.Response;
import com.weatherapp.domain.util.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/todayForecast")
    ResponseEntity<WeatherDto> getDailyForecast(@RequestBody Response response) {
        return ResponseEntity.ok(WeatherMapperDto.map(weatherService.getWeather(response)));
    }
}
