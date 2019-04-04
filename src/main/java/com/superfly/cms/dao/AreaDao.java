package com.superfly.cms.dao;

import com.superfly.cms.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     *
     * @return AreaList
     */
    List<Area> queryArea();

    /**
     *
     * @param areaId
     * @return area
     */
    Area queryAreaByid(int areaId);

    /**
     *
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     *
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     *
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);
}
