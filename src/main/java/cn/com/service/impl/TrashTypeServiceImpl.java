package cn.com.service.impl;

import cn.com.entity.TrashType;
import cn.com.entity.TrashTypeExample;
import cn.com.mapper.TrashTypeMapper;
import cn.com.service.TrashTypeService;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TrashTypeServiceImpl implements TrashTypeService {

    @Autowired
    private TrashTypeMapper trashTypeMapper;

    @Override
    public Result<List<TrashType>> query(Integer pageNum, Integer pageSize) {
        TrashTypeExample example = new TrashTypeExample();
//        if (!StringUtils.isEmpty(account)){
//        UnitExample.Criteria criteria = example.createCriteria();
//            criteria.andAccountEqualTo(account);
//        }
        List<TrashType> memberList1 = trashTypeMapper.selectByExample(example);
        PageHelper.startPage(pageNum,pageSize);
        List<TrashType> memberList = trashTypeMapper.selectByExample(example);
        return new Result<>(memberList1.size(),memberList);
    }

    @Override
    public void add(TrashType trashType) {
        trashType.setStatus(1L);
        trashType.setCreateDate(new Date());
        trashTypeMapper.insert(trashType);
    }
}
