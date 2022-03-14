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
// @Configuration
// @MapperScan(
//         basePackages = "com.cs527.web.mapper",
//         sqlSessionFactoryRef = "sqlSessionFactoryRedshift",
//         sqlSessionTemplateRef = "sqlSessionTemplateRedshift")
// public class RedshiftConfig {
//     private DataSource redshiftDataSource;
//
//     public RedshiftConfig(@Qualifier("redshiftDataSource") DataSource redshiftDataSource) {
//         this.redshiftDataSource = redshiftDataSource;
//     }
//
//     @Bean
//     public SqlSessionFactory sqlSessionFactoryRedshift() throws Exception {
//         SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//         bean.setDataSource(redshiftDataSource);
//         return bean.getObject();
//     }
//
//     @Bean
//     public SqlSessionTemplate sqlSessionTemplateRedshift() throws Exception {
//         return new SqlSessionTemplate(sqlSessionFactoryRedshift());
//     }
// }
