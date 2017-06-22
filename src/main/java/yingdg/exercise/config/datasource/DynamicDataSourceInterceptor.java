package yingdg.exercise.config.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by yingdg on 2017/6/22.
 */
@Service
@Aspect
@Order(-9999) // 定义执行顺序，-9999表示最优先级
// 定义数据源的AOP切面，通过方法名判断是应该走读库还是写库
public class DynamicDataSourceInterceptor {
    @Pointcut("execution(* yingdg.exercise.repository.*.*(..))")
    public void convertDB() {
    }

    /*
     * 在进入Service方法之前执行
     */
    @Before("convertDB()")
    public void before(JoinPoint point) {
        // 获取到当前执行的方法名
        String methodName = point.getSignature().getName();
        if (isSlave(methodName)) {
            System.out.println("读库");
            // 标记为读库
            DynamicDataSourceDecider.markSlave();
        } else {
            System.out.println("写库");
            // 标记为写库
            DynamicDataSourceDecider.markMaster();
        }
    }

    /*
     * 判断是否为读库
     */
    private boolean isSlave(String methodName) {
        // 方法名以find开头的方法名走从库
        return StringUtils.startsWithIgnoreCase(methodName, "find");
    }

}
