package cn.com.service.impl;

import cn.com.entity.MemberExample;
import cn.com.entity.Unit;
import cn.com.entity.UnitExample;
import cn.com.mapper.UnitMapper;
import cn.com.service.UnitService;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitMapper unitMapper;

    @Override
    public Result<List<Unit>> query(Integer pageNum, Integer pageSize) {
        UnitExample example = new UnitExample();
//        if (!StringUtils.isEmpty(account)){
//        UnitExample.Criteria criteria = example.createCriteria();
//            criteria.andAccountEqualTo(account);
//        }
        List<Unit> memberList1 = unitMapper.selectByExample(example);
        PageHelper.startPage(pageNum,pageSize);
        List<Unit> memberList = unitMapper.selectByExample(example);
        return new Result<>(memberList1.size(),memberList);
    }

    @Override
    public void add(Unit unit) {
        unit.setCreateDate(new Date());
        unitMapper.insert(unit);
    }

    @Override
    public void remove(Integer id) {
        unitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeList(List<Integer> id) {
        id.stream().forEach(i -> remove(i));
    }
}
