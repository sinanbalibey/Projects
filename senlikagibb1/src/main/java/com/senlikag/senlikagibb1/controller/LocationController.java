package com.senlikag.senlikagibb1.controller;


import com.senlikag.senlikagibb1.entity.Location;
import com.senlikag.senlikagibb1.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }
    @GetMapping("/{townId}")
    public List<Location> getLocationsByTownId(@PathVariable String townId) {
        return locationService.getLocationsByTownId(townId);
    }

}
