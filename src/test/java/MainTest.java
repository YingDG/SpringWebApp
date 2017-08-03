import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import yingdg.exercise.springwebapp.model.User;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by yingdg on 2017/6/20.
 */
public class MainTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = ClassUtils.getMethod(User.class, "setId", int.class);
        System.out.println(method.getName());

        Method method1 = User.class.getMethod("setId", int.class);
        System.out.println(method1.getName());

        System.out.println(ObjectUtils.isEmpty(""));
        System.out.println(ObjectUtils.isEmpty(new ArrayList<>()));
        System.out.println(ObjectUtils.isEmpty(null));

        System.out.println(StringUtils.uncapitalize("HELLO"));

        PropertyDescriptor descriptor = BeanUtils.getPropertyDescriptor(User.class, "username");
        System.out.println(descriptor.getReadMethod().getName());
        System.out.println(descriptor.getWriteMethod().getName());
    }
}
