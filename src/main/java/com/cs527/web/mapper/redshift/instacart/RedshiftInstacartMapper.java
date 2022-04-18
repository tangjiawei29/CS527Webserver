 package com.cs527.web.mapper.redshift.instacart;

 import org.apache.ibatis.annotations.Mapper;

 import java.util.LinkedHashMap;
 import java.util.List;

 @Mapper
 public interface RedshiftInstacartMapper {
     List<LinkedHashMap> exec(String sql);
 }
