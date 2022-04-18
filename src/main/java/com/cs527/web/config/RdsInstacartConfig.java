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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(
		basePackages = "com.cs527.web.mapper.rds.instacart",
		sqlSessionFactoryRef = "RdsInstacartSqlSessionFactory",
		sqlSessionTemplateRef = "RdsInstacartSqlSessionTemplate")
public class RdsInstacartConfig {

	@Bean(name = "RdsInstacartDataSource")
	// 表示这个数据源是默认数据源
	@Primary//这个一定要加，如果两个数据源都没有@Primary会报错
	@ConfigurationProperties(prefix = "spring.datasource.rds.instacart")//我们配置文件中的前缀
	public DataSource getRdsInstacartDateSource() {
		return DataSourceBuilder.create().build();
	}


	@Bean(name = "RdsInstacartSqlSessionFactory")
	@Primary
	public SqlSessionFactory RdsInstacartSqlSessionFactory(@Qualifier("RdsInstacartDataSource") DataSource datasource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/rds/instacart/*.xml"));
		return bean.getObject();// 设置mybatis的xml所在位置
	}


	@Bean("RdsInstacartSqlSessionTemplate")
	// 表示这个数据源是默认数据源
	@Primary
	public SqlSessionTemplate RdsInstacartSqlSessionTemplate(
			@Qualifier("RdsInstacartSqlSessionFactory") SqlSessionFactory sessionFactory) {
		return new SqlSessionTemplate(sessionFactory);
	}

}