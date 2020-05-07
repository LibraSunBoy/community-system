package cn.com.service;


import cn.com.entity.Exam;
import cn.com.utils.Result;

import java.util.List;

public interface ExamService {

    /**
     * 测验列表
     * @param
     * @return
     */
    Result<List<Exam>> query(Integer pageNum, Integer pageSize,String title);

    /**
     * 添加
     * @param exam
     */
    void add(Exam exam);

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
     * @param exam
     */
    void update(Exam exam);
}
