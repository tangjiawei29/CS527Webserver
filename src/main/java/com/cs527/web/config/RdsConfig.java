// package com.cs527.web.config;
//
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.mybatis.spring.SqlSessionFactoryBean;
// import org.mybatis.spring.SqlSessionTemplate;
// import org.mybatis.spring.annotation.MapperScan;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// import javax.sql.DataSource;
//
// @Configuration
// @MapperScan(
//         basePackages = "com.cs527.web.mapper",
//         sqlSessionFactoryRef = "sqlSessionFactoryRds",
//         sqlSessionTemplateRef = "sqlSessionTemplateRds")
// public class RdsConfig {
//     private DataSource rdsDataSource;
//
//     public RdsConfig(@Qualifier("rdsDataSource") DataSource rdsDataSource) {
//         this.rdsDataSource = rdsDataSource;
//     }
//
//     @Bean
//     public SqlSessionFactory sqlSessionFactoryRds() throws Exception {
//         SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//         bean.setDataSource(rdsDataSource);
//         return bean.getObject();
//     }
//
//     @Bean
//     public SqlSessionTemplate sqlSessionTemplateRds() throws Exception {
//         return new SqlSessionTemplate(sqlSessionFactoryRds());
//     }
// }