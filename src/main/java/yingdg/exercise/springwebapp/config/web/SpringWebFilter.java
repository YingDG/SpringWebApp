package yingdg.exercise.springwebapp.config.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

/**
 * Created by yingdg on 2017/4/10.
 */
// Spring WebApp 过滤器注册
public class SpringWebFilter implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        /*
         设置编码
          */
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8", true);
        FilterRegistration.Dynamic springEncodingFilter = servletContext.addFilter("SpringEncodingFilter", encodingFilter);
        springEncodingFilter.addMappingForUrlPatterns(null, false, "/*");

        /*
         支持表单Rest请求提交
          */
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        FilterRegistration.Dynamic springHiddenHttpMethodFilter = servletContext.addFilter("HiddenHttpMethodFilter", hiddenHttpMethodFilter);
        springHiddenHttpMethodFilter.addMappingForUrlPatterns(null, false, "/*");

        // 文件上传参数设置（暂不需要）
//        DispatcherServlet fileDispatcherServlet = new DispatcherServlet();
//        ServletRegistration.Dynamic fileUploadRegistration = servletContext.addServlet("fileServlet", fileDispatcherServlet);
//        fileUploadRegistration.addMapping("/*");
//        fileUploadRegistration.setMultipartConfig(
//                new MultipartConfigElement("/uploads", 2097152, 4194304, 0));

        /*
        配置shiro拦截
         */
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
        // false,表示生命周期由SpringApplicationContext管理,设置为true则表示由servlet container管理
        delegatingFilterProxy.setTargetFilterLifecycle(true);
        // 注意！拦截器需要和spring配置中的ShiroFilterFactoryBean的beanname保持一致
        FilterRegistration.Dynamic shiroFilter = servletContext.addFilter("ShiroFilter", delegatingFilterProxy);
        shiroFilter.addMappingForUrlPatterns(null, false, "/*");
    }

}
