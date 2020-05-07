package cn.com.service;

import cn.com.entity.Trash;
import cn.com.utils.Result;

import java.util.List;

public interface TrashService {

    /**
     * 分类列表
     * @param
     * @return
     */
    Result<List<Trash>> query(Integer pageNum, Integer pageSize,String number,String capacity,String location);

    /**
     * 添加
     * @param trash
     */
    void add(Trash trash);

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
     * @param trash
     */
    void update(Trash trash);
}
