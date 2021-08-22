package com.maximvolk.regions_directory.core.interfaces.services;

import com.maximvolk.regions_directory.common.resources.AddRegionResource;
import com.maximvolk.regions_directory.common.resources.RegionResource;

import java.util.List;

public interface IRegionService {
    List<RegionResource> getRegions(String name, String shortName);
    void addRegion(AddRegionResource region);
    void updateRegion(int regionId, AddRegionResource region);
    void deleteRegion(int regionId);
}
