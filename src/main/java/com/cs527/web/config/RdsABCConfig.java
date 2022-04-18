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
		basePackages = "com.cs527.web.mapper.rds.abc",
		sqlSessionFactoryRef = "RdsABCSqlSessionFactory",
		sqlSessionTemplateRef = "RdsABCSqlSessionTemplate")
public class RdsABCConfig {


	@Bean(name = "RdsABCDataSource")
	// 表示这个数据源是默认数据源
	@Primary//这个一定要加，如果两个数据源都没有@Primary会报错
	@ConfigurationProperties(prefix = "spring.datasource.rds.abc")//我们配置文件中的前缀
	public DataSource getRdsABCDateSource() {
		return DataSourceBuilder.create().build();
	}


	@Bean(name = "RdsABCSqlSessionFactory")
	@Primary
	public SqlSessionFactory RdsABCSqlSessionFactory(@Qualifier("RdsABCDataSource") DataSource datasource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/rds/abc/*.xml"));
		return bean.getObject();// 设置mybatis的xml所在位置
	}


	@Bean("RdsABCSqlSessionTemplate")
	// 表示这个数据源是默认数据源
	@Primary
	public SqlSessionTemplate RdsABCSqlSessionTemplate(
			@Qualifier("RdsABCSqlSessionFactory") SqlSessionFactory sessionFactory) {
		return new SqlSessionTemplate(sessionFactory);
	}

}