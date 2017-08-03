package yingdg.exercise.springwebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import yingdg.exercise.springwebapp.service.condition.ConditionA;
import yingdg.exercise.springwebapp.service.condition.ConditionAJudge;
import yingdg.exercise.springwebapp.service.condition.ConditionB;
import yingdg.exercise.springwebapp.service.condition.ConditionBJudge;

/**
 * Created by yingdg on 2017/7/28.
 */
@Configuration
public class SpringConditionConfig {

    @Bean
    @Conditional(ConditionAJudge.class)
    public ConditionA conditionA() {
        return new ConditionA();
    }

    @Bean
    @Conditional(ConditionBJudge.class)
    public ConditionB conditionB() {
        return new ConditionB();
    }

}
