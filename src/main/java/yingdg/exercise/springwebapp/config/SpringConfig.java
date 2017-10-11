package yingdg.exercise.springwebapp.config;

import org.springframework.context.annotation.*;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import yingdg.exercise.springwebapp.config.condition.SpringConditionConfig;
import yingdg.exercise.springwebapp.config.datasource.SpringDataSourceConfig;
import yingdg.exercise.springwebapp.config.hessian.SpringHessianConfig;
import yingdg.exercise.springwebapp.config.httpsession.SpringSessionConfig;
import yingdg.exercise.springwebapp.config.shiro.SpringShiroConfig;

import java.util.regex.Pattern;

/**
 * Created by yingdg on 2017/4/10.
 */

// Spring配置类，基本+ORM
@Configuration
// 指定环境便于切换，可配合VM参数-Dspring.profiles.active=dev
// @Profile("dev")
// 开启IOC
@ComponentScan(
        basePackages = {"yingdg.exercise.springwebapp"},
        // 懒加载，true时无法开启定时任务
        lazyInit = false,
        // 排除例外
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, value = {SpringConfig.WebPackage.class})})
// 开启AOP功能
@EnableAspectJAutoProxy(proxyTargetClass = true)
// 引入配置
@Import({
        // 数据源
        SpringDataSourceConfig.class,
        // 多线程
        SpringTheadConfig.class,
        // 定时
        SpringSchedulingConfig.class,
        // 条件实例化
        SpringConditionConfig.class,
        // 分布式Session
        SpringSessionConfig.class,
        // shiro安全认证
        SpringShiroConfig.class,
        // hession远程服务调用
        SpringHessianConfig.class
})
public class SpringConfig {

    // 扫描指定包以外的所有包（非必须配置）
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("yingdg.exercise\\.webapp"));
        }
    }

}
