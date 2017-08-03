package yingdg.exercise.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import yingdg.exercise.springwebapp.config.SpringWebConfig;
import yingdg.exercise.springwebapp.service.MyTaskExecutor;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/7/28.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringWebConfig.class)
public class TaskTest {
    @Resource
    private MyTaskExecutor executor;

    @Test
    public void test() {
        executor.myExecute();
    }

    @Test
    public void test2() {
        for (int i = 0; i < 20; i++) {
            executor.myAsyn();
            executor.myAsyn2();
        }
    }

}
