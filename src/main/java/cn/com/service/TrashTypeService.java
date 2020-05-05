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
    Result<List<TrashType>> query(Integer pageNum, Integer pageSize);

    /**
     * 添加
     * @param trashType
     */
    void add(TrashType trashType);
}
