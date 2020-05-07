package cn.com.service.impl;

import cn.com.entity.Exam;
import cn.com.entity.ExamScore;
import cn.com.entity.ExamScoreExample;
import cn.com.entity.Member;
import cn.com.mapper.ExamMapper;
import cn.com.mapper.ExamScoreMapper;
import cn.com.mapper.MemberMapper;
import cn.com.service.ExamScoreService;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class ExamScoreServiceImpl implements ExamScoreService {

    @Autowired
    private ExamScoreMapper examScoreMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private ExamMapper examMapper;

    @Override
    public Result<List<ExamScore>> query(Integer pageNum, Integer pageSize, Integer memberId, Integer examId, Integer score) {
        ExamScoreExample example = new ExamScoreExample();
        ExamScoreExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(memberId)){
            criteria.andMemberIdEqualTo(memberId);
        }
        if (!StringUtils.isEmpty(examId)){
            criteria.andExamIdEqualTo(examId);
        }
        if (!StringUtils.isEmpty(score)){
            criteria.andScoreEqualTo(score);
        }
        List<ExamScore> memberList1 = examScoreMapper.selectByExample(example);
        PageHelper.startPage(pageNum,pageSize);
        List<ExamScore> memberList = examScoreMapper.selectByExample(example);
        return new Result<>(memberList1.size(),memberList);
    }

    @Override
    public void add(ExamScore examScore) {
        dealForeignKey(examScore);
        examScore.setCreateDate(new Date());
        examScoreMapper.insert(examScore);
    }

    @Override
    public void remove(Integer id) {
        examScoreMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeList(List<Integer> id) {
        id.stream().forEach(i -> remove(i));
    }

    @Override
    public void update(ExamScore examScore) {
        dealForeignKey(examScore);
        examScoreMapper.updateByPrimaryKeySelective(examScore);
    }

    private void dealForeignKey(ExamScore examScore){
        if (examScore.getExamId()!=null){
            Exam exam = examMapper.selectByPrimaryKey(examScore.getExamId());
            examScore.setTitle(exam.getTitle());
        }
        if (examScore.getMemberId()!=null){
            Member member = memberMapper.selectByPrimaryKey(examScore.getMemberId());
            examScore.setNickName(member.getNickName());
        }
    }
}
