package yingdg.exercise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yingdg.exercise.config.SpringConfig;
import yingdg.exercise.model.User;

/**
 * Created by yingdg on 2017/4/10.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);

        User user = app.getBean(User.class);
        user.setId(1);
        user.setUsername("yingdg");
        user.setAge(25);
        System.out.println(user);
    }

}
