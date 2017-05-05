package yingdg.exercise.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by yingdg on 2017/4/17.
 */
@Component
// session级别
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserInfo {
    private String add;

    public UserInfo() {

    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "Info{" +
                "add='" + add + '\'' +
                '}';
    }

}
