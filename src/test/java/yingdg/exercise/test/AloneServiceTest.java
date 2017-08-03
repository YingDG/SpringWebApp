package yingdg.exercise.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yingdg.exercise.springwebapp.config.SpringConfig;
import yingdg.exercise.springwebapp.service.alone.MyStandAloneService;

/**
 * Created by yingdg on 2017/7/28.
 */
public class AloneServiceTest {
    private static AnnotationConfigApplicationContext context;
    @Autowired
    private MyStandAloneService service;

    static {
        context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.start();
        context.registerShutdownHook();
    }

    public AloneServiceTest() {
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Test
    public void test() {
        service.aloneService();
    }

}
