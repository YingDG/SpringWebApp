package yingdg.exercise.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

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

    /*
    Filter
     */
//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[]{};
//    }

    /*
    Multipart文件上传
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/uploads", 2097152, 4194304, 0));
    }

}
