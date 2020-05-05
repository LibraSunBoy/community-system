package cn.com.service.impl;

import cn.com.entity.Exam;
import cn.com.entity.ExamExample;
import cn.com.mapper.ExamMapper;
import cn.com.service.ExamService;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public Result<List<Exam>> query(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ExamExample example = new ExamExample();
//        if (!StringUtils.isEmpty(account)){
//        UnitExample.Criteria criteria = example.createCriteria();
//            criteria.andAccountEqualTo(account);
//        }
        List<Exam> memberList = examMapper.selectByExample(example);
        return new Result<>(memberList.size(),memberList);
    }
}
