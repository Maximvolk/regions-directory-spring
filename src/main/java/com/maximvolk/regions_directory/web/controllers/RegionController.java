package com.maximvolk.regions_directory.web.controllers;

import com.maximvolk.regions_directory.common.resources.AddRegionResource;
import com.maximvolk.regions_directory.common.resources.RegionResource;
import com.maximvolk.regions_directory.core.interfaces.services.IRegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Regions")
public class RegionController {
    Logger logger = LoggerFactory.getLogger(RegionController.class);

    @Autowired
    private IRegionService service;

    @GetMapping
    public List<RegionResource> getRegions(@RequestParam(required = false) String name, @RequestParam(required = false) String shortName) {
        logger.info(String.format("Extracting regions (name = %s, shortName = %s)", name, shortName));
        return service.getRegions(name, shortName);
    }

    @PostMapping
    public void addRegion(@RequestBody AddRegionResource region) {
        logger.info(String.format("Adding region (name = %s, shortName = %s)", region.getName(), region.getName()));
        service.addRegion(region);
    }

    @PutMapping("/{id}")
    public void updateRegion(@PathVariable final int id, @RequestBody AddRegionResource region) {
        logger.info(String.format("Updating region #%s (name = %s, shortName = %s)", id, region.getShortName(), region.getShortName()));
        service.updateRegion(id, region);
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable int id) {
        logger.info(String.format("Deleting region #%s", id));
        service.deleteRegion(id);
    }
}
