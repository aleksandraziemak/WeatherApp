package com.weatherapp.api;

import com.weatherapp.domain.model.Weather;

public class WeatherMapperDto {

    public static WeatherDto map(Weather weather) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setLocalisation(mapLocalisationDto(weather));
        weatherDto.setTemperature(mapTemperatureDto(weather));
        weatherDto.setPressure(weather.getPressure());
        weatherDto.setHumidity(weather.getHumidity());
        weatherDto.setWindSpeed(weather.getWindSpeed());
        weatherDto.setSky(mapSkyDto(weather));
        return weatherDto;
    }

    private static LocalisationDto mapLocalisationDto(Weather weather) {
        LocalisationDto localisationDto = new LocalisationDto();
        localisationDto.setCountry(weather.getLocalisation().getCountry());
        localisationDto.setCity(weather.getLocalisation().getCity());
        return localisationDto;
    }

    private static TemperatureDto mapTemperatureDto(Weather weather) {
        TemperatureDto temperatureDto = new TemperatureDto();
        temperatureDto.setTemperature(weather.getTemperature().getTemperature());
        temperatureDto.setFeelsLike(weather.getTemperature().getFeelsLike());
        return temperatureDto;
    }

    private static SkyDto mapSkyDto(Weather weather) {
        SkyDto skyDto = new SkyDto();
        skyDto.setSky(weather.getSky().getSky());
        skyDto.setDescription(weather.getSky().getDescription());
        return skyDto;
    }
}
