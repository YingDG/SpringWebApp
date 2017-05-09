package yingdg.exercise.model.validator;

import yingdg.exercise.model.User;
import yingdg.exercise.model.UserInfo;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by yingdg on 2017/5/9.
 */
public class HelloValidator {
    public static void main(String[] args) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        User user = new User("z", 6);
        UserInfo userInfo = new UserInfo("");
        user.setUserInfo(userInfo);

        Set<ConstraintViolation<User>> validateInfo = validator.validate(user);
        System.out.println(validateInfo);
        for (ConstraintViolation constraintViolation : validateInfo) {
            // 异常类
            System.out.println(constraintViolation.getRootBeanClass().getName());
            // 异常属性
            System.out.println(constraintViolation.getPropertyPath());
            // 异常信息
            System.out.println(constraintViolation.getMessage());
        }
    }
}
