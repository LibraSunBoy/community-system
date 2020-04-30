package cn.com.mapper;

import cn.com.entity.Trash;
import cn.com.entity.TrashExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrashMapper {
    int countByExample(TrashExample example);

    int deleteByExample(TrashExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Trash record);

    int insertSelective(Trash record);

    List<Trash> selectByExample(TrashExample example);

    Trash selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Trash record, @Param("example") TrashExample example);

    int updateByExample(@Param("record") Trash record, @Param("example") TrashExample example);

    int updateByPrimaryKeySelective(Trash record);

    int updateByPrimaryKey(Trash record);
}