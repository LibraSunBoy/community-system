package cn.com.service;

import cn.com.entity.TrashKnowledge;
import cn.com.utils.Result;

import java.util.List;


public interface TrashKnowledgeService {
    /**
     * 小知识列表
     * @param
     * @return
     */
    Result<List<TrashKnowledge>> query(Integer pageNum, Integer pageSize, Integer trashTypeId, String title);


    Result<List<TrashKnowledge>> getByTypeId(Integer id);
    /**
     * 添加
     * @param trashKnowledge
     */
    void add(TrashKnowledge trashKnowledge);

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
     * @param trashKnowledge
     */
    void update(TrashKnowledge trashKnowledge);

}
