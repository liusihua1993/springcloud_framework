package com.mlink.mapper;


import com.mlink.entity.Material;

import java.util.List;

public interface MaterialMapper {
    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    Material selectByPrimaryKey(String materialId);

    List<Material> selectAll();

    int updateByPrimaryKey(Material record);
}