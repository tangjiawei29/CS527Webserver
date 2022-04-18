 package com.cs527.web.mapper.redshift.abc;

 import org.apache.ibatis.annotations.Mapper;

 import java.util.LinkedHashMap;
 import java.util.List;

 @Mapper
 public interface RedshiftABCMapper {
     List<LinkedHashMap> exec(String sql);
 }
