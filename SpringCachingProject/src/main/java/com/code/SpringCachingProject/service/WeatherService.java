package com.code.SpringCachingProject.service;

import com.code.SpringCachingProject.entity.Weather;

import java.util.List;

public interface WeatherService {

    // add weather method
    Weather addWeather(Weather weather);

    // get weather by city name method
    Weather getWeatherByCity(String city);

    // Get list of weathers method
    List<Weather> getAllWeather();

    // update weather method
    Weather updateWeather(String city, String forecast);

    // delete weather method
    String deleteWeather(String city);
}
