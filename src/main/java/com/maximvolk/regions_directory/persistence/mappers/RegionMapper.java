package com.maximvolk.regions_directory.persistence.mappers;

import com.maximvolk.regions_directory.core.models.Region;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RegionMapper {
    @Select("select * from REGIONS where id = #{id}")
    Region findById(int id);

    @Select("select * from REGIONS")
    List<Region> getAll();

    @Insert("insert into REGIONS (name, shortName) values (#{name}, #{shortName})")
    void add(Region region);

    @Update("update REGIONS set name = #{name}, shortName = #{shortName} where id = #{id}")
    void update(int id, String name, String shortName);

    @Delete("delete from REGIONS where id = #{id}")
    void delete(int regionId);
}
