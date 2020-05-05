package cn.com.service;

import cn.com.entity.Community;
import cn.com.entity.Member;
import cn.com.utils.Result;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CommunityService {
    /**
     * 后台小区列表
     * @param
     * @return
     */
    Result<List<Community>> query(Integer pageNum, Integer pageSize);

    /**
     * 所有小区列表
     * @return
     */
    Result<List<Community>> allList();

    /**
     * 根据id查询数据
     * @param id
     */
    Result<Community> getById(@RequestParam(value = "id") Integer id);

    /**
     * 添加
     * @param community
     */
    void add(Community community);
}
