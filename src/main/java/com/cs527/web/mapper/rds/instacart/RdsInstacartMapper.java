 package com.cs527.web.mapper.rds.instacart;

 import org.apache.ibatis.annotations.Mapper;

 import java.util.LinkedHashMap;
 import java.util.List;

 @Mapper
 public interface RdsInstacartMapper {
     List<LinkedHashMap> exec(String sql);
 }