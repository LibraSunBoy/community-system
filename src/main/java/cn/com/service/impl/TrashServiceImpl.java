package cn.com.service.impl;

import cn.com.entity.Trash;
import cn.com.entity.TrashExample;
import cn.com.mapper.TrashMapper;
import cn.com.service.TrashService;
import cn.com.utils.Result;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TrashServiceImpl implements TrashService {

    @Autowired
    private TrashMapper trashMapper;

    @Override
    public Result<List<Trash>> query(Integer pageNum, Integer pageSize) {
        TrashExample example = new TrashExample();
//        if (!StringUtils.isEmpty(account)){
//        UnitExample.Criteria criteria = example.createCriteria();
//            criteria.andAccountEqualTo(account);
//        }
        List<Trash> memberList1 = trashMapper.selectByExample(example);
        PageHelper.startPage(pageNum,pageSize);
        List<Trash> memberList = trashMapper.selectByExample(example);
        return new Result<>(memberList1.size(),memberList);
    }

    @Override
    public void add(Trash trash) {
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
}