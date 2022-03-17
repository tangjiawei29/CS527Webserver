 package com.cs527.web.mapper.rds;

 import org.apache.ibatis.annotations.Mapper;

 import java.util.LinkedHashMap;
 import java.util.List;

 @Mapper
 public interface RdsMapper {
     List<LinkedHashMap> exec(String sql);
 }