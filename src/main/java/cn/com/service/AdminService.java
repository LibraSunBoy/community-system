package cn.com.service;

import cn.com.entity.Admin;
import cn.com.utils.Result;

import java.util.List;

/**
 * <pre>
 * Filename      :  AdminService
 * Package       :  cn.com.service
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2020年04月2020/4/30日
 * </pre>
 *
 * @author : yangdong.jia
 */
public interface AdminService {

    /**
     * 登录
     * @param account
     * @param pwd
     * @return
     */
    Admin login(String account, String pwd);


    /**
     * 用户注册
     * @param admin
     * @return
     */
    Integer add(Admin admin);


    /**
     * 后台用户列表
     * @param account
     * @return
     */
    Result<List<Admin>> query(Integer pageNum, Integer pageSize, String account);

    /**
     * 单个删除
     * @param id
     */
    void remove(Integer id);

    /**
     * 多个删除
     * @param id
     */
    void removeList(List<Integer> id);
}
