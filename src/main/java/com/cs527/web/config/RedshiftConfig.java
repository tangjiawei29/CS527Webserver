 package com.cs527.web.config;

 import org.apache.ibatis.session.SqlSessionFactory;
 import org.mybatis.spring.SqlSessionFactoryBean;
 import org.mybatis.spring.SqlSessionTemplate;
 import org.mybatis.spring.annotation.MapperScan;
 import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.boot.context.properties.ConfigurationProperties;
 import org.springframework.boot.jdbc.DataSourceBuilder;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

 import javax.sql.DataSource;
 @Configuration
 @MapperScan(basePackages = "com.cs527.web.mapper", sqlSessionFactoryRef = "SecondarySqlSessionFactory")
 public class RedshiftConfig {

     @Bean(name = "redshiftDataSource1")
     @ConfigurationProperties(prefix = "spring.datasource.redshift")
     public DataSource getSecondaryDataSource() {
         return DataSourceBuilder.create().build();
     }
     @Bean(name = "SecondarySqlSessionFactory")
     public SqlSessionFactory redshiftSqlSessionFactory(@Qualifier("redshiftDataSource1") DataSource datasource)
             throws Exception {
         SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
         bean.setDataSource(datasource);
         bean.setMapperLocations(
                 new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/*.xml"));
         return bean.getObject();// 设置mybatis的xml所在位置
     }
     @Bean("redshiftSqlSessionTemplate1")
     public SqlSessionTemplate redshiftSqlSessionTemplate(
             @Qualifier("SecondarySqlSessionFactory") SqlSessionFactory sessionfactory) {
         return new SqlSessionTemplate(sessionfactory);
     }

 }
