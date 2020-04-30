package cn.com.mapper;

import cn.com.entity.ExamScore;
import cn.com.entity.ExamScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamScoreMapper {
    int countByExample(ExamScoreExample example);

    int deleteByExample(ExamScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamScore record);

    int insertSelective(ExamScore record);

    List<ExamScore> selectByExample(ExamScoreExample example);

    ExamScore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamScore record, @Param("example") ExamScoreExample example);

    int updateByExample(@Param("record") ExamScore record, @Param("example") ExamScoreExample example);

    int updateByPrimaryKeySelective(ExamScore record);

    int updateByPrimaryKey(ExamScore record);
}