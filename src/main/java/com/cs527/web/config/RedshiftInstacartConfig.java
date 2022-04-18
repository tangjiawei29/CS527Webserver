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
@MapperScan(basePackages = "com.cs527.web.mapper.redshift.instacart",
			sqlSessionFactoryRef = "RedshiftInstacartSqlSessionFactory",
			sqlSessionTemplateRef = "RedshiftInstacartSqlSessionTemplate")
public class RedshiftInstacartConfig {

	@Bean(name = "RedshiftInstacartDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.redshift.instacart")
	public DataSource getRedshiftInstacartDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "RedshiftInstacartSqlSessionFactory")
	public SqlSessionFactory RedshiftInstacartSqlSessionFactory(@Qualifier("RedshiftInstacartDataSource") DataSource datasource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/redshift/instacart/*.xml"));
		return bean.getObject();// 设置mybatis的xml所在位置
	}

	@Bean("RedshiftInstacartSqlSessionTemplate")
	public SqlSessionTemplate RedshiftInstacartSqlSessionTemplate(
			@Qualifier("RedshiftInstacartSqlSessionFactory") SqlSessionFactory sessionFactory) {
		return new SqlSessionTemplate(sessionFactory);
	}

}
