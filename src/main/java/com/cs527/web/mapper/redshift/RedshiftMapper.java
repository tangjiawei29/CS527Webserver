 package com.cs527.web.mapper.redshift;

 import org.apache.ibatis.annotations.Mapper;
 import org.springframework.stereotype.Repository;

 import java.util.LinkedHashMap;
 import java.util.List;

 @Mapper
 public interface RedshiftMapper {
     List<LinkedHashMap> exec(String sql);
 }
