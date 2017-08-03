package yingdg.exercise.springwebapp.service.alone;

import org.springframework.stereotype.Service;
import yingdg.exercise.springwebapp.service.MyTaskExecutor;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/7/28.
 */
@Service
public class MyStandAloneService {
    @Resource
    private MyTaskExecutor executor;

    public void aloneService() {
        executor.myExecute();
    }

}
