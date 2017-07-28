package yingdg.exercise.service.condition;

import org.springframework.stereotype.Service;

/**
 * Created by yingdg on 2017/7/28.
 */
public class ConditionA implements ICondition {
    @Override
    public void myCondition() {
        System.out.println(this.getClass().getName() + " 条件A");
    }
}
