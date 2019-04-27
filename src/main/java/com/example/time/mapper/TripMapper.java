package com.example.time.mapper;

import com.example.time.pojo.Trip;
import com.example.time.pojo.TripExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TripMapper {
    int countByExample(TripExample example);

    int deleteByExample(TripExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Trip record);

    int insertSelective(Trip record);

    List<Trip> selectByExample(TripExample example);

    Trip selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Trip record, @Param("example") TripExample example);

    int updateByExample(@Param("record") Trip record, @Param("example") TripExample example);

    int updateByPrimaryKeySelective(Trip record);

    int updateByPrimaryKey(Trip record);
}