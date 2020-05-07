package cn.com.service;

import cn.com.entity.ExamScore;
import cn.com.utils.Result;

import java.util.List;

public interface ExamScoreService {

    /**
     * 成绩列表
     * @param
     * @return
     */
    Result<List<ExamScore>> query(Integer pageNum, Integer pageSize,Integer memberId,Integer examId,Integer score);

    /**
     * 添加
     * @param examScore
     */
    void add(ExamScore examScore);

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
}
