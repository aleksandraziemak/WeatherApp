package com.weatherapp.infrastructure.openweather;

import com.weatherapp.domain.model.Localisation;
import com.weatherapp.domain.model.Sky;
import com.weatherapp.domain.model.Temperature;
import com.weatherapp.domain.model.Weather;

class WeatherMapper {
    public static Weather map(OpenWeatherResponse response) {
        return Weather.builder()
            .localisation(mapLocalisation(response))
            .temperature(mapTemperature(response.getMain()))
            .pressure(response.getMain().getPressure())
            .humidity(response.getMain().getHumidity())
            .windSpeed(response.getWind().getSpeed())
            .sky(mapSky(response.getWeather().get(0)))
            .build();
    }

    private static Localisation mapLocalisation(OpenWeatherResponse response) {
        return Localisation.of(response.getSys().getCountry(), response.getName());
    }

    private static Temperature mapTemperature(OpenWeatherMain openWeatherMain) {
        return Temperature.of(openWeatherMain.getTemp(), openWeatherMain.getFeelsLike());
    }

    private static Sky mapSky(OpenWeather openWeather) {
        return Sky.of(openWeather.getMain(), openWeather.getDescription());
    }
}
