package cn.com.mapper;

import cn.com.entity.TrashKnowledge;
import cn.com.entity.TrashKnowledgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrashKnowledgeMapper {
    int countByExample(TrashKnowledgeExample example);

    int deleteByExample(TrashKnowledgeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TrashKnowledge record);

    int insertSelective(TrashKnowledge record);

    List<TrashKnowledge> selectByExample(TrashKnowledgeExample example);

    TrashKnowledge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TrashKnowledge record, @Param("example") TrashKnowledgeExample example);

    int updateByExample(@Param("record") TrashKnowledge record, @Param("example") TrashKnowledgeExample example);

    int updateByPrimaryKeySelective(TrashKnowledge record);

    int updateByPrimaryKey(TrashKnowledge record);
}