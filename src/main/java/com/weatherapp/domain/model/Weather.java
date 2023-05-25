package com.weatherapp.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Weather {
    private Localisation localisation;
    private Temperature temperature;
    private int pressure;
    private int humidity;
    private float windSpeed;
    private Sky sky;

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Localisation localisation;
        private Temperature temperature;
        private int pressure;
        private int humidity;
        private float windSpeed;
        private Sky sky;

        public Builder localisation(Localisation localisation) {
            this.localisation = localisation;
            return this;
        }

        public Builder temperature(Temperature temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder pressure(int pressure) {
            this.pressure = pressure;
            return this;
        }

        public Builder humidity(int humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder windSpeed(float windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public Builder sky(Sky sky) {
            this.sky = sky;
            return this;
        }

        public Weather build() {
            Weather weather = new Weather();
            weather.localisation = this.localisation;
            weather.temperature = this.temperature;
            weather.pressure = this.pressure;
            weather.humidity = this.humidity;
            weather.windSpeed = this.windSpeed;
            weather.sky = this.sky;
            return weather;
        }
    }
}
