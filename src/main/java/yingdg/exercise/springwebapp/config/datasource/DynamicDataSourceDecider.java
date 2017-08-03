package yingdg.exercise.springwebapp.config.datasource;

/**
 * Created by yingdg on 2017/6/22.
 */
public abstract class DynamicDataSourceDecider {
    //写库对应的数据源key
    private static final String MASTER_DB = "master";
    //读库对应的数据源key
    private static final String SLAVE_DB = "slave";
    //使用ThreadLocal记录当前线程的数据源key
    private static final ThreadLocal<String> Decider = new ThreadLocal<String>();

    /*
     * 设置数据源key
     */
    public static void putDataSourceKey(String key) {
        Decider.set(key);
    }

    /*
     * 获取数据源key
     */
    public static String getDataSourceKey() {
        return Decider.get();
    }

    /*
     * 标记写库
     */
    public static void markMaster(){
        putDataSourceKey(MASTER_DB);
    }

    /*
     * 标记读库
     */
    public static void markSlave(){
        putDataSourceKey(SLAVE_DB);
    }

}
