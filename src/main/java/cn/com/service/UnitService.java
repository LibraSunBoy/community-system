package cn.com.service;

import cn.com.entity.Unit;
import cn.com.utils.Result;

import java.util.List;

public interface UnitService {
    /**
     * 后台小区单元列表
     * @param
     * @return
     */
    Result<List<Unit>> query(Integer pageNum, Integer pageSize, String name, Integer floor, String location);

    /**
     * 添加
     * @param unit
     */
    void add(Unit unit);

    /**
     * 单个删除
     * @param id
     */
    void remove(Integer id);

    /**
     * 多个删除
     * @param id
     */
    void removeList(List<Integer> id);

    /**
     * 修改
     * @param unit
     */
    void update(Unit unit);
}
