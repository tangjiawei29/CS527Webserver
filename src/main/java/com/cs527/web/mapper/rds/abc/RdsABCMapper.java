 package com.cs527.web.mapper.rds.abc;

 import org.apache.ibatis.annotations.Mapper;

 import java.util.LinkedHashMap;
 import java.util.List;

 @Mapper
 public interface RdsABCMapper {
     List<LinkedHashMap> exec(String sql);
 }