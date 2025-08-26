package com.code.SpringCachingProject.repository;

import com.code.SpringCachingProject.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    // derived query method to get weather by city name
    Weather findByCity(String city);

}
