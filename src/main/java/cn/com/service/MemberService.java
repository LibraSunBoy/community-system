package cn.com.service;

import cn.com.entity.Member;
import cn.com.utils.Result;

import java.util.List;

/**
 * <pre>
 * Filename      :  MemberService
 * Package       :  cn.com.service
 * Company       :  上海想星商务服务有限公司
 * Create Date   :  2020年04月2020/4/30日
 * </pre>
 *
 * @author : yangdong.jia
 */
public interface MemberService {

    /**
     * 登录
     * @param account
     * @param pwd
     * @return
     */
    Member login(String account, String pwd);


    /**
     * 用户注册
     * @param member
     * @return
     */
    Integer add(Member member);


    /**
     * 后台用户列表
     * @param account
     * @return
     */
    Result<List<Member>> query(Integer pageNum, Integer pageSize, String account);

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
