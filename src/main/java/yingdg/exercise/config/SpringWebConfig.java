package yingdg.exercise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yingdg on 2017/4/10.
 */

// SpringWeb 配置类
@Configuration
// 启用SpringMVC
@EnableWebMvc
// 导入Spring配置
@Import({SpringConfig.class})
public class SpringWebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        /*
        JSP
         */
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver(); // 一般解析JSP视图
//        viewResolver.setPrefix("./"); // 前缀
//        viewResolver.setSuffix(".jsp"); // 后缀
//        viewResolver.setViewClass(JstlView.class); // 转换为JSTL视图
        // viewResolver.setExposeContextBeansAsAttributes(true);

        // TilesViewResolver tilesViewResolver = new TilesViewResolver(); // 控制JSP页面布局

        /*
        Thymeleaf
         */
        // 视图解析器
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());

        return viewResolver;
    }

    /*
    配置Spring模板引擎
     */
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    /*
    配置模板解析器
     */
    @Bean
    public TemplateResolver templateResolver() {
        TemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("./");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }

    /*
     开启默认 Servlet 的支持，可用于处理静态文件
      */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /*
     配置 HttpMessageConverter，可配置多个自定义的 HttpMessageConverter
      */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonConverter());
    }

    /*
     配置自定义的 MappingJackson2HttpMessageConverter，
     用于处理 application/json 类型的 mediaType, 并添加了 application/xml 转 json 的支持
    */
    @Bean
    public MappingJackson2HttpMessageConverter jacksonConverter() {
        List<org.springframework.http.MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(org.springframework.http.MediaType.APPLICATION_XML);

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(mediaTypes);
        return converter;
    }

}
