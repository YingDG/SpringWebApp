import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import yingdg.exercise.springwebapp.config.SpringConfig;
import yingdg.exercise.springwebapp.model.User;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/7/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@WebAppConfiguration
public class ModelTest {
    @Resource
    private User user;

    @Test
    public void test(){
        System.out.println(user);

        user.setId(1).setUsername("adf").setAge(24);
        System.out.println(user);

        User user1 = new User().setId(10).setUsername("haha").setAge(30);
        System.out.println(user1);
    }

}
