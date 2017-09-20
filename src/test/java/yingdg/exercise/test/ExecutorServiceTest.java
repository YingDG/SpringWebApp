package yingdg.exercise.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yingdg.exercise.springwebapp.config.SpringConfig;
import yingdg.exercise.springwebapp.service.concurrency.MyExecutorService;

/**
 * Created by yingdg on 2017/7/28.
 * <p>
 * applicationContextAware测试
 */
public class ExecutorServiceTest {
    private static AnnotationConfigApplicationContext context;
    @Autowired
    private MyExecutorService service;

    static {
        context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.start();
        context.registerShutdownHook();
    }

    public ExecutorServiceTest() {
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Test
    public void test() {
        service.aloneService();
    }

}
