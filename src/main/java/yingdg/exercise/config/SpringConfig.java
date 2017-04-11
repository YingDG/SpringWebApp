package yingdg.exercise.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by yingdg on 2017/4/10.
 */

// Spring配置类
@Configuration
// 开启IOC与AOP
@ComponentScan(basePackages = {"yingdg.exercise"}, lazyInit = true, // 懒加载
        excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, value = {})}) // 排除例外
@EnableAspectJAutoProxy(proxyTargetClass = true)
// 配置文件加载
@PropertySource({"classpath:jdbc.properties"})
// 开启声明式事务
@EnableTransactionManagement
// Mapper配置扫描
@MapperScan(basePackages = "yingdg.exercise.repository")
public class SpringConfig {
    @Resource
    private Environment env;

    /*
    配置数据源
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        return dataSource;
    }

    /*
    配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /*
    配置sqlSessionFactory
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        sqlSessionFactory.setTypeAliasesPackage("yingdg.exercise.repository");
        // sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:*Mapper.xml"));
        return sqlSessionFactory;
    }

}
