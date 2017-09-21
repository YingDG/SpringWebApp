package yingdg.exercise.springwebapp.config.shiro;

import com.google.common.collect.Lists;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyConfig;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yingdg on 2017/8/7.
 */
@Configuration
public class SpringShiroConfig {

    /*
    认证信息缓存配置
     */
//    @Bean
//    public CacheManager cacheManager() {
//        EhCacheManager cacheManager = new EhCacheManager();
//        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
//
//        return cacheManager;
//    }

    /*
    记住登录信息配置
     */
    @Bean
    public RememberMeManager rememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        Cookie cookie = new SimpleCookie();
        cookie.setMaxAge(120);
        rememberMeManager.setCookie(cookie);

        return rememberMeManager;
    }

    /*
    认证策略配置
     */
    @Bean
    public Authenticator authenticator(Realm userRealm) {
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        // 三种认证策略
        authenticator.setAuthenticationStrategy(new AllSuccessfulStrategy());
        // authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        // authenticator.setAuthenticationStrategy(new FirstSuccessfulStrategy());

        authenticator.setRealms(Lists.newArrayList(userRealm));

        return authenticator;
    }

    /*
    自定义用户信息验证配置
     */
    @Bean
    public Realm userRealm() {
        return new UserRealm();
    }

    /*
    安全认证管理配置
     */
    @Bean
    public SecurityManager securityManager(
            Realm userRealm,
            // CacheManager cacheManager,
            RememberMeManager rememberMeManager,
            Authenticator authenticator
    ) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // securityManager.setRealms(Lists.newArrayList(userRealm)); // 配置多个realm
        securityManager.setRealm(userRealm);
        // securityManager.setCacheManager(cacheManager);
        securityManager.setRememberMeManager(rememberMeManager);
        // securityManager.setAuthenticator(authenticator); // 如果使用该方法，则setRealm方法失效

        return securityManager;
    }

    /*
    shiro-spring核心过滤器
     */
    @Bean(name = "ShiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        // 要求登录时的链接
        filterFactoryBean.setLoginUrl("./loginpage");
        // 登录成功后要跳转的连接
        // filterFactoryBean.setSuccessUrl("./home.html");
        // 用户访问未对其授权的资源时,所显示的连接
        filterFactoryBean.setUnauthorizedUrl("/error.html");
        // 连接约束配置,即过滤链的定义
        filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap());

        return filterFactoryBean;
    }

    /*
    配置资源访问约束
     */
    private Map<String, String> filterChainDefinitionMap() {
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/loginpage", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/logout", "anon");
        filterChainDefinitionMap.put("/page/**", "authc");

        return filterChainDefinitionMap;
    }

    /*
     以下配置AOP式方法级权限检查，
     即可以使用注解进行拦截
     */
    @Bean
    public BeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public ProxyConfig advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);

        return advisorAutoProxyCreator;
    }

    @Bean
    public Pointcut authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);

        return authorizationAttributeSourceAdvisor;
    }

}
