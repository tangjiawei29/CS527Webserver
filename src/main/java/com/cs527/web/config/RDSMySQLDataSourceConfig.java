package com.cs527.web.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2022-03-13 21:37
 * @description:
 */

@Configuration
public class RDSMySQLDataSourceConfig {

	@Bean(name = "RDSMySQLDataSource")
	public DataSource dataSource(){
		return DataSourceBuilder.create().type(MysqlDataSource.class).build();
	}
}
