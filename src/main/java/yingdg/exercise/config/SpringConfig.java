package yingdg.exercise.config;

import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by yingdg on 2017/4/10.
 */

// Spring配置类，基本+ORM
@Configuration
// 指定环境便于切换
// @Profile("dev")
// 开启IOC与AOP
@ComponentScan(basePackages = {"yingdg.exercise"}, lazyInit = true, // 懒加载
        excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, value = {SpringConfig.WebPackage.class})})
// 排除例外
@EnableAspectJAutoProxy(proxyTargetClass = true)
// 配置文件加载
@PropertySource({"classpath:jdbc.properties"})
// 开启声明式事务
@EnableTransactionManagement
// Mybatis Mapper配置扫描
@MapperScan(basePackages = "yingdg.exercise.repository")
public class SpringConfig {
    @Resource
    private Environment env;// Spring环境配置类

    /*
    配置数据源
     */
    @Bean
    @Primary
    // @Profile("dev")
    public DataSource dataSource() {
        // Spring数据源管理（非连接池）
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        return dataSource;
    }

    /*
    JNDI数据源

    Tomcat:
    server.xml下 <GlobalNamingResources></GlobalNamingResources>中的配置
    <Resource
        name="jdbc/DBPool"
        auth="Container"
        description="DB Connection"
        driverClass="Oracle.jdbc.driver.OracleDriver"
        maxPoolSize="50"
        minPoolSize="2"
        initialPoolSize="5"
        maxIdleTime="60"
        autoCommitOnClose="true"
        acquireIncrement="3"
        name="jdbc/DBPool"
        user="root"
        password="123456"
        jdbcUrl="jdbc:oracle:thin:@192.168.120.165:1521:orcl10"
        factory="org.apache.naming.factory.BeanFactory"
        type="com.mchange.v2.c3p0.ComboPooledDataSource"
        />

        context.xml下<Context></Context>中的配置
        <ResourceLink global="jdbc/DBPool" name="jdbc/DBPool" type="javax.sql.DataSource" />
     */
//    @Bean
//    public JndiObjectFactoryBean jndiDataSource() {
//        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("jdbc/DBPool");
//        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(DataSource.class);
//
//        return jndiObjectFactoryBean;
//    }

    /*
    配置事务管理器
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        // jdbc事务
        return new DataSourceTransactionManager(dataSource);
    }

    /*
    配置sqlSessionFactory
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        // Mybatis SqlSession
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(
//                ApplicationContext.CLASSPATH_ALL_URL_PREFIX + "*Mapper.xml"));
        // mybatis sql
        sqlSessionFactory.setConfiguration(mybatisSql());

        return sqlSessionFactory;
    }

    /*
    打印sql语句
     */
    @Bean
    public org.apache.ibatis.session.Configuration mybatisSql() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(StdOutImpl.class);

        return configuration;
    }

    // 扫描指定包以外的所有包（非必须配置）
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("yingdg.exercise\\.webapp"));
        }
    }

}
