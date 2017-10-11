package yingdg.exercise.springwebapp.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import yingdg.exercise.springwebapp.config.SpringConfig;
import yingdg.exercise.springwebapp.service.remote.client.IClientMessage;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/10/11 0011.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class HessianTest {
    // @Resource会出注入失败？
    @Resource
    // @Autowired
    // @Qualifier("hessianProxyFactoryBean")
    private HessianProxyFactoryBean hessianProxyFactoryBean;

    /*
    Spring整合Hessian后可直接实例化接口代理类
     */
    @Resource
    private IClientMessage clientMessage;

    /*
    不建议使用
     */
    @Before
    public void initHessian() {
        IClientMessage message = (IClientMessage) hessianProxyFactoryBean.getObject();
        message.setMessage("hessian client");
        System.out.println(message.sayHello());
    }

    @Test
    public void testHessianClient() {
        System.out.println(clientMessage.toString()); // HessianProxy[http://localhost:8080/SpringWebApp/remote/api/servletService]

        clientMessage.setMessage("hello hessian");
        System.out.println(clientMessage.sayHello());
    }

}
