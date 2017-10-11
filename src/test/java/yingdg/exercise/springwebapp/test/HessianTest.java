package yingdg.exercise.springwebapp.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import yingdg.exercise.springwebapp.config.SpringConfig;
import yingdg.exercise.springwebapp.service.remote.client.IMessage;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/10/11 0011.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class HessianTest {
    /*
    web.xml中有配置：<servlet-name>remote</servlet-name>
    所以remote-servlet.xml的文件名必须以<servlet-name>中配置的servlet-name作为文件名的开头，
    且文件名的格式必须是[servlet-name]-servlet.xml格式，否则检测不到。即:
    <param-value>classes/remote-servlet</param-value>
     */

    // @Resource会出注入失败？
    // @Resource
    @Autowired
    // @Qualifier("hessianProxyFactoryBean")
    private HessianProxyFactoryBean hessianProxyFactoryBean;

    @Before
    public void initHessian() {
        hessianProxyFactoryBean.setHessian2(true);
    }

    @Test
    public void testHessianClient() {
        IMessage message = (IMessage) hessianProxyFactoryBean.getObject();

        message.setMessage("hessian client");
        System.out.println(message.sayHello());
    }

}
