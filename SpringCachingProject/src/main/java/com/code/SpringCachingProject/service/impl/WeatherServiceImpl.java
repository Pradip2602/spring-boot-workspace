package com.code.SpringCachingProject.service.impl;


import com.code.SpringCachingProject.entity.Weather;
import com.code.SpringCachingProject.repository.WeatherRepository;
import com.code.SpringCachingProject.service.WeatherService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    // This is implementation class of service interface

    // constructor injection
    private WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    // add weather impl
    @Override
    public Weather addWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    // Get all list of weathers impl
    @Override
    public List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }

    // get weather by city name impl , enabled caching to prevent frequent DB call.
    @Override
    @Cacheable(value = "weatherByCity", key = "#city") //specifying that make this method use cache
    public Weather getWeatherByCity(String city) {
        return weatherRepository.findByCity(city);
    }

    // @CachePut used to prevent data inconsistency
    @Override
    @CachePut(value = "weatherByCity", key = "#city")    // now cache also get updated once weather updates.
    public Weather updateWeather(String city, String forecast) {
        // get weather from DB
        Weather weather = weatherRepository.findByCity(city);

        if (weather != null) {
            // update weather details
            weather.setForecast(forecast);

            // update weather in DB
            weatherRepository.save(weather);
        }
        return weather;
    }

    // @CacheEvict used to prevent data inconsistency
    @Override
    @CacheEvict(value = "weatherByCity", key = "#city") // cache gets deleted when record deleted in DB.
    public String deleteWeather(String city) {
        // get weather from DB
        Weather weather = weatherRepository.findByCity(city);

        if (weather != null) {
            weatherRepository.delete(weather);
            return "Weather data deleted for : " + city;
        } else {
            return "No Weather data found for city : " + city;
        }
    }
}
