package com.superfly.cms.dao;

import com.superfly.cms.entity.Outstock;

import java.util.Date;
import java.util.List;

public interface OutstockDao {

    /**
     * 查询所有的出库单
     * @return
     */
    List<Outstock> queryOutstock();

    /**
     * 查询统计当天入库单
     * @return
     */
    List<Outstock> queryOutstockToday(Date date1, Date date2);


    /**
     * 通过Id查询出库单
     * @param outstockId
     * @return 单个出库单
     */
    Outstock queryOutstockById(Integer outstockId);

    /**
     * 插出出库单信息
     * @param outstock
     * @return success:1 flase:0
     */
    int insertOutstock(Outstock outstock);

    /**
     * 更新出库单信息
     * @param outstock
     * @return success:1 flase:0
     */
    int updateOutstock(Outstock outstock);

    /**
     * 通过传出的Id删除出库单列表
     * @param outstockId
     * @return success:1 flase:0
     */
    int deleteOutstock(Integer outstockId);
}
