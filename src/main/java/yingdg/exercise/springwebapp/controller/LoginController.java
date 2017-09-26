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
        /*
        1.获取当前的subject，SecurityUtils.getSubject();
		2.判断当前用户是否已经被认证，subject。isAuthenticated();
		3.如果没有被认证，则需要把用户名和密码进行封装为UsernamePasswordToken;
			 3.1 创建一个提交页面
			 3.2 将用户名密码输入后提交到controller
			 3.3在controller中获取用户名、密码
		4.执行登录操作subject.login(token);
		5.最后登录信息会跳转realm中，在realm中进行获取数据的操作，并返回realm;
			5.1 如果只进行认证，则继承AuthenticatingRealm
			5.2实现getAuthenticationInfo回调方法
		6.由shiro完成密码的对比工作
         */
        try {
            Subject subject = SecurityUtils.getSubject();
            System.out.println("是否登录？：" + subject.isAuthenticated());

            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
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
