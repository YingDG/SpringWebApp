package yingdg.exercise.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import yingdg.exercise.springwebapp.config.SpringConfig;
import yingdg.exercise.springwebapp.config.condition.ICondition;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/7/28.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ConditionTest {
    @Resource
    private ApplicationContext context;

    @Test
    public void test() {
        ICondition condition = context.getBean(ICondition.class);
        condition.myCondition();
    }

}
