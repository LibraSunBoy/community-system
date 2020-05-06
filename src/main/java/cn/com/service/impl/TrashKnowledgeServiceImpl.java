package cn.com.service.impl;

import cn.com.entity.TrashKnowledge;
import cn.com.entity.TrashKnowledgeExample;
import cn.com.mapper.TrashKnowledgeMapper;
import cn.com.service.TrashKnowledgeService;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TrashKnowledgeServiceImpl implements TrashKnowledgeService {

    @Autowired
    private TrashKnowledgeMapper trashKnowledgeMapper;

    @Override
    public Result<List<TrashKnowledge>> query(Integer pageNum, Integer pageSize) {
        TrashKnowledgeExample example = new TrashKnowledgeExample();
//        if (!StringUtils.isEmpty(account)){
//        UnitExample.Criteria criteria = example.createCriteria();
//            criteria.andAccountEqualTo(account);
//        }
        List<TrashKnowledge> memberList1 = trashKnowledgeMapper.selectByExample(example);
        PageHelper.startPage(pageNum,pageSize);
        List<TrashKnowledge> memberList = trashKnowledgeMapper.selectByExample(example);
        return new Result<>(memberList1.size(),memberList);
    }

    @Override
    public void add(TrashKnowledge trashKnowledge) {
        trashKnowledge.setCreateDate(new Date());
        trashKnowledgeMapper.insert(trashKnowledge);
    }

    @Override
    public void remove(Integer id) {
        trashKnowledgeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeList(List<Integer> id) {
        id.stream().forEach(i -> remove(i));
    }
}