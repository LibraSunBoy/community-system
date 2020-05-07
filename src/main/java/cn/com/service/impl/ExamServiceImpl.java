package cn.com.service.impl;

import cn.com.entity.Exam;
import cn.com.entity.ExamExample;
import cn.com.mapper.ExamMapper;
import cn.com.service.ExamService;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public Result<List<Exam>> query(Integer pageNum, Integer pageSize, String title) {
        ExamExample example = new ExamExample();
        if (!StringUtils.isEmpty(title)){
            ExamExample.Criteria criteria = example.createCriteria();
            criteria.andTitleLike(title+"%");
        }
        List<Exam> memberList1 = examMapper.selectByExample(example);
        PageHelper.startPage(pageNum,pageSize);
        List<Exam> memberList = examMapper.selectByExample(example);
        return new Result<>(memberList1.size(),memberList);
    }

    @Override
    public void add(Exam exam) {
        exam.setCreateDate(new Date());
        examMapper.insert(exam);
    }

    @Override
    public void remove(Integer id) {
        examMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeList(List<Integer> id) {
        id.stream().forEach(i -> remove(i));
    }
}
