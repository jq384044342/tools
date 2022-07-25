package com.zhuzhuhe.tools.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface TestMapper {
    @Select("select name from user where id=#{id}")
    String getName(Map<String,Object> params);
}
