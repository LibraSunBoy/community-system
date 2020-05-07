package cn.com.service.impl;

import cn.com.entity.TrashKnowledge;
import cn.com.entity.TrashKnowledgeExample;
import cn.com.entity.TrashType;
import cn.com.mapper.TrashKnowledgeMapper;
import cn.com.mapper.TrashTypeMapper;
import cn.com.service.TrashKnowledgeService;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class TrashKnowledgeServiceImpl implements TrashKnowledgeService {

    @Autowired
    private TrashKnowledgeMapper trashKnowledgeMapper;

    @Autowired
    private TrashTypeMapper trashTypeMapper;

    @Override
    public Result<List<TrashKnowledge>> query(Integer pageNum, Integer pageSize, Integer trashTypeId, String title) {
        TrashKnowledgeExample example = new TrashKnowledgeExample();
        TrashKnowledgeExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(trashTypeId)){
            criteria.andTrashTypeIdEqualTo(trashTypeId);
        }
        if (!StringUtils.isEmpty(title)){
            criteria.andTitleLike(title+"%");
        }
        List<TrashKnowledge> memberList1 = trashKnowledgeMapper.selectByExample(example);
        PageHelper.startPage(pageNum,pageSize);
        List<TrashKnowledge> memberList = trashKnowledgeMapper.selectByExample(example);
        return new Result<>(memberList1.size(),memberList);
    }

    @Override
    public void add(TrashKnowledge trashKnowledge) {
        dealForeignKey(trashKnowledge);
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

    private void dealForeignKey(TrashKnowledge trashKnowledge){
        if (trashKnowledge.getTrashTypeId()!=null){
            TrashType trashType = trashTypeMapper.selectByPrimaryKey(trashKnowledge.getTrashTypeId());
            trashKnowledge.setTrashType(trashType.getName());
        }
    }
}
