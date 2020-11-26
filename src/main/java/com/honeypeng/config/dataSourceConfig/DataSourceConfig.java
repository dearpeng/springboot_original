package com.honeypeng.config.dataSourceConfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PengWX on 2020/11/25.
 */
@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource1.url}")
    private String url;
    @Value("${spring.datasource1.username}")
    private String username;
    @Value("${spring.datasource1.password}")
    private String password;
    @Value("${spring.datasource1.driver-class-name}")

    private String driverClassName;
    @Value("${spring.datasource2.url}")
    private String url2;
    @Value("${spring.datasource2.username}")
    private String username2;
    @Value("${spring.datasource2.password}")
    private String password2;
    @Value("${spring.datasource2.driver-class-name}")
    private String driverClassName2;


    //创建数据源
    @Bean(name = "ds1")
    @Primary
    public DataSource getFirstDataSource() {
        DataSource build =  DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
        return build;
    }
    //创建数据源
    @Bean(name = "ds2")
    public DataSource getSecondDataSource() {
        DataSource build =  DataSourceBuilder.create()
                .driverClassName(driverClassName2)
                .url(url2)
                .username(username2)
                .password(password2)
                .build();
        return build;
    }

    /**
     * 创建多个数据源 ds1 和 ds2
     * 此处的Primary，是设置一个Bean的优先级
     *
     * @return
     */
    /*@Primary
    @Bean(name = "ds1")
    @ConfigurationProperties(prefix = "spring.datasource1")
    public DataSource getDateSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource getDateSource2() {
        return DataSourceBuilder.create().build();
    }*/
    /**
     * 将多个数据源注入到DynamicDataSource
     * @param dataSource1
     * @param dataSource2
     * @return
     */
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource DataSource(@Qualifier("ds1") DataSource dataSource1,
                                        @Qualifier("ds2") DataSource dataSource2) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put("ds1", dataSource1);
        targetDataSource.put("ds2", dataSource2);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(dataSource1);
        return dataSource;
    }


    /**
     * 2、根据数据源创建SqlSessionFactory
     * @throws Exception
     */
    @Bean(name="sessionFactory")
    public SqlSessionFactory sessionFactory(@Qualifier("dynamicDataSource")DynamicDataSource dataSource) throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/honeypeng/mapper/*.xml"));    //*Mapper.xml位置
        return sessionFactoryBean.getObject();
    }
}
