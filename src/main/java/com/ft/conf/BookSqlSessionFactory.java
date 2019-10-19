package com.ft.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Author: fut
 * Time:   2019-10-19
 * Motto:  Work conscientiously and be a practical man.
 */

/**
 * basePackages：接口类所在的包路径
 * sqlSessionTemplateRef：接口类使用的SqlSessionTemplate
 * annotationClass：扫描包下所有接口类并注册
 */
@MapperScan(basePackages = {"com.ft.book.mapper"},
        sqlSessionTemplateRef = "sqlSessionTemplate",
        annotationClass = Repository.class)
@Configuration
public class BookSqlSessionFactory {

    private String mapperLocations = "classpath*:mapping/*Mapper.xml";

    @Value("${spring.mybatis.conf.file}")
    private String mybatisConfigFile;

    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Bean(name = "daupSqlSessionFactory")
    public SqlSessionFactory daupSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource(mybatisConfigFile));

        return sqlSessionFactoryBean.getObject();
    }

    /*定义事务控制*/
    @Bean(name="transactionManager")
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);

        return transactionManager;
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("daupSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
