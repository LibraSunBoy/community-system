package cn.com.mapper;

import cn.com.entity.TrashType;
import cn.com.entity.TrashTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrashTypeMapper {
    int countByExample(TrashTypeExample example);

    int deleteByExample(TrashTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TrashType record);

    int insertSelective(TrashType record);

    List<TrashType> selectByExample(TrashTypeExample example);

    TrashType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TrashType record, @Param("example") TrashTypeExample example);

    int updateByExample(@Param("record") TrashType record, @Param("example") TrashTypeExample example);

    int updateByPrimaryKeySelective(TrashType record);

    int updateByPrimaryKey(TrashType record);
}