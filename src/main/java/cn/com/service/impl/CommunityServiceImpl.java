package cn.com.service.impl;

import cn.com.entity.Community;
import cn.com.entity.CommunityExample;
import cn.com.entity.Member;
import cn.com.entity.MemberExample;
import cn.com.mapper.CommunityMapper;
import cn.com.service.CommunityService;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public Result<List<Community>> query(Integer pageNum, Integer pageSize) {
        CommunityExample example = new CommunityExample();
//        if (!StringUtils.isEmpty(account)){
//            CommunityExample.Criteria criteria = example.createCriteria();
//            criteria.andAccountEqualTo(account);
//        }
        List<Community> communityList1 = communityMapper.selectByExample(example);
        PageHelper.startPage(pageNum,pageSize);
        List<Community> communityList = communityMapper.selectByExample(example);
        return new Result<>(communityList1.size(),communityList);
    }

    @Override
    public Result<List<Community>> allList() {
        CommunityExample example = new CommunityExample();
        List<Community> communityList = communityMapper.selectByExample(example);
        return new Result<>(communityList.size(),communityList);
    }

    @Override
    public Result<Community> getById(Integer id) {
        Community community = communityMapper.selectByPrimaryKey(id);
        return new Result<>().success(community);
    }

    @Override
    public void add(Community community) {
        community.setCreateDate(new Date());
        communityMapper.insert(community);
    }

    @Override
    public void remove(Integer id) {
        communityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeList(List<Integer> id) {
        id.stream().forEach(i -> remove(i));
    }
}
