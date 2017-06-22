package yingdg.exercise.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by yingdg on 2017/6/22.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    /*
    定义动态数据源，实现通过集成Spring提供的AbstractRoutingDataSource，
    只需要实现determineCurrentLookupKey方法即可
    由于DynamicDataSource是单例的，线程不安全的，
    可以采用ThreadLocal保证线程安全，由DynamicDataSourceDecider完成
     */
    @Override
    protected Object determineCurrentLookupKey() {
        // 使用DynamicDataSourceDecider保证线程安全，并且得到当前线程中的数据源key
        return DynamicDataSourceDecider.getDataSourceKey();
    }
}
