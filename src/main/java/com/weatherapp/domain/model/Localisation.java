package com.weatherapp.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Localisation {
    private String country;
    private String city;

    private Localisation(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public static Localisation of(String country, String city) {
        return new Localisation(country, city);
    }
}
