// package com.cs527.web.config;
//
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;
//
// import javax.sql.DataSource;
//
// @Configuration
// @PropertySource("classpath:application.properties")
// public class DataSourceConfig {
//     @Bean
//     @ConfigurationProperties(prefix = "spring.datasource.rds")
//     public DataSource rdsDataSource(){
//         return DataSourceBuilder.create().build();
//     }
//
//     @Bean
//     @ConfigurationProperties(prefix = "spring.datasource.redshift")
//     public DataSource redshiftDataSource(){
//         return DataSourceBuilder.create().build();
//     }
// }
