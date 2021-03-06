package cn.com.service;

import cn.com.entity.TrashType;
import cn.com.utils.Result;

import java.util.List;

public interface TrashTypeService {

    /**
     * 分类列表
     * @param
     * @return
     */
    Result<List<TrashType>> query(Integer pageNum, Integer pageSize, String name);

    /**
     * 查询启用的类别
     * @return
     */
    Result<List<TrashType>> usebleList();

    /**
     * 添加
     * @param trashType
     */
    void add(TrashType trashType);

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
     * @param trashType
     */
    void update(TrashType trashType);

}
