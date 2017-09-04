package yingdg.exercise.springwebapp.config.httpsession;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by yingdg on 2017/9/4 0004.
 */
public class SpringSessionInitializer extends AbstractHttpSessionApplicationInitializer {
    /*
    用于向Servlet容器中添加springSessionRepositoryFilter

    注：不写这个空类不会开启redis session功能？
     */
}
