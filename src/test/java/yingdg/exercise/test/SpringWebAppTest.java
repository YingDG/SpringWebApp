package yingdg.exercise.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import yingdg.exercise.config.SpringConfig;
import yingdg.exercise.model.Info;
import yingdg.exercise.model.User;
import yingdg.exercise.repository.UserMapper;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/4/10.
 */
@WebAppConfiguration // Spring WebApp单元测试，否则报错
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class SpringWebAppTest {
    @Resource
    private UserMapper mapper;
    @Resource
    private User user;

    @Test
    public void test() {
        user.setId(1);
        user.setUsername("zdm");
        user.setAge(25);
        user.getInfo().setAdd("add");
        System.out.println(user.getInfo());
    }

    @Ignore
    public void test3() {
        User user = mapper.findUserById(2);
        System.out.println(user);
    }

}
