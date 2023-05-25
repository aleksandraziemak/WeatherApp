package com.weatherapp.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sky {
    private String sky;
    private String description;

    private Sky(String sky, String description) {
        this.sky = sky;
        this.description = description;
    }

    public static Sky of(String sky, String description) {
        return new Sky(sky, description);
    }
}
