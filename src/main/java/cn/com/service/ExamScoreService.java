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
    Result<List<ExamScore>> query(Integer pageNum, Integer pageSize);
}
