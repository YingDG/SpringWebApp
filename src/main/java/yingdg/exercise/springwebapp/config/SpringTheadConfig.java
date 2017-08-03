package yingdg.exercise.springwebapp.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by yingdg on 2017/7/28.
 */
@Configuration
// 开启异步操作
@EnableAsync
public class SpringTheadConfig implements AsyncConfigurer {

    /*
   Spring多线程容器
    */
    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(40);
        executor.setKeepAliveSeconds(200);
        executor.setWaitForTasksToCompleteOnShutdown(true);

        return executor;
    }

    /*
    异步操作容器
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(40);
        executor.setKeepAliveSeconds(200);
        executor.setWaitForTasksToCompleteOnShutdown(true);

        executor.initialize(); // 不执行会有异常
        return executor;
    }

    /*
    异步操作异常处理
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}
