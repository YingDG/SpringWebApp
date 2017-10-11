package yingdg.exercise.springwebapp.service.remote.client;

import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;

/**
 * Created by yingdg on 2017/10/11 0011.
 */
public class HelloHessian {
    private static final String URL = "http://localhost:8080/SpringWebApp/remote/api/servletService";

    public static void main(String[] args) throws MalformedURLException {
        HessianProxyFactory proxyFactory = new HessianProxyFactory();
        IMessage message = (IMessage) proxyFactory.create(IMessage.class, URL);

        message.setMessage("hello");
        System.out.println(message.sayHello());
    }
}
