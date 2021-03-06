package cn.com.service.impl;

import cn.com.entity.Community;
import cn.com.entity.Trash;
import cn.com.entity.TrashExample;
import cn.com.entity.TrashType;
import cn.com.mapper.CommunityMapper;
import cn.com.mapper.TrashMapper;
import cn.com.mapper.TrashTypeMapper;
import cn.com.service.TrashService;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class TrashServiceImpl implements TrashService {

    @Autowired
    private TrashMapper trashMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private TrashTypeMapper trashTypeMapper;

    @Override
    public Result<List<Trash>> query(Integer pageNum, Integer pageSize, String number, String capacity, String location) {
        TrashExample example = new TrashExample();
        TrashExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(number)){
            criteria.andNumberLike(number+"%");
        }
        if (!StringUtils.isEmpty(capacity)){
            criteria.andCapacityLike(capacity+"%");
        }
        if (!StringUtils.isEmpty(location)){
            criteria.andLocationLike(location+"%");
        }
        List<Trash> memberList1 = trashMapper.selectByExample(example);
        PageHelper.startPage(pageNum,pageSize);
        List<Trash> memberList = trashMapper.selectByExample(example);
        return new Result<>(memberList1.size(),memberList);
    }

    @Override
    public Result<List<Trash>> findList(Integer communityId, Integer status, Integer trashTypeId) {
        TrashExample example = new TrashExample();
        TrashExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(communityId)){
            criteria.andCommunityIdEqualTo(communityId);
        }
        if (!StringUtils.isEmpty(status)){
            criteria.andStatusEqualTo(status.longValue());
        }
        if (!StringUtils.isEmpty(trashTypeId)){
            criteria.andTrashTypeIdEqualTo(trashTypeId);
        }
        List<Trash> memberList = trashMapper.selectByExample(example);
        return new Result<>().success(memberList);
    }

    //    @Override
//    public Result<List<Trash>> getLocation() {
//        TrashExample example = new TrashExample();
//        example.setDistinct(true);
//        TrashExample.Criteria criteria = example.createCriteria();
//        criteria.andLocationIsNotNull();
//        List<Trash> memberList = trashMapper.selectByExample(example);
//        return new Result<>().success(memberList);
//    }

    @Override
    public void add(Trash trash) {
        dealForeignKey(trash);
        trash.setCreateDate(new Date());
        trashMapper.insert(trash);
    }

    @Override
    public void remove(Integer id) {
        trashMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeList(List<Integer> id) {
        id.stream().forEach(i -> remove(i));
    }

    @Override
    public void update(Trash trash) {
        dealForeignKey(trash);
        trashMapper.updateByPrimaryKeySelective(trash);
    }

    private void dealForeignKey(Trash trash){
        if (trash.getCommunityId()!=null){
            Community community = communityMapper.selectByPrimaryKey(trash.getCommunityId());
            trash.setCommunity(community.getName());
        }
        if (trash.getTrashTypeId()!=null){
            TrashType trashType = trashTypeMapper.selectByPrimaryKey(trash.getTrashTypeId());
            trash.setTrashType(trashType.getName());
        }
    }
}
