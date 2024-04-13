package com.senlikag.senlikagibb1.service;


import com.senlikag.senlikagibb1.entity.Location;
import com.senlikag.senlikagibb1.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

   public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public List<Location> getLocationsByTownId(String townId) {
        return locationRepository.findByTownId(townId);
    }
}
