package cn.com.service.impl;

import cn.com.entity.Community;
import cn.com.entity.Unit;
import cn.com.entity.UnitExample;
import cn.com.mapper.CommunityMapper;
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

    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public Result<List<Unit>> query(Integer pageNum, Integer pageSize,String name,Integer floor,String location) {
        UnitExample example = new UnitExample();
        UnitExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(floor)){
            criteria.andFloorEqualTo(floor);
        }
        if (!StringUtils.isEmpty(name)){
            criteria.andNameLike(name+"%");
        }
        if (!StringUtils.isEmpty(location)){
            criteria.andLocationLike(location+"%");
        }
        List<Unit> memberList1 = unitMapper.selectByExample(example);
        PageHelper.startPage(pageNum,pageSize);
        List<Unit> memberList = unitMapper.selectByExample(example);
        return new Result<>(memberList1.size(),memberList);
    }

    @Override
    public void add(Unit unit) {
        dealForeignKey(unit);
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

    @Override
    public void update(Unit unit) {
        dealForeignKey(unit);
        unitMapper.updateByPrimaryKeySelective(unit);
    }

    private void dealForeignKey(Unit unit){
        if (unit.getCommunityId()!=null){
            Community community = communityMapper.selectByPrimaryKey(unit.getCommunityId());
            unit.setCommunity(community.getName());
        }
    }
}
