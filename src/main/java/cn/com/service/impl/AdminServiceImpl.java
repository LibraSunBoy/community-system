package cn.com.service.impl;

import cn.com.entity.Admin;
import cn.com.entity.AdminExample;
import cn.com.exception.CustomException;
import cn.com.mapper.AdminMapper;
import cn.com.service.AdminService;
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
 * Filename      :  AdminServiceImpl
 * Package       :  cn.com.service.impl
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2020年04月2020/4/30日
 * </pre>
 *
 * @author : yangdong.jia
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String account, String pwd) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andStatusEqualTo(1L);
        List<Admin> adminList = adminMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(adminList)){
            throw new CustomException(CustomException.CodeEnum.ACCOUNT_ERROR);
        }
        String dbPwd = adminList.get(0).getPassword();
        if (!MD5Util.MD5EncodeUtf8(pwd).equals(dbPwd)){
            throw new CustomException(CustomException.CodeEnum.PWD_ERROR);
        }
        return adminList.get(0);
    }

    @Override
    public Integer add(Admin admin) {
        admin.setPassword(MD5Util.MD5EncodeUtf8(admin.getPassword()));
        admin.setStatus(1L);
        admin.setCreateDate(new Date());
        adminMapper.insert(admin);
        return admin.getId();
    }

    @Override
    public Result<List<Admin>> query(Integer pageNum, Integer pageSize, String account) {
        PageHelper.startPage(pageNum,pageSize);
        AdminExample example = new AdminExample();
        if (!StringUtils.isEmpty(account)){
            AdminExample.Criteria criteria = example.createCriteria();
            criteria.andAccountEqualTo(account);
        }
        List<Admin> userList = adminMapper.selectByExample(example);
        return new Result<>(userList.size(),userList);
    }
}
