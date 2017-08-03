package yingdg.exercise.springwebapp.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by yingdg on 2017/4/10.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class User {
    private int id;

    // 值校验
    @NotNull
    @NotEmpty
    @Size(min = 2, message = "至少2个字符！")
    private String username;
    @NotNull
    @Min(value = 10, message = "最小10岁！")
    private int age;
    @Resource
    // @Valid
    // @NotNull
    private UserInfo userInfo;

    public User() {

    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public final User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    @Value("hello")
    public final User setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getAge() {
        return age;
    }

    @Value("20")
    public final User setAge(int age) {
        this.age = age;
        return this;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", userInfo=" + userInfo +
                '}';
    }

}
