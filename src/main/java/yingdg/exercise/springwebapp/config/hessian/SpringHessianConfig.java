package yingdg.exercise.springwebapp.config.hessian;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import yingdg.exercise.springwebapp.service.remote.IMessage;
import yingdg.exercise.springwebapp.service.remote.MessageImpl;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/10/11 0011.
 */
@Configuration
public class SpringHessianConfig {
    @Resource
    private MessageImpl message;

    /*
    服务端注册RMI Service
     */
    // name属性表示要调用的远程url，不能以./开头
    @Bean(name = "/remote/api/servletService")
    public HessianServiceExporter serviceExporter() {
        HessianServiceExporter serviceExporter = new HessianServiceExporter();
        // RMI接口
        serviceExporter.setServiceInterface(IMessage.class);
        // server端RMI接口实现类
        serviceExporter.setService(message);

        return serviceExporter;
    }

    /*
    客户端调用类
     */
    @Bean
    public HessianProxyFactoryBean hessianProxyFactoryBean() {
        HessianProxyFactoryBean hessianProxyFactoryBean = new HessianProxyFactoryBean();
        // 配置RMI url
        hessianProxyFactoryBean.setServiceUrl(
                "http://localhost:8080/SpringWebApp/remote/api/servletService");
        // 配置RMI接口（客户端的接口，即与服务端共用的接口）
        hessianProxyFactoryBean.setServiceInterface(
                yingdg.exercise.springwebapp.service.remote.client.IMessage.class);

        return hessianProxyFactoryBean;
    }

}
