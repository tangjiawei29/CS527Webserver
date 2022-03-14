package com.cs527.web.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface DatabaseMapper {
    List<LinkedHashMap> exec(String sql);
}
