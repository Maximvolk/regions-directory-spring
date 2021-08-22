package com.maximvolk.regions_directory.core.interfaces.repositories;

import com.maximvolk.regions_directory.core.models.Region;

import java.util.List;

public interface IRegionRepository {
    Region findById(int id);
    List<Region> get(String name, String shortName);
    void add(Region region);
    void update(int regionId, Region region);
    void delete(int regionId);
}
