package yingdg.exercise.springwebapp.service.remote;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/10/10 0010.
 */
@Service
public class MessageImpl implements IMessage {
    @Resource
    private MyMessage myMessage;

    @Override
    public void setMessage(String message) {
        myMessage.setMessage(message);
    }

    @Override
    public String sayHello() {
        return myMessage.toString();
    }

    @Override
    public String getMessage() {
        return myMessage.getMessage();
    }
}
