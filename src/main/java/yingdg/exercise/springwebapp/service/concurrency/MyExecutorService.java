package yingdg.exercise.springwebapp.service.concurrency;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yingdg on 2017/7/28.
 * <p>
 * 并发服务
 */
@Service
public class MyExecutorService {
    @Resource
    private MyTaskExecutor executor;

    public void aloneService() {
        executor.myExecute();
    }

}
