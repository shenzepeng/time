package com.example.time.mapper;

import com.example.time.pojo.Remind;
import com.example.time.pojo.RemindExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RemindMapper {
    int countByExample(RemindExample example);

    int deleteByExample(RemindExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Remind record);

    int insertSelective(Remind record);

    List<Remind> selectByExample(RemindExample example);

    Remind selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Remind record, @Param("example") RemindExample example);

    int updateByExample(@Param("record") Remind record, @Param("example") RemindExample example);

    int updateByPrimaryKeySelective(Remind record);

    int updateByPrimaryKey(Remind record);
}