package cn.com.service.impl;

import cn.com.entity.Member;
import cn.com.entity.MemberExample;
import cn.com.exception.CustomException;
import cn.com.mapper.MemberMapper;
import cn.com.service.MemberService;
import cn.com.utils.MD5Util;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
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
    public Result<List<Member>> query(Integer pageNum, Integer pageSize, String account) {
        PageHelper.startPage(pageNum,pageSize);
        MemberExample example = new MemberExample();
        if (!StringUtils.isEmpty(account)){
            MemberExample.Criteria criteria = example.createCriteria();
            criteria.andAccountEqualTo(account);
        }
        List<Member> memberList = memberMapper.selectByExample(example);
        return new Result<>(memberList.size(),memberList);
    }
}
