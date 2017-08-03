package yingdg.exercise.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import yingdg.exercise.springwebapp.config.SpringConfig;
import yingdg.exercise.springwebapp.model.User;
import yingdg.exercise.springwebapp.repository.UserMapper;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/4/10.
 */
@WebAppConfiguration // Spring WebApp单元测试，否则报错
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
// @ActiveProfiles("dev")
@Transactional
public class SpringWebAppTest {
    @Resource
    private UserMapper mapper;
    @Resource
    private ApplicationContext app;

    @Ignore
    // @Test
    public void test() {
        User user = app.getBean(User.class);
        user.setId(1);
        user.setUsername("zdm");
        user.setAge(25);
        user.getUserInfo().setAdd("add");
        System.out.println(user.getUserInfo());
    }

    @Test
    public void test3() {
        User user = mapper.findUserById(2);
        System.out.println(user);
    }

    @Test
    @Rollback
    public void test4() {
        User user = new User("hello", 123);
        int i = mapper.createUser(user);
        if (i != 0) {
            System.out.println(user);
        }
    }

    @Test
    @Rollback
    public void test5() {
        int i = mapper.deleteUser(2);
        if (i != 0) {
            System.out.println("delete user");
        }
    }

}
