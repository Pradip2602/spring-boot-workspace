package com.code.SpringCachingProject.controller;

import com.code.SpringCachingProject.entity.Weather;
import com.code.SpringCachingProject.service.CacheService;
import com.code.SpringCachingProject.service.impl.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")     // base url
public class WeatherController {

    // constructor injection
    private WeatherServiceImpl weatherService;

    public WeatherController(WeatherServiceImpl weatherService) {
        this.weatherService = weatherService;
    }

    //field injection
    @Autowired        // get bean from Cache service to call api
    private CacheService cacheService;

    // add weather
    @PostMapping
    public ResponseEntity<Weather> addWeather(@RequestBody Weather weather) {
        return ResponseEntity.ok(weatherService.addWeather(weather));
    }

    // Get all weather details
    @GetMapping
    public ResponseEntity<List<Weather>> getAllWeather() {
        return ResponseEntity.ok(weatherService.getAllWeather());
    }

    // Get weather by city
    @GetMapping("/{city}")
    public ResponseEntity<Weather> getWeatherByCity(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getWeatherByCity(city));
    }

    // creating a api to get cache data
    @GetMapping("/cacheData/{cacheName}")
    public void getCacheData(@PathVariable String cacheName) {
        cacheService.printCacheData(cacheName);
    }

    // Update weather
    @PutMapping("/updateWeather")
    public ResponseEntity<Weather> updateWeather(@RequestParam String city, @RequestParam String forecast) {
        return ResponseEntity.ok(weatherService.updateWeather(city, forecast));
    }

    // delete weather details
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteWeather(@RequestParam String city) {
        return ResponseEntity.ok(weatherService.deleteWeather(city));
    }
}
