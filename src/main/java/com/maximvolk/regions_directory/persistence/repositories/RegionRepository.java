package com.maximvolk.regions_directory.persistence.repositories;

import com.maximvolk.regions_directory.core.interfaces.repositories.IRegionRepository;
import com.maximvolk.regions_directory.core.models.Region;
import com.maximvolk.regions_directory.persistence.mappers.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RegionRepository implements IRegionRepository {
    @Autowired
    private RegionMapper dbMapper;

    @Override
    public Region findById(int id) {
        return dbMapper.findById(id);
    }

    @Override
    public List<Region> get(String name, String shortName) {
        Stream<Region> regionsStream = dbMapper.getAll().stream();

        if (name != null)
            regionsStream = regionsStream.filter(region -> region.getName().equals(name));

        if (shortName != null)
            regionsStream = regionsStream.filter(region -> region.getShortName().equals(shortName));

        return regionsStream.collect(Collectors.toList());
    }

    @Override
    public void add(Region region) {
        dbMapper.add(region);
    }

    @Override
    public void update(int regionId, Region region) {
        dbMapper.update(regionId, region.getName(), region.getShortName());
    }

    @Override
    public void delete(int regionId) {
        dbMapper.delete(regionId);
    }
}
