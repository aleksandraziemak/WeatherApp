package com.weatherapp.api;

import com.weatherapp.domain.WeatherService;
import com.weatherapp.domain.model.WeatherQuery;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/currentForecast")
    ResponseEntity<WeatherDto> getDCurrentForecast(@RequestBody WeatherQueryDto queryDto) {
        WeatherQuery query = WeatherMapper.map(queryDto);
        return ResponseEntity.ok(WeatherMapper.map(weatherService.getWeather(query)));
    }
}