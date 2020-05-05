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
    Result<List<Trash>> query(Integer pageNum, Integer pageSize);
}
