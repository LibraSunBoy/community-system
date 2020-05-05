package cn.com.service.impl;

import cn.com.entity.ExamScore;
import cn.com.entity.ExamScoreExample;
import cn.com.mapper.ExamScoreMapper;
import cn.com.service.ExamScoreService;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamScoreServiceImpl implements ExamScoreService {

    @Autowired
    private ExamScoreMapper examScoreMapper;

    @Override
    public Result<List<ExamScore>> query(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ExamScoreExample example = new ExamScoreExample();
//        if (!StringUtils.isEmpty(account)){
//        UnitExample.Criteria criteria = example.createCriteria();
//            criteria.andAccountEqualTo(account);
//        }
        List<ExamScore> memberList = examScoreMapper.selectByExample(example);
        return new Result<>(memberList.size(),memberList);
    }
}
