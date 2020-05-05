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
    Result<List<Exam>> query(Integer pageNum, Integer pageSize);
}
