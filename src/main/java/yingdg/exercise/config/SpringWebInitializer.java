package yingdg.exercise.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by yingdg on 2017/4/10.
 */
// web.xml主入口
public class SpringWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
    Spring 的根配置
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    /*
    SpringMVC DispatcherServlet 的 配置类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{SpringWebConfig.class};
    }

    /*
    配置 SpringMVC 的拦截路径
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
