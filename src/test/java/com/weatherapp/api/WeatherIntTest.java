package com.weatherapp.api;

import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.weatherapp.BaseTestSpecification;
import com.weatherapp.infrastructure.openweather.OpenWeather;
import com.weatherapp.infrastructure.openweather.OpenWeatherMain;
import com.weatherapp.infrastructure.openweather.OpenWeatherResponse;
import com.weatherapp.infrastructure.openweather.OpenWeatherSys;
import com.weatherapp.infrastructure.openweather.OpenWeatherWind;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

public class WeatherIntTest extends BaseTestSpecification {

    private static final String COUNTRY = "PL";
    private static final String CITY = "Warsaw";
    private static final BigDecimal TEMP = BigDecimal.valueOf(24.00);
    private static final BigDecimal FEELS_LIKE = BigDecimal.valueOf(24.00);
    private static final int PRESSURE = 1020;
    private static final int HUMIDITY = 50;
    private static final float WIND_SPEED = 10.00f;
    private static final String SKY = "Clouds";
    private static final String DESCRIPTION = "A lot of clouds, it might rain";

    @Test
    public void getCurrentForecast() throws Exception {

        WeatherQueryDto queryDto = createWeatherQueryDto();

        mockServer.expect(once(), requestTo(
                "https://api.mock.api.excited.openweathermap.org/data/2.5/weather?q=Warsaw&appid=testapikeyexcited&units=metric"))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withSuccess(objectMapper.writeValueAsString(createResponse()), MediaType.APPLICATION_JSON));

        String stringResponse = mockMvc.perform(get("/api/1/weather/currentForecast")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(queryDto)))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        WeatherDto response = objectMapper.readValue(stringResponse, new TypeReference<>() {
        });

        assert response.getLocalisation().getCountry().equals(COUNTRY);
        assert response.getLocalisation().getCity().equals(CITY);
        assert response.getTemperature().getTemperature().equals(TEMP);
        assert response.getTemperature().getFeelsLike().equals(FEELS_LIKE);
        assert response.getPressure() == PRESSURE;
        assert response.getHumidity() == HUMIDITY;
        assert response.getWindSpeed() == WIND_SPEED;
        assert response.getSky().getSky().equals(SKY);
        assert response.getSky().getDescription().equals(DESCRIPTION);
    }

    private WeatherQueryDto createWeatherQueryDto() {
        WeatherQueryDto queryDto = new WeatherQueryDto();
        queryDto.setCity(CITY);
        queryDto.setUnits(TemperatureUnitsDto.CELSIUS);
        return queryDto;
    }

    private OpenWeatherResponse createResponse() {
        OpenWeatherResponse response = new OpenWeatherResponse();
        response.setWeather(createOpenWeather());
        response.setMain(createMain());
        response.setWind(createWind());
        response.setSys(createSys());
        response.setName(CITY);
        return response;
    }

    private List<OpenWeather> createOpenWeather() {
        OpenWeather openWeather = new OpenWeather();
        openWeather.setMain(SKY);
        openWeather.setDescription(DESCRIPTION);
        List<OpenWeather> list = new ArrayList<>();
        list.add(openWeather);
        return list;
    }

    private OpenWeatherMain createMain() {
        OpenWeatherMain main = new OpenWeatherMain();
        main.setTemp(TEMP);
        main.setFeelsLike(FEELS_LIKE);
        main.setPressure(PRESSURE);
        main.setHumidity(HUMIDITY);
        return main;
    }

    private OpenWeatherWind createWind() {
        OpenWeatherWind wind = new OpenWeatherWind();
        wind.setSpeed(WIND_SPEED);
        return wind;
    }

    private OpenWeatherSys createSys() {
        OpenWeatherSys sys = new OpenWeatherSys();
        sys.setCountry(COUNTRY);
        return sys;
    }
}
