package yingdg.exercise.springwebapp.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by yingdg on 2017/6/19.
 */
public class SpringWebInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("拦截器预处理");

        String servletPath = httpServletRequest.getServletPath();
        System.out.println(servletPath);

        // TODO，验证session，与SSO配合可用于登录验证
        return Objects.nonNull(httpServletRequest.getSession()) ? true : false;
    }

    /*
    preHandle返回true时调用，
    可以操作ModelAndView
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器后处理");
    }

    /*
    preHandle返回true时调用，
    主要用于清理资源
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("拦截器完成处理");
    }

}
