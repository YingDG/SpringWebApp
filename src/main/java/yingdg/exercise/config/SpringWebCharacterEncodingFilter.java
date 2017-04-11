package yingdg.exercise.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by yingdg on 2017/4/10.
 */
public class SpringWebCharacterEncodingFilter implements WebApplicationInitializer {

    /*
        设置编码
         */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8", true);
        FilterRegistration.Dynamic springEncodingFilter = servletContext.addFilter("SpringEncodingFilter", encodingFilter);
        springEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }

}
