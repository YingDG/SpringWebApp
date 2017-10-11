package yingdg.exercise.springwebapp.service.remote;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by yingdg on 2017/10/10 0010.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MyMessage implements Serializable {
    private static final long serialVersionUID = 8269970138187157375L;

    private String message;

    public MyMessage() {

    }

    public MyMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "message='" + message + '\'' +
                '}';
    }

}
