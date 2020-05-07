package cn.com.service.impl;

import cn.com.entity.Community;
import cn.com.entity.Member;
import cn.com.entity.MemberExample;
import cn.com.entity.Unit;
import cn.com.exception.CustomException;
import cn.com.mapper.CommunityMapper;
import cn.com.mapper.MemberMapper;
import cn.com.mapper.UnitMapper;
import cn.com.service.MemberService;
import cn.com.utils.MD5Util;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Filename      :  MemberServiceImpl
 * Package       :  cn.com.service.impl
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2020年04月2020/4/30日
 * </pre>
 *
 * @author : yangdong.jia
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private UnitMapper unitMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public Member login(String account, String pwd) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        List<Member> MemberList = memberMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(MemberList)){
            throw new CustomException(CustomException.CodeEnum.ACCOUNT_ERROR);
        }
        String dbPwd = MemberList.get(0).getPassword();
        if (!MD5Util.MD5EncodeUtf8(pwd).equals(dbPwd)){
            throw new CustomException(CustomException.CodeEnum.PWD_ERROR);
        }
        return MemberList.get(0);
    }

    @Override
    public Integer add(Member member) {
        member.setPassword(MD5Util.MD5EncodeUtf8(member.getPassword()));
        member.setCreateDate(new Date());
        memberMapper.insert(member);
        return member.getId();
    }

    @Override
    public Result<List<Member>> query(Integer pageNum, Integer pageSize, String nickName, String mobile) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(nickName)){
            criteria.andNickNameLike(nickName+"%");
        }
        if (!StringUtils.isEmpty(mobile)){
            criteria.andMobileLike(mobile+"%");
        }
        int i = memberMapper.countByExample(example);
        PageHelper.startPage(pageNum,pageSize);
        List<Member> memberList = memberMapper.selectByExample(example);
        return new Result<>(i,memberList);
    }

    @Override
    public void remove(Integer id) {
        memberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeList(List<Integer> id) {
        id.stream().forEach(i -> remove(i));
    }

    @Override
    public void update(Member member) {
        if (member.getCommunityId()!=null){
            Community community = communityMapper.selectByPrimaryKey(member.getCommunityId());
            member.setCommunity(community.getName());
        }
        if (member.getUnitId()!=null){
            Unit unit = unitMapper.selectByPrimaryKey(member.getUnitId());
            member.setUnit(unit.getName());
        }
        memberMapper.updateByPrimaryKeySelective(member);
    }
}
