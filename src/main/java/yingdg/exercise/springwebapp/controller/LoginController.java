package yingdg.exercise.springwebapp.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import yingdg.exercise.springwebapp.model.User;

/**
 * Created by yingdg on 2017/9/21 0021.
 */
@Controller
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class LoginController {

    @GetMapping(value = "/loginpage")
    public String loginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public User login(String username, String password) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);

            System.out.println("登录？：" + subject.isAuthenticated());
        } catch (UnknownAccountException e) {
            e.printStackTrace();
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
        } catch (LockedAccountException e) {
            e.printStackTrace();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        return new User(username, Integer.parseInt(password));
    }

    @GetMapping(value = "/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "./home.html";
    }

}
