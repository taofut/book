package com.ft.conf;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Author: fut
 * Time:   2019-10-18
 * Motto:  Work conscientiously and be a practical man.
 */
@Data
@Slf4j
@Configuration
public class DataSourceConfiguration {

    /**
     * 读取配置文件里的数据库配置属性并注入到DataSource对应属性中
     * 注意："spring.datasource"后面的属性名称跟DataSource属性一一对应
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        if (log.isInfoEnabled()) {
            log.info("正在初始化数据源{spring.datasource}");
        }
        return new DruidDataSource();
    }

}
