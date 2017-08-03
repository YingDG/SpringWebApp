package yingdg.exercise.springwebapp.service.condition;

/**
 * Created by yingdg on 2017/7/28.
 */
public class ConditionA implements ICondition {
    @Override
    public void myCondition() {
        System.out.println(this.getClass().getName() + " 条件A");
    }
}
