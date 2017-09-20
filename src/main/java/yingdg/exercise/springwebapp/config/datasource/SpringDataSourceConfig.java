package yingdg.exercise.springwebapp.config.datasource;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import yingdg.exercise.springwebapp.config.datasource.dynamic.DynamicDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by yingdg on 2017/9/20 0020.
 */
@Configuration
// 配置文件加载
@PropertySource({"classpath:jdbc.properties"})
// 开启声明式事务
@EnableTransactionManagement
// Mybatis Mapper配置扫描
@MapperScan(basePackages = "yingdg.exercise.springwebapp.repository")
public class SpringDataSourceConfig {
    /*
    Spring环境参数配置类
     */
    @Resource
    private Environment env;

    /*
    配置数据源
     */
    @Bean
    // @Primary
    public DataSource masterDataSource() {
        // Spring数据源管理（非连接池）
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        return dataSource;
    }

    /*
    配置数据源
     */
    @Bean
    public DataSource slaveDataSource() {
        // Spring数据源管理（非连接池）
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        return dataSource;
    }

    /*
    自定义动态数据源，
    以实现主从分离等业务场景
     */
    @Bean
    public DataSource dataSource(DataSource masterDataSource, DataSource slaveDataSource) {
        DynamicDataSource dataSource = new DynamicDataSource();

        // 注册数据源
        Map<Object, Object> dbMap = new HashMap<>();
        dbMap.put("master", masterDataSource);
        dbMap.put("slave", slaveDataSource);
        dataSource.setTargetDataSources(dbMap);

        // 配置默认数据源
        dataSource.setDefaultTargetDataSource(masterDataSource);

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
    配置SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        // Mybatis SqlSession
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setTypeAliasesPackage("yingdg.exercise.model");
//        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(
//                ApplicationContext.CLASSPATH_ALL_URL_PREFIX + "*Mapper.xml"));

        // 添加分页插件
        Properties properties = new Properties();
        // properties.put("helperDialect", "mysql");
        // properties.put("reasonable", true);
        // properties.put("supportMethodsArguments", true);
        // properties.put("closeConn", false);
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(properties);
        sqlSessionFactory.setPlugins(new Interceptor[]{pageInterceptor});

        // mybatis sql打印
        sqlSessionFactory.setConfiguration(mybatisConfig());

        return sqlSessionFactory.getObject();
    }

    /*
    Mybatis自定义配置
     */
    @Bean
    public org.apache.ibatis.session.Configuration mybatisConfig() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        // 打印sql语句
        configuration.setLogImpl(StdOutImpl.class);
        // 插入数据时返回主键
        // configuration.setUseGeneratedKeys(true);
        // 排除null值
        configuration.setCallSettersOnNulls(true);

        return configuration;
    }

}
