package yingdg.exercise.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by yingdg on 2017/4/17.
 */
@Component
@Scope("prototype")
public class Info {
    private String add;

    private Info() {

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
