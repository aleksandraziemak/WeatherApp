package com.weatherapp.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private String city;
    private Units units;
}
