package yingdg.exercise.springwebapp.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by yingdg on 2017/9/26 0026.
 */
@Component
public class CustomizedPropertyConfigurer extends PropertyPlaceholderConfigurer {

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);

        // 加载自定义静态变量
        initStaticProps(props);
    }

    private void initStaticProps(Properties props) {
        // TODO
    }

}
