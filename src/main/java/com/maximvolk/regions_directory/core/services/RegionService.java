package com.maximvolk.regions_directory.core.services;

import com.maximvolk.regions_directory.common.resources.AddRegionResource;
import com.maximvolk.regions_directory.common.resources.RegionResource;
import com.maximvolk.regions_directory.core.exceptions.BadRequestException;
import com.maximvolk.regions_directory.core.exceptions.NotFoundException;
import com.maximvolk.regions_directory.core.interfaces.repositories.IRegionRepository;
import com.maximvolk.regions_directory.core.interfaces.services.IRegionService;
import com.maximvolk.regions_directory.core.models.Region;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionService implements IRegionService {
    @Autowired
    private IRegionRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<RegionResource> getRegions(String name, String shortName) {
        List<Region> regions = repository.get(name, shortName);

        return regions.stream()
                .map(region -> mapper.map(region, RegionResource.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addRegion(AddRegionResource regionResource) {
        List<Region> existingRegion = repository.get(regionResource.getName(), regionResource.getShortName());

        if (existingRegion.size() > 0)
            throw new BadRequestException("Region already exists");

        Region region = mapper.map(regionResource, Region.class);
        repository.add(mapper.map(regionResource, Region.class));
    }

    @Override
    public void updateRegion(int regionId, AddRegionResource regionResource) {
        Region existingRegion = repository.findById(regionId);

        if (existingRegion == null)
            throw new NotFoundException("Region not found");

        repository.update(regionId, mapper.map(regionResource, Region.class));
    }

    @Override
    public void deleteRegion(int regionId) {
        Region existingRegion = repository.findById(regionId);

        if (existingRegion == null)
            throw new NotFoundException("Region not found");

        repository.delete(regionId);
    }
}
