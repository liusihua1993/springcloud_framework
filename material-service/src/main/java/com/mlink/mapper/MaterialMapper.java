package com.mlink.mapper;


import com.mlink.entity.Material;

import java.util.List;
/**
 * @author LSH
 * @version 1.1
 * @date 2018/10/17
 * @Description
 */
public interface MaterialMapper {
    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    Material selectByPrimaryKey(String materialId);

    List<Material> selectAll();

    int updateByPrimaryKey(Material record);
}