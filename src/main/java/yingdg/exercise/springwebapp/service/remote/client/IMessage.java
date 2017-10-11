package yingdg.exercise.springwebapp.service.remote.client;

/**
 * Created by yingdg on 2017/10/10 0010.
 */
public interface IMessage {
    void setMessage(String message);

    String sayHello();

    String getMessage();
}
