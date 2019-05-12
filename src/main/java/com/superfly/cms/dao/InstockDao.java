package com.superfly.cms.dao;

import com.superfly.cms.entity.Instock;

import java.util.Date;
import java.util.List;

public interface InstockDao {

    /**
     * 查询所有的入库单
     * @return
     */
    List<Instock> queryInstock();

    /**
     * 查询统计当天入库单
     * @return
     */
    List<Instock> queryInstockToday(Date date1,Date date2);

    /**
     * 通过Id查询入库单
     * @param instockId
     * @return 单个入库单
     */
    Instock queryInstockById(Integer instockId);

    /**
     * 插入入库单信息
     * @param instock
     * @return success:1 flase:0
     */
    int insertInstock(Instock instock);

    /**
     * 更新入库单信息
     * @param instock
     * @return success:1 flase:0
     */
    int updateInstock(Instock instock);

    /**
     * 通过传入的Id删除入库单列表
     * @param instockId
     * @return success:1 flase:0
     */
    int deleteInstock(Integer instockId);
}
