package com.weatherapp.infrastructure;

import com.weatherapp.domain.model.Localisation;
import com.weatherapp.domain.model.Sky;
import com.weatherapp.domain.model.Temperature;
import com.weatherapp.domain.model.Weather;
import com.weatherapp.infrastructure.openweather.OpenWeatherResponse;

public class WeatherMapper {
    public static Weather map(OpenWeatherResponse response) {
        Weather weather = new Weather();
        weather.setLocalisation(mapLocalisation(response));
        weather.setTemperature(mapTemperature(response));
        weather.setPressure(response.getMain().getPressure());
        weather.setHumidity(response.getMain().getHumidity());
        weather.setWindSpeed(response.getWind().getSpeed());
        weather.setSky(mapSky(response));
        return weather;
    }

    private static Localisation mapLocalisation(OpenWeatherResponse response) {
        Localisation localisation = new Localisation();
        localisation.setCountry(response.getSys().getCountry());
        localisation.setCity(response.getName());
        return localisation;
    }

    private static Temperature mapTemperature(OpenWeatherResponse response) {
        Temperature temperature = new Temperature();
        temperature.setTemperature(response.getMain().getTemp());
        temperature.setFeelsLike(response.getMain().getFeels_like());
        return temperature;
    }

    private static Sky mapSky(OpenWeatherResponse response) {
        Sky sky = new Sky();
        sky.setSky(response.getWeather().get(0).getMain());
        sky.setDescription(response.getWeather().get(0).getDescription());
        return sky;
    }
}
